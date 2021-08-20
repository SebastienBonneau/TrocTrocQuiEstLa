package fr.eni.jee.projet.dal.impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.eni.jee.projet.bo.Article;
import fr.eni.jee.projet.dal.ArticlesDAO;
import fr.eni.jee.projet.dal.ConnectionProvider;
import fr.eni.jee.projet.dal.DALException;


public class ArticleDAOJdbcImpl implements ArticlesDAO {

	private final static String SQL_INSERT_ARTICLE = "insert into ARTICLES_VENDUS where no_article=?, nom_article=?,"
			+ " description=?, date_debut_enchere=?, date_fin_enchere=?, prix_inital=?, prix_vente = ?,"
			+ " no_utilisateur=?, no_categorie=?, etat_vente=? image=?;";
	private final static String SQL_SELECT_ALL_ARTICLE = "select * from ARTICLES_VENDUS;";
	private final static String SQL_UPDATE_ETAT_ARTICLE = "update ARTICLES_VENDUS set etat_vente=? where no_article=?;";
	private final static String SQL_DELETE_ARTICLE = "delete from ARTICLES_VENDUS where no_article=?;";
	
	
	@SuppressWarnings("null")
	public Article ajouterArticle() throws DALException {
	
		Article article = null;
		try(Connection connection = ConnectionProvider.getPoolConnexion()){
			
			PreparedStatement pSt = connection.prepareStatement(SQL_INSERT_ARTICLE);
			pSt.setInt(1, article.getNoArticle() );
			pSt.setString(2, article.getNomArticle() );
			pSt.setString(3, article.getDescription() );
			pSt.setDate(4,(Date) article.getDateDebutEnchere() );
			pSt.setDate(5,(Date) article.getDateFinEnchere() );
			pSt.setInt(6, article.getPrixInitial() );
			pSt.setInt(7, article.getPrixVente());
			pSt.setInt(8, article.getNoUtilisateur());
			pSt.setInt(9, article.getNoCategorie());
			pSt.setString(10, article.getEtatVente() );
			pSt.setString(11, article.getImage());
			pSt.executeUpdate();
		} catch (SQLException e) {
			e.getMessage();
			throw new DALException("errreur SQL_INSERT_ARTICLE");
		}
		
		return null;
	}
	
	public ArrayList<Article> selectAllArticle() throws DALException {
		// cr�ation d'une liste pour contenir le r�sultat
		ArrayList<Article> articles = new ArrayList<Article>();
		// cr�ation d'un token
		Article article = null;
		try (Connection connection = ConnectionProvider.getPoolConnexion()) {
			// statement classique car pas de choix pr�cis on prend tous
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL_ARTICLE);
			// boucle while pour impl�menter la liste et y mettre toutes nos valeurs
			while (rs.next()) {
				article = (Article) rs.getArray(article.getNoArticle());
				articles.add(article);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_SELECT_ALL_ARTICLE");
		}
		// return de la list d'article
		return articles;
	}
	
	
	@SuppressWarnings("null")
	public Article changementEtatArticle() throws DALException {
		Article article = null;
		try(Connection connection = ConnectionProvider.getPoolConnexion()) {
			PreparedStatement pSt = connection.prepareStatement(SQL_UPDATE_ETAT_ARTICLE);
			pSt.setString(1, article.getEtatVente());
			pSt.setInt(2, article.getNoArticle());
			pSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_UPDATE_ETAT_ARTICLE");
		}
		return null;
	}
	
	public Article enchereAnnule(int numeroArticle ) throws DALException {
		
		try(Connection connection = ConnectionProvider.getPoolConnexion()) {
			PreparedStatement pSt = connection.prepareStatement(SQL_DELETE_ARTICLE);
			pSt.setInt(1, numeroArticle);
			pSt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("erreur SQL_DELETE_ARTICLE");
		}
		
		return null;
	}
	
	
}
