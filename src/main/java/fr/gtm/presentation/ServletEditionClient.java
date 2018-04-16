package fr.gtm.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.service.ClientService;

/**
 * Servlet implementation class ServletClient
 */
public class ServletEditionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditionClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Client leClient = new Client();
		ClientService servClient = new ClientService();
		HttpSession session = request.getSession();
		
		leClient.setIdClient(Integer.parseInt(id));
		if(leClient.getIdClient() > 0) {
			leClient = servClient.getClient(leClient);
		}
		session.setAttribute("client", leClient);
		this.getServletContext().getRequestDispatcher("/editionClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client newClient = new Client();
		ClientService servClient = new ClientService();
		newClient = (Client) session.getAttribute("client");
		newClient.setNom(request.getParameter("leNom"));
		newClient.setPrenom(request.getParameter("lePrenom"));
		newClient.setEmail(request.getParameter("leMail"));
		newClient.setAdresse(request.getParameter("lAdresse"));
		newClient.setCodePostal(request.getParameter("leCodePostal"));
		newClient.setVille(request.getParameter("laVille"));
		if(newClient.getIdClient() == 0) {
//			Conseiller leConseiller = new Conseiller();
//			int idConseiller = (Integer) session.getAttribute("idConseillier");
			newClient.setIdConseiller(1);
			servClient.createClient(newClient);
		}else {
			servClient.updateClient(newClient);
		}
		
		this.getServletContext().getRequestDispatcher("/listClient.jsp").forward(request, response);
	}

}
