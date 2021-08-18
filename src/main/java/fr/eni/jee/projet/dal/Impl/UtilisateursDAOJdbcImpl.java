package fr.eni.jee.projet.dal.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
	
	private final static String SQL_SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE pseudo=? OR email=? AND mot_de_passe=?;";


	@Override
	public void utilisateurMDP(String utilisateur, String mot_de_passe) throws DALException {
		
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requête SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_UTILISATEUR);
			
			pSt.setString(1, utilisateur);
			pSt.setString(2, utilisateur);
			pSt.setString(3, mot_de_passe);
			
			ResultSet rs = pSt.executeQuery();
			
			if (!rs.next()) {
				System.out.println("mauvais Utilisateur ou mot de passe.");
			}
			
		}catch (Exception e) {
			throw new DALException("une erreur est survenu");
		}
	}

}
