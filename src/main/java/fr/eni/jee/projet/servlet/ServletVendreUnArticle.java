package fr.eni.jee.projet.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.ArticleManager;
import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bo.Categorie;
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
		
		String nom_article = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		LocalDateTime date_debut_enchere = LocalDateTime.parse(request.getParameter("date_debut_enchere"));
		LocalDateTime date_fin_enchere = LocalDateTime.parse(request.getParameter("date_fin_enchere"));
		int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
		//Categorie no_categorie = (request.getParameter("categorie"));
		String image = request.getParameter("image");
		String no_categorie_session = request.getParameter("categorie");
		Categorie no_categorie = (Categorie) request.getSession().getAttribute(no_categorie_session);
		
		//String image = request.getParameter("image");
		
		try {
			this.articleManager.ajouterArticle(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_categorie, image);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("/accueil").forward(request,response);
	}
	
}
