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
//		// si la note n'est pas comprise entre 1 et 5
//		if (utilisateur.get_____.equals.utilisateur.get______) {
//			// on balance une exception "personalis�e" de type BusinessException
//			throw new BLLException("L'utilisateur est incorrecte");
//		}
//		if ()
//	}
}
