package fr.eni.jee.projet.dal.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.bo.Categorie;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;


public class ArticleDAOJdbcImpl implements ArticlesDAO {

	private final static String SQL_INSERT_ARTICLE = "insert into ARTICLES_VENDUS (no_articles, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image) "
													+ "values (no_article=?, nom_article=?, description=?, date_debut_enchere=?, date_fin_enchere=?, prix_inital=?, prix_vente = ?, no_utilisateur=?, no_categorie=?, etat_vente=? image=?);";
	private final static String SQL_SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS;";
	private final static String SQL_UPDATE_ETAT_ARTICLE = "update ARTICLES_VENDUS set etat_vente=? where no_article=?;";
	private final static String SQL_DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?;";
	
	
	
	public void ajouterArticle(Article article) throws DALException {
	
		
		try(Connection connection = ConnectionProvider.getPoolConnexion()){
			
			PreparedStatement pSt = connection.prepareStatement(SQL_INSERT_ARTICLE);
			pSt.setInt(1, article.getNo_article() );
			pSt.setString(2, article.getNom_article() );
			pSt.setString(3, article.getDescription() );
			pSt.setDate(4,(Date) article.getDate_debut_enchere() );
			pSt.setDate(5,(Date) article.getDate_fin_enchere() );
			pSt.setInt(6, article.getPrix_initial() );
			pSt.setInt(7, article.getPrix_vente() );
			pSt.setInt(8, article.getNo_utilisateur() );
			pSt.setInt(9, article.getNo_categorie() );
			pSt.setString(10, article.getEtat_vente() );
			pSt.setString(11, article.getImage());
			pSt.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
			throw new DALException("errreur SQL_INSERT_ARTICLE");
		}
		
	}
	
	public List<Article> selectAllArticle() throws DALException {
		// creation d'une liste pour contenir le resultat
		List<Article> listeArticle = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_ALL_ARTICLE);
			
			ResultSet rs = pSt.executeQuery();
			// boucle while pour implementer la liste et y mettre toutes nos valeurs
			while (rs.next()) {
				int no_article = rs.getInt("no_article");
				String nom_article = rs.getString("nom_article");
				String description = rs.getString("description");
				Date date_debut_enchere = rs.getDate("date_debut_enchere");
				Date date_fin_enchere = rs.getDate("date_fin_enchere");
				int prix_initial = rs.getInt("prix_initial");
				int prix_vente = rs.getInt("prix_vente");
				int no_utilisateur = rs.getInt("no_utilisateur");
				int no_categorie = rs.getInt("no_categorie");
				String etat_vente = rs.getString("etat_vente");
				String image = rs.getString("image");
				
				Article article = new Article(no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
				listeArticle.add(article);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		// return de la list d'article
		return listeArticle;
	}
	
	
	
	public void changementEtatArticle(Article article) throws DALException {
		
		try(Connection connection = ConnectionProvider.getPoolConnexion()) {
			PreparedStatement pSt = connection.prepareStatement(SQL_UPDATE_ETAT_ARTICLE);
			pSt.setString(1, article.getEtat_vente());
			pSt.setInt(2, article.getNo_article());
			pSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_UPDATE_ETAT_ARTICLE");
		}
		
	}
	
	public void enchereAnnule(int numeroArticle ) throws DALException {
		
		try(Connection connection = ConnectionProvider.getPoolConnexion()) {
			PreparedStatement pSt = connection.prepareStatement(SQL_DELETE_ARTICLE);
			pSt.setInt(1, numeroArticle);
			pSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_DELETE_ARTICLE");
		}
		
	}

	
	
	
}
