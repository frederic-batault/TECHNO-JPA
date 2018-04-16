package fr.gtm.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.domaine.Conseiller;
import fr.gtm.service.ConseillerService;

/**
 * Servlet implementation class ServletAccueil
 */
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAccueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("get... Served azeazeaze at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("post a la con... Served at: ").append(request.getContextPath());
		
		//this.getServletContext().getRequestDispatcher("/listClient.jsp").forward(request, response);
		HttpSession session = request.getSession();
		String login = request.getParameter("leLogin");
		String pwd = request.getParameter("lePwd");
		ConseillerService servC = new ConseillerService();
		Conseiller c = new Conseiller(login,pwd);
		c = servC.getConseiller(c);
		
		if(c.getIdConseiller() != 0) {
			session.setAttribute("idConseillier", c.getIdConseiller());
			session.setAttribute( "conseiller", c );
		
			// this.getServletContext().getRequestDispatcher("/listClient.jsp").forward(request, response);
			this.getServletContext().getRequestDispatcher("/ServletListClient").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
