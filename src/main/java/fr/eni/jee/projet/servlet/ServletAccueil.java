package fr.eni.jee.projet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bll.CategorieManager;
import fr.eni.jee.projet.bo.Categorie;

/**
 * Servlet implementation class accueil
 */
@WebServlet("/accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CategorieManager categorieManager;
	private List<Categorie> listeCategorie;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listeCategorie(request, response);
	}
	
	private void listeCategorie(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		try {
			
			listeCategorie = this.categorieManager.selectCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
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
		
		int categorieId = Integer.parseInt(request.getParameter("categorie"));
		
		request.setAttribute("selectedCatID", categorieId);
		
		listeCategorie(request, response);
	}
	
	
}
