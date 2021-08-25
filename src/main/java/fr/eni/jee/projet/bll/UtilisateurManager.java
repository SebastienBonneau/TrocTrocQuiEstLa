package fr.eni.jee.projet.bll;

import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class UtilisateurManager {
	
	private UtilisateursDAO utilisateursDAO;
	
	public UtilisateurManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDAO();
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
	
	public void inscripionUtilsateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String motDePasse) throws BLLException {
		
		try {
			//validation du telephone
			
			//validation de la confirmation du mot de passe

			
			
			Utilisateur user = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 0, false);
			utilisateursDAO.insertUtilsateur(user);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
	}
	
		
	
}

