package fr.eni.jee.projet.dal;

import fr.eni.jee.projet.bo.Utilisateur;

public interface UtilisateursDAO {

	Utilisateur selectUtilisateur(String utilisateur, String mot_de_passe) throws DALException;
	
	void insertUtilsateur (String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) throws DALException;
	
}
