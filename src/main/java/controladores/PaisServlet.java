package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import clases.Pais;
import fabrica.DAOFactory;
import interfaces.IPaisDAO;

/**
 * Servlet implementation class PaisServlet
 */
@WebServlet(name = "pais", urlPatterns = { "/pais" })
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IPaisDAO paisDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisServlet() {
        super();
        this.paisDAO = DAOFactory.getDAOFactory().getPaisDAO();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        this.lista(request, response);
	}

	
	protected void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Pais> lista = this.paisDAO.listar();
		
		request.setAttribute("lista", lista);
		request.getRequestDispatcher("/futbolista_editar.jsp");
		
	}
}
