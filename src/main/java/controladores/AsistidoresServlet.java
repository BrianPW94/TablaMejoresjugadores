package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Futbolista;
import fabrica.DAOFactory;
import interfaces.IAsistidorDAO;


@WebServlet(name = "asistidores", urlPatterns = { "/asistidores" })
public class AsistidoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private IAsistidorDAO asistidorDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AsistidoresServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.asistidorDAO = DAOFactory.getDAOFactory().getAsistenciaDAO();
    }

	
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = "";
		
		if(request.getParameter("opcion")!= null)
			opcion =request.getParameter("opcion");
		switch (opcion) {
		case "lista": 
			this.lista(request, response);
			break;
		default:
			this.lista(request, response);
		}
		
	}

	
    protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Futbolista> lista = this.asistidorDAO.listar();
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/asistidores/asistidores_editar.jsp").forward(request, response);
	}
}
