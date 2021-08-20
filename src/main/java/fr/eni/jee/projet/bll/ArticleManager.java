package fr.eni.jee.projet.bll;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.DALException;

public class ArticleManager {

	private static ArticleManager instance;
	private ArticlesDAO daoArticle;
	

	
	
	
	public void changementEtat (Article a) throws BLLException {
		
		try {
			daoArticle.changementEtatArticle(a);
		} catch (DALException e) {
			throw new BLLException("Erreur méthode changementEtat" + e.getMessage());
		}
	}
	
	public void enchereAnnule (int i) throws BLLException {
		
		try {
			daoArticle.enchereAnnule(i);
		} catch (DALException e) {
			throw new BLLException("Erreur méthode enchereAnnule" + e.getMessage());
		}
	}
	
	
	public void updateEtatArticle (Article a) throws BLLException {
		try {
			daoArticle.changementEtatArticle(a);
		} catch (DALException e) {
			throw new BLLException("Erreur méthode updateEtatArticle" + e.getMessage());
		}
	}
	
	
public static ArticleManager getInstance() {
	if (instance == null) {
		instance = new ArticleManager();
	}
	return instance;
}

}