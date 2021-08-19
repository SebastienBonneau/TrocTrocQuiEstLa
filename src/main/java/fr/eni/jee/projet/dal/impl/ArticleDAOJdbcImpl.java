package fr.eni.jee.projet.dal.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.jdi.request.ClassPrepareRequest;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;


public class ArticleDAOJdbcImpl implements ArticlesDAO {

	private final static String SQL_INSERT_ARTICLE = "insert into ARTICLES_VENDUS where no_article=?, nom_article=?,"
			+ " description=?, date_debut_enchere=?, date_fin_enchere=?, prix_inital=?, prix_vente = ?,"
			+ " no_utilisateur=?, no_categorie=?, etat_vente=? image=?;";
	private final static String SQL_SELECT_ALL_ARTICLE = "select * from ARTICLES_VENDUS;";
	private final static String SQL_UPDATE_ARTICLE = ";";
	private final static String SQL_DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?;";
	
	@SuppressWarnings("null")
	public Article ajouterArticle() throws DALException {
	
		Article article = null;
		try(Connection connection = ConnectionProvider.getPoolConnexion()){
			
			PreparedStatement pSt = connection.prepareStatement(SQL_INSERT_ARTICLE);
			pSt.setInt(1, article.getNoArticle() );
			pSt.setString(2, article.getNomArticle() );
			pSt.setString(3, article.getDescription() );
			pSt.setDate(4,(Date) article.getDateDebutEnchere() );
			pSt.setDate(5,(Date) article.getDateFinEnchere() );
			pSt.setInt(6, article.getPrixInitial() );
			pSt.setInt(7, article.getPrixVente());
			pSt.setInt(8, article.getNoUtilisateur());
			pSt.setInt(9, article.getNoCategorie());
			pSt.setString(10, article.getEtatVente() );
			pSt.setString(11, article.getImage());
			pSt.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
			throw new DALException("errreur SQL_INSERT_ARTICLE");
		}
		
		return null;
	}
	
	public ArrayList<Article> selectAllArticle() throws DALException {
		// création d'une liste pour contenir le résultat
		ArrayList<Article> articles = new ArrayList<Article>();
		// création d'un token
		Article article = null;
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {
			// statement classique car pas de choix précis on prend tous
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_ARTICLE);
			// boucle while pour implémenter la liste et y mettre toutes nos valeurs
			while (rs.next()) {
				article = (Article) rs.getArray(article.getNoArticle());
				articles.add(article);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		// return de la list d'article
		return articles;
	}
	
	
	public Article encherirArticle() throws DALException {
		
		return null;
	}
	
	public Article enchereAnnule(int numeroArticle ) throws DALException {
		
		try(Connection connection = ConnectionProvider.getPoolConnexion()) {
			PreparedStatement pSt = connection.prepareStatement(SQL_DELETE_ARTICLE);
			pSt.setInt(1, numeroArticle);
			pSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_DELETE_ARTICLE");
		}
		
		return null;
	}
}
