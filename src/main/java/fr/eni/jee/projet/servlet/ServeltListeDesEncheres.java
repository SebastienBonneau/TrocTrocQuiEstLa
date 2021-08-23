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
		
		
	}

}
