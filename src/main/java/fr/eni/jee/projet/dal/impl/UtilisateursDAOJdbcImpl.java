package fr.eni.jee.projet.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.UtilisateursDAO;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
	
	private final String SQL_SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE (pseudo=? OR email=?) AND mot_de_passe=?;";
	private final String SQL_SELECT_UTILISATEUR_UPDT = "SELECT * FROM UTILISATEURS WHERE (pseudo=? AND email=? AND mot_de_passe=?);";
	private final String SQL_INSERT_PROFIL = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, "
			+ "email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?, ?, ?, ?, ?, ?, ?, ?, ?, 100, 0);";
	private final String SQL_DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?;";
	private final String SQL_UPDATE_PROFIL = "UPDATE UTILISATEURS SET pseudo=?, nom=?, prenom=?, "
			+ "email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=? WHERE no_utilisateur=?;";

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
	
	public Utilisateur selectUtilisateurUptd(String pPseudo, String pEmail, String motDePasse) throws DALException {
		
		Utilisateur user = null;
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_UTILISATEUR_UPDT);
			
			pSt.setString(1, pPseudo);
			pSt.setString(2, pEmail);
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
	
	/**
	 * Insertion d'un Nouvel Utilisateur
	 */
	public void insertUtilsateur (Utilisateur user) throws DALException {
       
       
        try (Connection connection = ConnectionProvider.getPoolConnexion()) {
	        // Je lance ma requete SQL de selection
	        PreparedStatement pSt = connection.prepareStatement(this.SQL_INSERT_PROFIL, Statement.RETURN_GENERATED_KEYS );
	               
	        pSt.setString(1, user.getPseudo());
	        pSt.setString(2, user.getNom());
	        pSt.setString(3, user.getPrenom());
	        pSt.setString(4, user.getEmail());
	        pSt.setString(5, user.getTelephone());
	        pSt.setString(6, user.getRue());
	        pSt.setString(7, user.getCode_postal());
	        pSt.setString(8, user.getVille());
	        pSt.setString(9, user.getMot_de_passe());
	        
	        pSt.executeUpdate();
            ResultSet clesGenerees = pSt.getGeneratedKeys(); // Récupérer les colonnes auto incrémentée
            if (clesGenerees.next()) {
                int idGenere = clesGenerees.getInt(1);
                user.setNo_utilisateur(idGenere);
            }
        }catch (SQLException e) {
            e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
    		if (e.getMessage().contains("utilisateurs_pseudo_uq")) {
				throw new DALException("Pseudo déja utilisé ");
			}
    		if (e.getMessage().contains("utilisateurs_email_uq")) {
				throw new DALException("Email déja utilisé ");
			}
    
			throw new DALException("une erreur est survenu sur la BDD. Note Technique : " + e.getMessage());
			
        }
    }
	
	public void deleteUtilisateur (int no_utilisateur) throws DALException {
		
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {
			
			PreparedStatement reqDelete = connection.prepareStatement(SQL_DELETE);
			reqDelete.setInt(1, no_utilisateur);
			reqDelete.executeUpdate();
			
		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}
	
	public void updateUtilisateur(Utilisateur user)throws DALException {
	       
        try (Connection connection = ConnectionProvider.getPoolConnexion()) {
	        // Je lance ma requete SQL de selection
	        PreparedStatement pSt = connection.prepareStatement(this.SQL_UPDATE_PROFIL);
	               
	        pSt.setString(1, user.getPseudo());
	        pSt.setString(2, user.getNom());
	        pSt.setString(3, user.getPrenom());
	        pSt.setString(4, user.getEmail());
	        pSt.setString(5, user.getTelephone());
	        pSt.setString(6, user.getRue());
	        pSt.setString(7, user.getCode_postal());
	        pSt.setString(8, user.getVille());
	        pSt.setString(9, user.getMot_de_passe());
	        pSt.setInt(10, user.getNo_utilisateur());
	        
	        pSt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
    		if (e.getMessage().contains("utilisateurs_pseudo_uq")) {
				throw new DALException("Pseudo déja utilisé ");
			}
    		if (e.getMessage().contains("utilisateurs_email_uq")) {
				throw new DALException("Email déja utilisé ");
			}
    
			throw new DALException("une erreur est survenu sur la BDD. Note Technique : " + e.getMessage());
			
        }
    }

}
	
	
	


