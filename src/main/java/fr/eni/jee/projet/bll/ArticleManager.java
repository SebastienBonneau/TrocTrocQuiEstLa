package fr.eni.jee.projet.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;

public class ArticleManager {

	private ArticlesDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}

	public void validerArticle (Article a) throws BLLException {
		if (a.getNom_article() == null) {
			throw new BLLException("Erreur n� Article");
		}
		if (a.getDescription() == null) {
			throw new BLLException("Erreur Description");
		}
		if (a.getDate_debut_enchere() == null) {
			throw new BLLException("Erreur date d�but d'ench�re");
		}
		if (a.getDate_fin_enchere() == null) {
			throw new BLLException("Erreur date fin ench�re");
		}
		if (a.getNo_utilisateur() < 0) {
			throw new BLLException("Erreur n� Utilisateur");
		}
		if (a.getNo_categorie() < 0) {
			throw new BLLException("Erreur n� Cat�gorie");
		}
		if (a.getEtat_vente() == null) {
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

	public void ajouterArticle(int no_article, String nom_article, String description, LocalDate date_debut_enchere,
			LocalDate date_fin_enchere, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie,
			String etat_vente, String image) {
			Article article = new Article(no_article, nom_article,description, date_debut_enchere, date_fin_enchere, etat_vente, prix_initial, prix_vente, no_utilisateur, no_categorie);
		
	}

	public void ajouterArticle(String nom_article, String description, LocalDate date_debut_enchere,
			LocalDate date_fin_enchere, int prix_initial, int no_categorie, String etat_vente) {
		// TODO Auto-generated method stub
		
	}

}