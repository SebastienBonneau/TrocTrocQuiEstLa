package fr.eni.jee.projet.dal;

import fr.eni.jee.projet.bo.Utilisateurs;

public interface UtilisateursDAO {

	void utilisateurMDP(Utilisateurs utilisateur) throws DALException;

}
