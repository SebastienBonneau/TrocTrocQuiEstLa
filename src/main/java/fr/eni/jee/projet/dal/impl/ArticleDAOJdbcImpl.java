package fr.eni.jee.projet.dal.impl;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.DALException;

public class ArticleDAOJdbcImpl implements ArticlesDAO {

	private final static String SQL_INSERT_ARTICLE = ";";
	private final static String SQL_SELECT_ALL_ARTICLE = ";";
	private final static String SQL_UPDATE_ARTICLE = ";";
	private final static String SQL_DELETE_ARTICLE = ";";
	
	public Article ajouterArticle() throws DALException {
	
		return null;
	}
	
	public Article selectAllArticle() throws DALException {
		
		return null;
	}
	
	
	public Article encherirArticle() throws DALException {
		
		return null;
	}
	
	public Article enchereAnnule() throws DALException {
		return null;
	}
}
