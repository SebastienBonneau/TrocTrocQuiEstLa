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
	
	private UtilisateurManager utilisateurManager = new UtilisateurManager();

	public ServletSinscrire() {
		super();
		// TODO Auto-generated constructor stub
	}



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
		
		
		try {
			if (utilisateurManager.verifierPseudo(pseudo) == true ) {
				// 2 - On appelle la couche BLL avec ces parametres
				try {

					this.utilisateurManager.inscripionUtilsateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("erreurPseudo", "Pseudo déjà utilisé!"); // message d'erreur en cas d'identifiant ou de mot de passe incorrect
			request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response); // une erreur est survenu
			e.printStackTrace();	
		}
			
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response);
	}
}
