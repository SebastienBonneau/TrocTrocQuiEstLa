package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bll.UtilisateurManager;

/**
 * Servlet implementation class ServletSupprimerMonCompte
 */
@WebServlet("/ServletSupprimerMonCompte")
public class ServletSupprimerMonCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurManager utilisateurManager;

    public ServletSupprimerMonCompte() {
        super();
        this.utilisateurManager = new UtilisateurManager();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/supprimerMonCompte.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);

		int no_utilisateur = (Integer) session.getAttribute("idUtilisateur");
		
		try {
			
			this.utilisateurManager.deleteUtilisateur(no_utilisateur); 
			
		}catch (BLLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		request.getSession().invalidate();
        response.sendRedirect(request.getContextPath() + "/accueil");
	}
}





