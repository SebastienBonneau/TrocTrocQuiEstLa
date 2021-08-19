package fr.eni.jee.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSinscrire
 */
@WebServlet("/ServletSinscrire")
public class ServletSinscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	   

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1 - On recupere les informations envoyees par le formulaire
		String pseudo = request.getParameter("identifiant");
		String prenom = request.getParameter("identifiant");
		String telephone = request.getParameter("identifiant");
		String codePostal = request.getParameter("identifiant");
		String motDePasse = request.getParameter("identifiant");
		String nom = request.getParameter("identifiant");
		String email = request.getParameter("identifiant");
		String rue = request.getParameter("identifiant");
		String ville= request.getParameter("identifiant");
		String confirmation= request.getParameter("identifiant");

	
	
	
	
	
	
	
	
	
	
	}








	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Sinscrire.jsp").forward(request, response);
	}
	
	
	
}
