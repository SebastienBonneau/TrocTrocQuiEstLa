package fr.eni.jee.projet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.jee.projet.bll.BLLException;
import fr.eni.jee.projet.bll.UtilisateurManager;
import fr.eni.jee.projet.bo.Utilisateur;

/**
 * Servlet implementation class ServletSupprimerMonCompte
 */
@WebServlet("/ServletSupprimerMonCompte")
public class ServletSupprimerMonCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager utilisateurManager;
	private Utilisateur user = null;
	

		
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerMonCompte() {
        super();
        this.utilisateurManager = new UtilisateurManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/supprimerMonCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(user != null) { // si user est different de null (!=) on fait une nouvelle session avec user
		HttpSession session = request.getSession(); // nouvelle exemplaire de session
		session.setAttribute("utilisateur", user);
		String pseudo = (String) session.getAttribute("utilisateur");
		String mail = (String) session.getAttribute("utilisateur");
		
		try {

				if (pseudo == null) {
					this.utilisateurManager.deleteUtilisateur(mail);
			} else this.utilisateurManager.deleteUtilisateur(pseudo);
			
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		}

		request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
		
	}
}





