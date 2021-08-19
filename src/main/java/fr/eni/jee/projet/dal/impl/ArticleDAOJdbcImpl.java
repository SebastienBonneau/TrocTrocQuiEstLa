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
	private final static String SQL_DELETE_ARTICLE = ";";
	
	public Article ajouterArticle() throws DALException {
	
		return null;
	}
	
	public ArrayList<Article> selectAllArticle() throws DALException {
		ArrayList<Article> articles = new ArrayList<Article>();
		Article article = null;
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_ARTICLE);
			
			while (rs.next()) {
				article = (Article) rs.getArray(article.getNoArticle());
				articles.add(article);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		return articles;
	}
	
	
	public Article encherirArticle() throws DALException {
		
		return null;
	}
	
	public Article enchereAnnule() throws DALException {
		return null;
	}
}
