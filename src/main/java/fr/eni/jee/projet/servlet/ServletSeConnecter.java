package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.ProjetManager;
import fr.eni.jee.projet.dal.DALException;

/**
 * Servlet implementation class ServletSeConnecter
 */
@WebServlet("/ServletSeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProjetManager projetManager;
	
	public ServletSeConnecter() {
    	super();
		this.projetManager = new ProjetManager();
    }
	/**
	 * Est appelé lorsqu'on valide le formulaire de connexion
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			// 1 - On récupère les informations envoyées par le formulaire
			String identifiant = request.getParameter("identifiant");
			String motDePasse = request.getParameter("motDePasse");
			
			// 2 - On appelle la couche BLL avec ces paramètres
			this.projetManager.utilisateurMDP(identifiant, motDePasse);
			
			// 3 - On ajoute un attribut pour dire que tout s'est bien passé
			request.setAttribute("success", true);
		}
		catch( DALException e) {
			// Si jamais on a une exception personalisée on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "métier"
			request.setAttribute("erreur", e.getMessage());
		}
		// ce catch là est effectué si jamais l'exception levée n'est pas de type BusinessException
		catch( Exception e) {
			// Si jamais on a une exception d'un autre type, on precise dans notre attribut un message generique d'erreur
			request.setAttribute("erreur", "une erreur s'est produite durant la création");
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgré le fait que l'erreur est catchée
		}
//		// 1 - On recupère les paramètres
//		String identifiant = request.getParameter("identifiant");
//		String motDePasse = request.getParameter("motDePasse");
//		
//		// 2 - On va ajouter un utilisateur à la session à partir de l'identifiant et du mot de passe
//		Utilisateurs utilisateur = new Utilisateurs(identifiant, motDePasse);
//		request.getSession().setAttribute("Utilisateurs", utilisateur);
//		
//		// 3 - On va créer un cookie pour stocker l'identifiant 
//		Cookie ckId = new Cookie("identifiant", identifiant);
//		//Cookie ckMdp = new Cookie("motDePasse", motDePasse);
//		
//		response.addCookie(ckId);
//		// response.addCookie(ckMdp);
//		
		response.sendRedirect("./seConnecter.jsp");
	}

}
