package fr.eni.jee.projet.dal;

import fr.eni.jee.projet.bo.Utilisateur;

public interface UtilisateursDAO {

	Utilisateur selectUtilisateur(String utilisateur, String mot_de_passe) throws DALException;

}
