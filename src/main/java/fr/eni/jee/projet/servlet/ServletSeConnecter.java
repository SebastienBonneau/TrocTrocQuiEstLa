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
import fr.eni.jee.projet.bo.Utilisateur;

/**
 * Servlet implementation class ServletSeConnecter
 */
@WebServlet("/ServletSeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurManager utilisateurManager;
	private Utilisateur user = null;
	
	public ServletSeConnecter() {
    	super();
		this.utilisateurManager = new UtilisateurManager();
    }
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/seConnecter.jsp").forward(request, response);
	}



	/**
	 * Est appele lorsqu'on valide le formulaire de connexion 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			// 1 - On recupere les informations envoyees par le formulaire
			String identifiant = request.getParameter("identifiant");
			String motDePasse = request.getParameter("motDePasse");
			
			// 2 - On appelle la couche BLL avec ces parametres
			user = this.utilisateurManager.selectUtilisateur(identifiant, motDePasse);
			
			// 3 - On test si un utilisateur est trouve en BDD
			if(user != null) { // si user est different de null (!=) on fait une nouvelle session avec user
				HttpSession session = request.getSession(); // nouvelle exemplaire de session
				session.setAttribute("utilisateur", user); // on valorise l'exemplaire de session avec l'objet user récuperer de la base de donnée après connexion
                request.getRequestDispatcher("/accueil").forward(request, response); // une erreur est survenu
			}else {
				request.setAttribute("erreur", "Identifiant ou Mot de passe incorrect !"); // message d'erreur en cas d'identifiant ou de mot de passe incorrect
                request.getRequestDispatcher("/WEB-INF/seConnecter.jsp").forward(request, response); // une erreur est survenu

           }
			
		}
		catch( BLLException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "metier"
			request.setAttribute("erreur", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/seConnecter.jsp").forward(request, response); // une erreur est survenu
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		// ce catch est effectue si jamais l'exception levee n'est pas de type DALException
		catch( Exception e) {
			// Si jamais on a une exception d'un autre type, on precise dans notre attribut un message generique d'erreur
			request.setAttribute("erreur", "une erreur est survenu");
			request.getRequestDispatcher("/WEB-INF/seConnecter.jsp").forward(request, response); // une erreur est survenu
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
	}

}
