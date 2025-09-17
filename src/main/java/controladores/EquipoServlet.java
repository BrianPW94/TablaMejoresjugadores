package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Equipo;
import fabrica.DAOFactory;
import interfaces.IEquipoDAO;
/**
 * Servlet implementation class DocenteServlet
 */
@WebServlet(name = "equipo", urlPatterns = { "/equipo" })
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IEquipoDAO equipoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipoServlet() {
        super();
     this.equipoDAO = DAOFactory.getDAOFactory().getEquipoDAO();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = "";
		if (request.getParameter("opcion") != null) opcion = request.getParameter("opcion");
		switch (opcion) {
			case "lista" : this.lista(request, response); break;
			case "editar" : this.editar(request, response); break;
			case "registrar" : this.registrar(request, response); break;
			case "eliminar" : this.eliminar(request, response); break;
			default:
				this.lista(request, response);
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Equipo> lista = this.equipoDAO.listar();
		
		request.setAttribute("lista", lista);				
		request.getRequestDispatcher("/equipo/equipo_lista.jsp").forward(request, response);
	}
	
	
	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Equipo equipo = new Equipo();
		if (request.getParameter("id") != null) {
			int equipoId = Integer.parseInt(request.getParameter("id"));
			equipo = this.equipoDAO.obtener(equipoId);
		}
		
		request.setAttribute("registro", equipo);
		request.getRequestDispatcher("/equipo/equipo_editar.jsp").forward(request, response);
	}
	
	protected void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int equipoId = Integer.parseInt(request.getParameter("equipoId"));
		String nombre = request.getParameter("nombre");
		Equipo equipo = new Equipo (equipoId, nombre);
		if(equipo.getEquipoId()==0) {
			this.equipoDAO.crear(equipo);
		}else {
			this.equipoDAO.actualizar(equipo);
		}
				
				response.sendRedirect("equipo");
		
	}
	
	protected void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("id")!= null) {
			
			int equipoId = Integer.parseInt(request.getParameter("id"));
			this.equipoDAO.eliminar(equipoId);
			
			
		}
		response.sendRedirect("equipo");
	}
}