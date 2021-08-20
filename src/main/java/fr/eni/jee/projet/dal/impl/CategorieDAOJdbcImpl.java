package fr.eni.jee.projet.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.projet.bo.Categorie;
import fr.eni.jee.projet.dal.CategorieDAO;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private final static String SQL_SELECT_CATEGORIE = "SELECT * FROM CATEGORIES;"; 
	
	public List<Categorie> ListerCategorie() throws DALException{
		
		List<Categorie> listeCategorie = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_CATEGORIE);
			
			ResultSet rs = pSt.executeQuery();
			
			while(rs.next()) {
				int no_categorie = rs.getInt("no_categorie");
				String libelle = rs.getString("libelle");
				Categorie categorie = new Categorie(no_categorie, libelle);
				
				listeCategorie.add(categorie);
			}	
		}catch (SQLException e) {
				e.printStackTrace(); //je fais cela pour afficher dans la console l'erreur malgre le fait que l'erreur est catchee
				throw new DALException("une erreur est survenu sur la BDD. Note Technique : " + e.getMessage());
			}
		return listeCategorie;
	}
}
