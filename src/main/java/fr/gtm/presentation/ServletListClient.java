package fr.gtm.presentation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Client;
import fr.gtm.domaine.CompteCourant;
import fr.gtm.domaine.CompteEpargne;
import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ClientService;
import fr.gtm.service.CompteCourantService;
import fr.gtm.service.CompteEpargneService;

/**
 * Servlet implementation class listClient
 */
public class ServletListClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//Conseiller cons = new Conseiller(1,"Lepremier","Conseiller","toto","123");
		Conseiller cons = new Conseiller();
		ClientService servClient = new ClientService();
		
		cons = (Conseiller) session.getAttribute("conseiller");
		int idDelete = 0;
		String id = request.getParameter("idDelete");
		if(id != null) {
			idDelete = Integer.parseInt(id);
			if(idDelete > 0) {
				Client leClient = new Client();
				leClient.setIdClient(idDelete);
				servClient.deleteClient(leClient);
			}
		}
		
		if(request.getParameter("idType") != null) {
			String idType = request.getParameter("idType");
			String idClient = request.getParameter("idClient");			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date today = Calendar.getInstance().getTime();
			String reportDate = df.format(today);			
			boolean ok = false;
			if(Integer.parseInt(idType) == 1) {
				CompteCourantService ccs = new CompteCourantService();
				CompteCourant cc = new CompteCourant();
				cc.setNumCompte("numCompte");
				cc.setIdClient(Integer.parseInt(idClient));
				cc.setIdTypeCompte(Integer.parseInt(idType));
				cc.setDateCreation(reportDate);
				ok = ccs.createCompteCourant(cc);
			}else {
				CompteEpargneService ces = new CompteEpargneService();
				CompteEpargne ce = new CompteEpargne();
				ce.setNumCompte("numCompte");
				ce.setIdClient(Integer.parseInt(idClient));
				ce.setIdTypeCompte(Integer.parseInt(idType));
				ce.setDateCreation(reportDate);
				ok = ces.createCompteEpargne(ce);
			}
		}
		
		cons.setListeClients(servClient.getAllClient(cons));
		
		cons.setNbClient(cons.getListeClients().size());
		
		session.setAttribute("listClient", cons.getListeClients());
		this.getServletContext().getRequestDispatcher("/listClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		this.getServletContext().getRequestDispatcher("/editionClient.jsp").forward(request, response);
		// response.getWriter().append("posttopost... Served azeazeaze at: ").append(request.getContextPath());
		doGet(request, response);
	}

}
