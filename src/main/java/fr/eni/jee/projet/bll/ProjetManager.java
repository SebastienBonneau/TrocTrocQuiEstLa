package fr.eni.jee.projet.bll;

import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class ProjetManager {
	
	private UtilisateursDAO utilisateursDAO;
	
	public ProjetManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDOA();
	}

	public Utilisateur selectUtilisateur(String identifiant, String motDePasse) throws DALException {
		
		Utilisateur userManager = this.utilisateursDAO.selectUtilisateur(identifiant, motDePasse);
		
		return userManager;
	}
	
}
