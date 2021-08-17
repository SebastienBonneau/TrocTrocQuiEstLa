package fr.eni.jee.projet.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	
	// ATtribut de la classe (tatic) qui correspond a notre POOL de connection
		private static DataSource dataSource ; 
	
	// INITIALISATION DU DATASOURCE  
	// Static : Bloc de code qui est  executé  UNE fois pour la classe 
	// ( on veut s'assurer qu'on ne cherche pas  à récuperer plusieurs fois la DataSource)
		
		static {
			try {
				Context context = new InitialContext();
			
	// On utilise pas this.dataSOurce car dataSource ets un attribut fde la classee (static).
	// ... il faut donc pas utiliser le nom de 
			
				ConnectionProvider.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/pool_cnx");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		
		/*
		 * getConnection() : Méthode qui va être utilisé pas les DAOImpl pour recuperer 
		 * une connection de pool
		 */
		
		public static Connection getPoolConnexion() throws SQLException {
			return ConnectionProvider.dataSource.getConnection();
		}
	}
