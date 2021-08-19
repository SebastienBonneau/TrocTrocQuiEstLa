package fr.eni.jee.projet.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
	
	private final static String SQL_SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE (pseudo=? OR email=?) AND mot_de_passe=?;";


	@Override
	public Utilisateur selectUtilisateur(String utilisateur, String motDePasse) throws DALException {
		
		Utilisateur user = null;
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_UTILISATEUR);
			
			pSt.setString(1, utilisateur);
			pSt.setString(2, utilisateur);
			pSt.setString(3, motDePasse);
			
			ResultSet rs = pSt.executeQuery();
			
			if (rs.next()) {
				int no_utilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String code_postal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String mot_de_passe = rs.getString("mot_de_passe");
				int credit = rs.getInt("credit");
				boolean administrateur = rs.getBoolean("administrateur");
				
				user = new Utilisateur(no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);
			}
			
		}catch (SQLException e) {
			e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
			throw new DALException("une erreur est survenu sur la BDD. Note Technique : " + e.getMessage());
		}
		return user;
	}

}
