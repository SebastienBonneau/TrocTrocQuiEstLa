package fr.eni.jee.projet.dal.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.bo.Categorie;
import fr.eni.jee.projet.bo.Utilisateur;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;


public class ArticleDAOJdbcImpl implements ArticlesDAO {

	private final static String SQL_INSERT_ARTICLE = "insert into ARTICLES_VENDUS (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) "
													+ "values (?,?,?,?,?,?,'1',?,'CR');";
	private final static String SQL_SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS;";
	private final static String SQL_UPDATE_ETAT_ARTICLE = "update ARTICLES_VENDUS set etat_vente=? where no_article=?;";
	private final static String SQL_DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?;";
	private final static String SQL_SELECT_ETAT_EC = "SELECT * FROM ARTICLES_VENDUS WHERE etat_vente = 'EC' ;";
	private final static String SQL_SELECT_ETAT_CR = "SELECT * FROM ARTICLES_VENDUS WHERE etat_vente = 'CR' ;";
	private final static String SQL_SELECT_ETAT_VD = "SELECT * FROM ARTICLES_VENDUS WHERE etat_vente = 'VD' ;";
	
	
	
	public void ajouterArticle(Article article) throws DALException {
	
		
		try(Connection connection = ConnectionProvider.getPoolConnexion()){
			
			PreparedStatement pSt = connection.prepareStatement(SQL_INSERT_ARTICLE, Statement.RETURN_GENERATED_KEYS );
			
			// l'API JDBC Utilise java.sql.Date et java.sql.Time pour ses preparedStatements
			// On a utilisé de bnotr côté LocalDateTime
			// => du coup : on va devoir faire une CONVERSION avec Timestamp.valueOf()
			Timestamp sqlDate_debut_enchere = Timestamp.valueOf(article.getDate_debut_enchere());
			Timestamp sqlDate_fin_enchere = Timestamp.valueOf(article.getDate_fin_enchere());
			
				pSt.setString(2, article.getNom_article() );
				pSt.setString(3, article.getDescription() );
				pSt.setTimestamp(4, sqlDate_debut_enchere );
				pSt.setTimestamp(5, sqlDate_fin_enchere );
				pSt.setInt(6, article.getPrix_initial() );
				pSt.setInt(7, article.getPrix_vente() );
				pSt.setInt(8, article.getNo_utilisateur() );
				pSt.setInt(9, article.getNo_categorie() );
				pSt.setString(10, article.getEtat_vente() );
				pSt.setString(11, article.getImage());
				
				pSt.executeUpdate();
				ResultSet clesGenerees = pSt.getGeneratedKeys(); // Récupérer les colonnes auto incrémentée
	            if (clesGenerees.next()) {
	                int idGenere = clesGenerees.getInt(1);
	                article.setNo_article(idGenere);
	            }
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
				Article article = new Article(
					rs.getInt("no_article"),
					rs.getString("nom_article"),
					rs.getString("description"),
					LocalDateTime.of((rs.getDate("date_debut_enchere").toLocalDate()),
							rs.getTime("date_debut_enchere").toLocalTime()),
					LocalDateTime.of((rs.getDate("date_fin_enchere").toLocalDate()),
							rs.getTime("date_fin_enchere").toLocalTime()),
					rs.getInt("prix_initial"),
					rs.getInt("prix_vente"),
					rs.getInt("no_utilisateur"),
					rs.getInt("no_categorie"),
					rs.getString("etat_vente"),
					rs.getString("image")
				);
				//Article article = new Article(no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
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

	public List<Article> selectEnchereEC() throws DALException {
		
		List<Article> listeArticleEC = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_ETAT_EC);
			
			ResultSet rs = pSt.executeQuery();
			// boucle while pour implementer la liste et y mettre toutes nos valeurs
			while (rs.next()) {
				Article articleEC = new Article(
					rs.getInt("no_article"),
					rs.getString("nom_article"),
					rs.getString("description"),
					LocalDateTime.of((rs.getDate("date_debut_enchere").toLocalDate()),
							rs.getTime("date_debut_enchere").toLocalTime()),
					LocalDateTime.of((rs.getDate("date_fin_enchere").toLocalDate()),
							rs.getTime("date_fin_enchere").toLocalTime()),
					rs.getInt("prix_initial"),
					rs.getInt("prix_vente"),
					rs.getInt("no_utilisateur"),
					rs.getInt("no_categorie"),
					rs.getString("etat_vente"),
					rs.getString("image")
				);
				//Article articleEC = new Article(no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
				listeArticleEC.add(articleEC);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		// return de la list d'article
		return listeArticleEC;
	}
	
	public List<Article> selectEnchereCR() throws DALException {
		
		List<Article> listeArticleCR = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_ETAT_CR);
			
			ResultSet rs = pSt.executeQuery();
			// boucle while pour implementer la liste et y mettre toutes nos valeurs
			while (rs.next()) {
				Article articleCR = new Article(
					rs.getInt("no_article"),
					rs.getString("nom_article"),
					rs.getString("description"),
					LocalDateTime.of((rs.getDate("date_debut_enchere").toLocalDate()),
							rs.getTime("date_debut_enchere").toLocalTime()),
					LocalDateTime.of((rs.getDate("date_fin_enchere").toLocalDate()),
							rs.getTime("date_fin_enchere").toLocalTime()),
					rs.getInt("prix_initial"),
					rs.getInt("prix_vente"),
					rs.getInt("no_utilisateur"),
					rs.getInt("no_categorie"),
					rs.getString("etat_vente"),
					rs.getString("image")
				);
				//Article articleCR = new Article(no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
				listeArticleCR.add(articleCR);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		// return de la list d'article
		return listeArticleCR;
	}
	
	public List<Article> selectEnchereVD() throws DALException {
		
		List<Article> listeArticleVD = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {

			// Je lance ma requete SQL de selection
			PreparedStatement pSt = connection.prepareStatement(SQL_SELECT_ETAT_VD);
			
			ResultSet rs = pSt.executeQuery();
			// boucle while pour implementer la liste et y mettre toutes nos valeurs
			while (rs.next()) {
				Article articleVD = new Article(
					rs.getInt("no_article"),
					rs.getString("nom_article"),
					rs.getString("description"),
					LocalDateTime.of((rs.getDate("date_debut_enchere").toLocalDate()),
							rs.getTime("date_debut_enchere").toLocalTime()),
					LocalDateTime.of((rs.getDate("date_fin_enchere").toLocalDate()),
							rs.getTime("date_fin_enchere").toLocalTime()),
					rs.getInt("prix_initial"),
					rs.getInt("prix_vente"),
					rs.getInt("no_utilisateur"),
					rs.getInt("no_categorie"),
					rs.getString("etat_vente"),
					rs.getString("image")
				);
				//Article articleVD = new Article(no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
				listeArticleVD.add(articleVD);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		// return de la list d'article
		return listeArticleVD;
	}
}
