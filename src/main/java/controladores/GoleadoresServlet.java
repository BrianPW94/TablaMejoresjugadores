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
import interfaces.IGoleadorDAO;

/**
 * Servlet implementation class GoleadoresServlet
 */
@WebServlet(name = "goleadores", urlPatterns = { "/goleadores" })
public class GoleadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IGoleadorDAO goleadorDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GoleadoresServlet() {
		super();
		// TODO Auto-generated constructor stub
		this.goleadorDAO = DAOFactory.getDAOFactory().getGoleadorDAO();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String opcion = "";
		if (request.getParameter("opcion") != null)
			opcion = request.getParameter("opcion");

		switch (opcion) {
		case "listar":
			this.lista(request, response);

			break;
		default:
			this.lista(request, response);
		}
	}

	protected void lista(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
ArrayList<Futbolista> lista = this.goleadorDAO.listar();
request.setAttribute("lista", lista);
request.getRequestDispatcher("/goleadores/goleadores_lista.jsp").forward(request, response);
	}

}
