package fr.eni.jee.projet.bll;

import java.util.List;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.bo.Categorie;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.DALException;

public class ArticleManager {

	private ArticlesDAO articleDAO;
	

	public void validerArticle (Article a) throws BLLException {
		if (a.getNomArticle() == null) {
			throw new BLLException("Erreur n� Article");
		}
		if (a.getDescription() == null) {
			throw new BLLException("Erreur Description");
		}
		if (a.getDateDebutEnchere() == null) {
			throw new BLLException("Erreur date d�but d'ench�re");
		}
		if (a.getDateFinEnchere() == null) {
			throw new BLLException("Erreur date fin ench�re");
		}
		if (a.getNoUtilisateur() < 0) {
			throw new BLLException("Erreur n� Utilisateur");
		}
		if (a.getNoCategorie() < 0) {
			throw new BLLException("Erreur n� Cat�gorie");
		}
		if (a.getEtatVente() == null) {
			throw new BLLException("Erreur �tat vente");
		}
	}
	
	
	public List<Article> selectEnchere() throws BLLException {
		
		List<Article> listeEnchere = null;
		try {
			listeEnchere = this.articleDAO.selectAllArticle();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		return listeEnchere;
	}
	

	public void changementEtat (Article a) throws BLLException {
		
		try {
			this.validerArticle(a);
			articleDAO.changementEtatArticle(a);
		} catch (DALException e) {
			throw new BLLException("Erreur m�thode changementEtat" + e.getMessage());
		}
	}
	
	public void enchereAnnule (int i) throws BLLException {
		
		try {
			articleDAO.enchereAnnule(i);
		} catch (DALException e) {
			throw new BLLException("Erreur m�thode enchereAnnule" + e.getMessage());
		}
	}
	
	
	public void updateEtatArticle (Article a) throws BLLException {
		try {
			this.validerArticle(a);
			articleDAO.changementEtatArticle(a);
		} catch (DALException e) {
			throw new BLLException("Erreur m�thode updateEtatArticle" + e.getMessage());
		}
	}

}