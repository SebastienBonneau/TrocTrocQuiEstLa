package fr.eni.jee.projet.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bll.ArticleManager;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no_article = Integer.parseInt(request.getParameter("no_article"));
		String nom_article = request.getParameter("nom_article");
		String description = request.getParameter("description");
		LocalDate date_debut_enchere = LocalDate.parse(request.getParameter("date_debut_enchere"));
		LocalDate date_fin_enchere = LocalDate.parse(request.getParameter("date_fin_enchere"));
		int prix_initial = Integer.parseInt(request.getParameter("prix_initial"));
		int prix_vente = Integer.parseInt(request.getParameter("prix_vente"));
		int no_utilisateur = Integer.parseInt(request.getParameter("no_utilisateur"));
		int no_categorie = Integer.parseInt(request.getParameter("no_categorie"));
		String etat_vente= request.getParameter("etat_vente");
		String image = request.getParameter("image");
		
		this.articleManager.ajouterArticle(no_article , nom_article, description, date_debut_enchere,date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
	}
	
	request.getRequestDispatcher("/WEB-IF/acceuil.jsp").forward(request, reponse):
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/vendreArticle.jsp").forward(request, response);

	}

}
