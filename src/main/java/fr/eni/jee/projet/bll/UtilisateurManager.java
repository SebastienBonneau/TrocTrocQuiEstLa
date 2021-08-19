package fr.eni.jee.projet.bll;

import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class UtilisateurManager {
	
	private UtilisateursDAO utilisateursDAO;
	
	public UtilisateurManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDOA();
	}

	public Utilisateur selectUtilisateur(String identifiant, String motDePasse) throws BLLException {
		
		Utilisateur result = null;
		try {
			result = this.utilisateursDAO.selectUtilisateur(identifiant, motDePasse);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
			
		}
		
		return result;
	}
	
}
