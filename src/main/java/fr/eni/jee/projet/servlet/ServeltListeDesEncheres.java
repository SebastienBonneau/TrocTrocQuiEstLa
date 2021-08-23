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
		
		listeDesEncheres(request, response);
	}
	
	
	private void listeDesEncheres(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		try {
			//TODO 
			List<Article> listeEnchere = this.articleManager.selectEnchere();
			request.setAttribute("listeEnchere", listeEnchere);
	        request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response); // une erreur est survenu
			
		}
		catch( BLLException e) {
			// Si jamais on a une exception personalisee on ajoute un attribut "erreur" pour que la JSP puisse l'afficher
			// on fait ca parce que l'on veut uniquement afficher nos erreurs "metier"
			request.setAttribute("erreur", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		listeDesEncheres(request, response);
	}

}
