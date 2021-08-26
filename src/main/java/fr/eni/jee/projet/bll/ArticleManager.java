package fr.eni.jee.projet.bll;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.bo.Categorie;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;

public class ArticleManager {

	private ArticlesDAO articleDAO;
	
	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleDAO();
	}
	// méthode pour check si un article est valable pour être inséré en BDD
	public void validerArticle (Article a) throws BLLException {
		if (a.getNom_article() == null) {
			throw new BLLException("Erreur nï¿½ Article");
		}
		if (a.getDescription() == null) {
			throw new BLLException("Erreur Description");
		}
		if (a.getDate_debut_enchere() == null) {
			throw new BLLException("Erreur date dï¿½but d'enchï¿½re");
		}
		if (a.getDate_fin_enchere() == null) {
			throw new BLLException("Erreur date fin enchï¿½re");
		}
		if (a.getPrix_initial() < 0) {
			throw new BLLException("Erreur Prix initial négatif");
		}
		if (a.getNo_utilisateur() < 0) {
			throw new BLLException("Erreur nï¿½ Utilisateur");
		}
		if (a.getNo_categorie() < 0) {
			throw new BLLException("Erreur nï¿½ Catï¿½gorie");
		}
		if (a.getEtat_vente() == null) {
			throw new BLLException("Erreur ï¿½tat vente");
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
			throw new BLLException("Erreur mï¿½thode changementEtat" + e.getMessage());
		}
	}
	
	public void enchereAnnule (int i) throws BLLException {
		
		try {
			articleDAO.enchereAnnule(i);
		} catch (DALException e) {
			throw new BLLException("Erreur mï¿½thode enchereAnnule" + e.getMessage());
		}
	}
	
	
	public void updateEtatArticle (Article a) throws BLLException {
		try {
			this.validerArticle(a);
			articleDAO.changementEtatArticle(a);
		} catch (DALException e) {
			throw new BLLException("Erreur mï¿½thode updateEtatArticle" + e.getMessage());
		}
	}
	
	public List<Article> listeEnchereEC() throws BLLException {
		
		List<Article> listeEnchere = null;
		try {
			listeEnchere = this.articleDAO.selectEnchereEC();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		return listeEnchere;
	}

	public List<Article> listeEnchereCR() throws BLLException {
		
		List<Article> listeEnchere = null;
		try {
			listeEnchere = this.articleDAO.selectEnchereCR();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		return listeEnchere;
	}

	public List<Article> listeEnchereVD() throws BLLException {
		
		List<Article> listeEnchere = null;
		try {
			listeEnchere = this.articleDAO.selectEnchereVD();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		return listeEnchere;
	}

	public void ajouterArticle(String nom_article, String description, LocalDateTime date_debut_enchere, LocalDateTime date_fin_enchere, 
			int prix_initial, int no_categorie) throws BLLException {
			Article article = new Article(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_categorie);
			try {
				articleDAO.ajouterArticle(article);
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BLLException(e.getMessage());
			}
	}


}