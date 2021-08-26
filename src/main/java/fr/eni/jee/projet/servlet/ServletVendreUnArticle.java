package fr.eni.jee.projet.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.ArticleManager;
import fr.eni.jee.projet.bll.BLLException;
/**
 * Servlet implementation class ServletVendreArticle
 */
@WebServlet("/ServletVendreUnArticle")
public class ServletVendreUnArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArticleManager articleManager;
	
	public ServletVendreUnArticle() {
		super();
		this.articleManager = new ArticleManager();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			// 1 - On recupere les informations envoyees par le formulaire
			String nom_article = request.getParameter("nomArticle");
			String description = request.getParameter("description");
			LocalDateTime date_debut_enchere = LocalDateTime.parse(request.getParameter("date_debut_enchere"));
			LocalDateTime date_fin_enchere = LocalDateTime.parse(request.getParameter("date_fin_enchere"));
			int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
			int no_categorie = Integer.parseInt(request.getParameter("categorie"));
			
			// 2 - On appelle la couche BLL avec ces parametres
			this.articleManager.ajouterArticle(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_categorie);
			
		} catch (BLLException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "metier"
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace(); // je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		// ce catch est effectue si jamais l'exception levee n'est pas de type BLLException
		catch( Exception e) {
			// Si jamais on a une exception d'un autre type, on precise dans notre attribut un message generique d'erreur
			request.setAttribute("erreur", "une erreur est survenu"); // une erreur est survenu
			e.printStackTrace(); // je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		
		request.getRequestDispatcher("/accueil").forward(request,response);
	}
	
}
