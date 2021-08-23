package fr.eni.jee.projet.dal;

import java.util.List;

import fr.eni.jee.projet.bo.Article;

public interface ArticlesDAO {

	void ajouterArticle(Article article) throws DALException;
	
	List<Article> selectAllArticle() throws DALException;
 
	void changementEtatArticle(Article article) throws DALException;

	void enchereAnnule (int numeroArticle) throws DALException;
}
 