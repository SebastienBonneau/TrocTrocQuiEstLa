package fr.eni.jee.projet.dal;

import fr.eni.jee.projet.dal.impl.UtilisateursDAOJdbcImpl;

public class DAOFactory {
	
	public static UtilisateursDAO getUtilisateursDOA() {
		UtilisateursDAO utilisateursDAO = new UtilisateursDAOJdbcImpl();
		return utilisateursDAO;
	}

}
