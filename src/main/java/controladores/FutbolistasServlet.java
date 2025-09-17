package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Equipo;
import clases.Futbolista;
import clases.Pais;
import fabrica.DAOFactory;
import interfaces.IEquipoDAO;
import interfaces.IFutbolistaDAO;
import interfaces.IPaisDAO;


/**
 * Servlet implementation class FutbolistasServlet
 */
@WebServlet(name = "futbolistas", urlPatterns = { "/futbolistas" })
public class FutbolistasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IFutbolistaDAO futbolistaDAO;
       private IEquipoDAO equipoDAO;
       private IPaisDAO paisDAO;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FutbolistasServlet() {
        super();
      this.futbolistaDAO = DAOFactory.getDAOFactory().getFutbolistaDAO();
      
      this.equipoDAO = DAOFactory.getDAOFactory().getEquipoDAO();
      
      this.paisDAO = DAOFactory.getDAOFactory().getPaisDAO();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = "";
		
		if(request.getParameter("opcion")!= null)
			opcion = request.getParameter("opcion");
		
		switch (opcion) {
		case "lista": 
			this.lista(request, response);
			break;
		case "editar":
			this.editar(request, response);
			break;
			
		case "registrar":
		this.registrar(request, response);
		break;
		
		case "eliminar":
			this.eliminar(request, response);
		break;
		default:
			this.lista(request, response);
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Futbolista> lista = this.futbolistaDAO.listar();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/futbolistas/futbolista_lista.jsp").forward(request, response);
		
	}
	
	//--------------------
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Futbolista futbolista = new Futbolista();
		
		if(request.getParameter("id") != null) {
			int futbolistaId =Integer.parseInt(request.getParameter("id"));
			
			futbolista = this.futbolistaDAO.obtener(futbolistaId);
			
			if(futbolista == null) {
				futbolista = new Futbolista();
			}
		}
		//se traen los fk
		ArrayList<Equipo> equipos = this.equipoDAO.listar();
		ArrayList<Pais> paises = this.paisDAO.listar();
		
		//se ponen en el editar
		request.setAttribute("registro", futbolista);
		request.setAttribute("listaEquipos", equipos);
		request.setAttribute("listaPaises", paises);
		
		//ponerlo en la web
		
		request.getRequestDispatcher("/futbolistas/futbolista_editar.jsp").forward(request, response);
	}
	
	
	//-------------
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Obtener parámetros con valores por defecto
	    int futbolistaId = request.getParameter("futbolistaId") != null ? Integer.parseInt(request.getParameter("futbolistaId")) : 0;
	    
	    int paisId = request.getParameter("paisId") != null ? Integer.parseInt(request.getParameter("paisId")) : 0;
	    
	    String nombres = request.getParameter("nombres") != null ? request.getParameter("nombres") : "";
	    
	    String apellidos = request.getParameter("apellidos") != null ? request.getParameter("apellidos") : "";
	    
	    int goles = request.getParameter("goles") != null ? Integer.parseInt(request.getParameter("goles")) : 0;
	    
	    int asistencias = request.getParameter("asistencias") != null ? Integer.parseInt(request.getParameter("asistencias")) : 0;
	    
	    int partidos = request.getParameter("partidos") != null ? Integer.parseInt(request.getParameter("partidos")) : 0;
	    
	    String puesto = request.getParameter("puesto") != null ? request.getParameter("puesto") : "";
	    
	    int edad = request.getParameter("edad") != null ? Integer.parseInt(request.getParameter("edad")) : 0;
	    
	    int equipoId = request.getParameter("equipoId") != null ? Integer.parseInt(request.getParameter("equipoId")) : 0;

	    
	    Futbolista futbolista = new Futbolista(futbolistaId, paisId, nombres, apellidos, goles, asistencias, partidos, puesto, edad, equipoId);

	   //plan b
	    if (futbolista.getFutbolistaId() == 0) {
	        this.futbolistaDAO.crear(futbolista);
	    } else {
	        this.futbolistaDAO.actualizar(futbolista);
	    }
       //
	    response.sendRedirect("futbolistas");
	}
	
	//-------------------------
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("id") != null) {
			int futbolistaId = Integer.parseInt(request.getParameter("id"));
			this.futbolistaDAO.eliminar(futbolistaId);
		}
		response.sendRedirect("futbolistas");
	}
}
