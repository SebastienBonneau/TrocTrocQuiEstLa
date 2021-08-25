package fr.eni.jee.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.projet.bll.UtilisateurManager;
import fr.eni.jee.projet.bo.Utilisateur;

/**
 * Servlet implementation class ServletSupprimerMonCompte
 */
@WebServlet("/ServletSupprimerMonCompte")
public class ServletSupprimerMonCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager;
	private Utilisateur user = null;
	

		
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerMonCompte() {
        super();
        this.utilisateurManager = new UtilisateurManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/supprimerMonCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		user = this.utilisateurManager.selectUtilisateur(identifiant, motDePasse);
		
		// 3 - On test si un utilisateur est trouve en BDD
		if(user != null) { // si user est different de null (!=) on fait une nouvelle session avec user
			HttpSession session = request.getSession(); // nouvelle exemplaire de session
			session.setAttribute("utilisateur", user); // on valorise l'exemplaire de session avec l'objet user récuperer de la base de donnée après connexion
		
	}

}
}
