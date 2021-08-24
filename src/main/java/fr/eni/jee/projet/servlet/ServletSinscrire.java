package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bll.UtilisateurManager;


/**
 * Servlet implementation class ServletSinscrire
 */
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtilisateurManager utilisateurManager;
	private boolean verifPseudo, verifEMail, verifMotDePasse;

	public ServletSinscrire() {
		super();
		this.utilisateurManager = new UtilisateurManager();
	}



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
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
			
			// 2 - On appelle la couche BLL avec ces parametres
			this.utilisateurManager.inscripionUtilsateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			 request.getRequestDispatcher("/accueil").forward(request, response); 
			
<<<<<<< HEAD
=======
			verifPseudo = utilisateurManager.verifierPseudo(pseudo);
			//verifEMail = utilisateurManager.verifierEMail(email);
			//verifMotDePasse = utilisateurManager.verifierMotDePasse(motDePasse);
			
			if (verifPseudo == false) {
				 request.getRequestDispatcher("/accueil").forward(request, response); // une erreur est survenu
			}else {
				request.setAttribute("erreurPseudo", "Pseudo déjà utilisé!"); // message d'erreur en cas d'identifiant ou de mot de passe incorrect
				request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response); // une erreur est survenu
			}
>>>>>>> branch 'master' of https://github.com/SebastienBonneau/TrocTrocQuiEstLa.git
		} catch (BLLException e) {
			e.printStackTrace();
			request.setAttribute("erreurPseudo", e.getMessage()); // message d'erreur en cas d'identifiant ou de mot de passe incorrect
			request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response); // une erreur est survenu
		}
			
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response);
	}
}
