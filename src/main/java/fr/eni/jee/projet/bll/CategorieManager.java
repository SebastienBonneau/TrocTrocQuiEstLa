package fr.eni.jee.projet.bll;

import java.util.List;

import fr.eni.jee.projet.bo.Categorie;
import fr.eni.jee.projet.dal.CategorieDAO;
import fr.eni.jee.projet.dal.DALException;
import fr.eni.jee.projet.dal.DAOFactory;

public class CategorieManager {
	
	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}

	public List<Categorie> selectCategorie() throws BLLException {
		
		List<Categorie> listCategorie = null;
		
		try {
			listCategorie = this.categorieDAO.ListerCategorie();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException(e.getMessage());
		}
		
		return listCategorie;
	}

}
