package fr.gtm.presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.Compte;
import fr.gtm.service.ClientService;
import fr.gtm.service.CompteService;

/**
 * Servlet implementation class listCompte
 */
public class ServletListCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListCompte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		ClientService servcLient = new ClientService();
		CompteService ccs = new CompteService();
		Compte cc = new Compte();
		Client leC = new Client();
		
		leC.setIdClient(Integer.parseInt(id));
		leC = servcLient.getClient(leC);
		cc = ccs.getCompteCourant(leC);
		
//		cc.setDateCreation("toto");
//		cc.setNumCompte("StringNum");
		
		session.setAttribute("cc", cc);
		session.setAttribute("idClient", id);
		
		this.getServletContext().getRequestDispatcher("/listCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("postable... Served azeazeaze at: ").append(request.getContextPath());
	}

}
