package fr.eni.jee.projet.dal;

import fr.eni.jee.projet.dal.impl.ArticleDAOJdbcImpl;
import fr.eni.jee.projet.dal.impl.CategorieDAOJdbcImpl;
import fr.eni.jee.projet.dal.impl.UtilisateursDAOJdbcImpl;

public class DAOFactory {
	
	public static UtilisateursDAO getUtilisateursDAO() {
		UtilisateursDAO utilisateursDAO = new UtilisateursDAOJdbcImpl();
		return utilisateursDAO;
	}
	
	public static ArticlesDAO getArticleDAO() {
		ArticlesDAO articlesDAO = new ArticleDAOJdbcImpl();
		return articlesDAO;
	}
	
	public static CategorieDAO getCategorieDAO() {
		CategorieDAO categorieDAO = new CategorieDAOJdbcImpl();
		return categorieDAO;
	}

}
