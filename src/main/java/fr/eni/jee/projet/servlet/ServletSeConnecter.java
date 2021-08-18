package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.ProjetManager;
import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.DALException;

/**
 * Servlet implementation class ServletSeConnecter
 */
@WebServlet("/ServletSeConnecter")
public class ServletSeConnecter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProjetManager projetManager;
	private Utilisateur userManager;
	
	public ServletSeConnecter() {
    	super();
		this.projetManager = new ProjetManager();
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
			this.projetManager.selectUtilisateur(identifiant, motDePasse);
			
			// 3 - On ajoute un attribut pour dire que tout s'est bien passe
			request.setAttribute("success", true);
			
			if(userManager.getPseudo().equals(identifiant) || userManager.getEmail().equals(identifiant) && userManager.getMot_de_passe().equals(motDePasse)) {
				System.out.println("qsqsdsqdsqdsqdsqqsdq");
			}
			
		}
		catch( DALException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "m�tier"
			request.setAttribute("erreur", e.getMessage());
		}
		// ce catch est effectue si jamais l'exception levee n'est pas de type BusinessException
		catch( Exception e) {
			// Si jamais on a une exception d'un autre type, on precise dans notre attribut un message generique d'erreur
			request.setAttribute("erreur", "une erreur s'est produite durant la creation");
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}

		
		// 2 - On va ajouter un utilisateur a la session a partir de l'identifiant et du mot de passe
		request.getSession().setAttribute("Utilisateurs", userManager.getPseudo());
//		
//		// 3 - On va cr�er un cookie pour stocker l'identifiant 
//		Cookie ckId = new Cookie("identifiant", identifiant);
//		//Cookie ckMdp = new Cookie("motDePasse", motDePasse);
//		
//		response.addCookie(ckId);
//		// response.addCookie(ckMdp);
//		
		//response.sendRedirect("./seConnecter.jsp");
		
		request.getRequestDispatcher("./connecter.jsp").forward(request, response);
	}

}
