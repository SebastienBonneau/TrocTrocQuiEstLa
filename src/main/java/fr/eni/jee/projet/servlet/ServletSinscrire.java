package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.UtilisateurManager;
import fr.eni.jee.projet.bo.Utilisateur;


/**
 * Servlet implementation class ServletSinscrire
 */
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilsateur ;
	private UtilisateurManager utilisateurManager;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
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
			
		utilsateur = this.utilisateurManager.inscripionUtilsateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
				}
	
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response);
	}
	
	
	
}
