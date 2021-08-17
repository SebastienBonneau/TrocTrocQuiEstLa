package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bo.User;

/**
 * Servlet implementation class ServletSeConnecter
 */
@WebServlet("/ServletSeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// TODO manager manquant et un try catch (try succes catch erreur)
	
	
	/**
	 * Est appelé lorsqu'on valide le formulaire de connexion
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 - On recupère les paramètres
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		
		// 2 - On va ajouter un utilisateur à la session à partir de l'identifiant et du mot de passe
		User user = new User(identifiant, motDePasse);
		request.getSession().setAttribute("User", user);
		
		// 3 - On va créer un cookie pour stocker l'identifiant 
		Cookie ckId = new Cookie("identifiant", identifiant);
		//Cookie ckMdp = new Cookie("motDePasse", motDePasse);
		
		response.addCookie(ckId);
		// response.addCookie(ckMdp);
		
		response.sendRedirect("./seConnecter.jsp");
	}

}
