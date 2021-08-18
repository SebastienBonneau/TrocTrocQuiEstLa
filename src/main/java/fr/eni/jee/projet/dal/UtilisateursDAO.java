package fr.eni.jee.projet.dal;

public interface UtilisateursDAO {

	void utilisateurMDP(String utilisateur, String mot_de_passe) throws DALException;

}
