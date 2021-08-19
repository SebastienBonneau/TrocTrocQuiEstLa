package fr.eni.jee.projet.dal.impl;


import java.sql.Connection;
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

	private final static String SQL_INSERT_ARTICLE = ";";
	private final static String SQL_SELECT_ALL_ARTICLE = "select * from ARTICLES_VENDUS;";
	private final static String SQL_UPDATE_ARTICLE = ";";
	private final static String SQL_DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?;";
	
	public Article ajouterArticle() throws DALException {
	
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
