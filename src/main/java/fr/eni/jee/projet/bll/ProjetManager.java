package fr.eni.jee.projet.bll;

import fr.eni.jee.projet.bo.Utilisateurs;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class ProjetManager {
	
	private UtilisateursDAO utilisateursDAO;
	
	public ProjetManager() {
		this.utilisateursDAO = DAOFactory.getUtilisateursDOA();
	}

	public void utilisateurMDP(String identifiant, String motDePasse) throws DALException {
		Utilisateurs utilisateur = new Utilisateurs(identifiant, motDePasse);
		
		this.utilisateursDAO.utilisateurMDP(identifiant, motDePasse);
	}
	
//	private void validerUtilisateur(Utilisateurs utilisateur) throws BLLException {
//		if (utilisateur.get_____.equals.utilisateur.get______) {
//			// on balance une exception "personalisee" de type BLLException
//			throw new BLLException("L'utilisateur est incorrecte");
//		}
//		if ()
//	}
}
