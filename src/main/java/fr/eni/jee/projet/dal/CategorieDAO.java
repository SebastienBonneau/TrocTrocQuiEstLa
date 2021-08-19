package fr.eni.jee.projet.dal;

import java.util.List;

import fr.eni.jee.projet.bo.Categorie;

public interface CategorieDAO {
	
	public List<Categorie> ListerCategorie() throws DALException;
	
}
