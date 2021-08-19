package fr.eni.jee.projet.bll;

import fr.eni.jee.projet.dal.CategorieDAO;
import fr.eni.jee.projet.dal.DAOFactory;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getUtilisateursDOA();
	}

}
