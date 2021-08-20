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
 * Servlet implementation class ServletSinscrire
 */
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur user ;
	private UtilisateurManager utilisateurManager;
	
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	// 1 - On recupere les informations envoyees par le formulaire
		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("telephone");
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("codePostal");
		String ville= request.getParameter("ville");
		String motDePasse = request.getParameter("motDePasse");
		String confirmation= request.getParameter("confirmation");
		if(motDePasse.equals(confirmation)) {
		
			// 2 - On appelle la couche BLL avec ces parametres
		user = this.utilisateurManager.inscripionUtilsateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
		
		
		    // 3 - On test si un utilisateur est trouve en BDD
		if(user != null) { // si user est different de null (!=) on fait une nouvelle session avec user
			HttpSession session = request.getSession(); // nouvelle exemplaire de session
			session.setAttribute("utilisateur", user); // on valorise l'exemplaire de session avec l'objet user récuperer de la base de donnée après connexion

			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); // une erreur est survenu
		}else {
//			request.setAttribute("erreur", "Identifiant ou Mot de passe incorrect !"); // message d'erreur en cas d'identifiant ou de mot de passe incorrect
//            request.getRequestDispatcher("/WEB-INF/seConnecter.jsp").forward(request, response); // une erreur est survenu
				           }	
		
		
		
		}
		}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response);
	}
}
