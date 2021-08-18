package fr.eni.jee.projet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	private Utilisateur user = null;
	
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
			user = this.projetManager.selectUtilisateur(identifiant, motDePasse);
			
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("utilisateur", user);
                request.getRequestDispatcher("./accueil.jsp").forward(request, response);
			}else {
				request.setAttribute("erreur", "une erreur s'est produite durant la création");
                request.getRequestDispatcher("./seConnecter.jsp").forward(request, response);

           }
			
		}
		catch( DALException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "m�tier"
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		// ce catch est effectue si jamais l'exception levee n'est pas de type BusinessException
		catch( Exception e) {
			// Si jamais on a une exception d'un autre type, on precise dans notre attribut un message generique d'erreur
			request.setAttribute("erreur", "une erreur s'est produite durant la creation");
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
	}

}
