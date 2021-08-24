package fr.eni.jee.projet.servlet;

import java.io.IOException;
import java.time.LocalDate;

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
		
		int no_article = 6;
		String nom_article = request.getParameter("nomArticle");
		String description = request.getParameter("description");
		LocalDate date_debut_enchere = LocalDate.parse(request.getParameter("date_debut"));
		LocalDate date_fin_enchere = LocalDate.parse(request.getParameter("date_fin"));
		int prix_initial = Integer.parseInt(request.getParameter("prixInitial"));
		int prix_vente = 12;
		int no_utilisateur = 5;
		int no_categorie = Integer.parseInt(request.getParameter("categorie"));
		String etat_vente= request.getParameter("etat");
		String image = "=";
		//String image = request.getParameter("image");
		
		try {
			this.articleManager.addArticle(no_article ,nom_article, description, date_debut_enchere,date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.getRequestDispatcher("/accueil").forward(request,response);
	}
	
}
