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
import fr.eni.jee.projet.bo.BOException;

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
		
		HttpSession session = request.getSession(false); // nouvelle exemplaire de session si session == false

		int no_utilisateur = (Integer) session.getAttribute("idUtilisateur"); // on r�cup l'id de l'utilisateur via la session
		
		try {
			
			this.utilisateurManager.deleteUtilisateur(no_utilisateur); // on applique la m�thode delete via l'id de l'utilisateur
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath() + "/accueil");
			
		}catch (BLLException e) {
			e.getMessage();
			request.setAttribute("erreur", "Identifiant ou Mot de passe incorrect !");
			response.sendRedirect(request.getContextPath() + "/accueil");
		}
		
	}
}





