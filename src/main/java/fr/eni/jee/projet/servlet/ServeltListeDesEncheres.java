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
import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.bo.Categorie;

/**
 * Servlet implementation class ServeltEnchere
 */
@WebServlet("/ServeltListeDesEncheres")
public class ServeltListeDesEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArticleManager articleManager;

	public ServeltListeDesEncheres() {
    	super();
		this.articleManager = new ArticleManager();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Article> listeArticle = null;
		
		try {
			
			listeArticle = this.articleManager.selectEnchere();
		}
		catch( BLLException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "metier"
			request.setAttribute("erreur", e.getMessage());
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		
		request.setAttribute("listeArticle", listeArticle);
        request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); // une erreur est survenu
		
	}

}
