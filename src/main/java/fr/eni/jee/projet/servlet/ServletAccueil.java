package fr.eni.jee.projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.ArticleManager;
import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bll.CategorieManager;
import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.bo.Categorie;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private CategorieManager categorieManager;
	private ArticleManager articleManager;

	public ServletAccueil() {
    	super();
		this.categorieManager = new CategorieManager();
		this.articleManager = new ArticleManager();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		listeDeCategorie(request, response);
	}
	
	
	private void listeDeCategorie(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		try {
			// 1 - On appelle la couche BLL pour recupere les informations er les ajouter a une liste de categorie
			List<Categorie> listeCategorie = this.categorieManager.selectCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
			// 2 - On appelle la couche BLL pour recupere les informations er les ajouter a une liste d'article
			List<Article> listeArticle = this.articleManager.listeEnchereEC();
			request.setAttribute("listeArticle", listeArticle);
			
	        request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			
		}
		catch( BLLException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "metier"
			request.setAttribute("erreur", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			e.printStackTrace(); // je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1 - On recupere les informations envoyees par le formulaire
		int categorieId = 0;
		if( request.getParameter("categorie") != null) {
			categorieId = Integer.parseInt(request.getParameter("categorie"));
		}
		request.setAttribute("selectedCatID", categorieId);
		
		listeDeCategorie(request, response);
	}
	
	
}
