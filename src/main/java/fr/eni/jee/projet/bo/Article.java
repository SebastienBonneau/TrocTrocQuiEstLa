package fr.eni.jee.projet.bo;

import java.util.Date;

public class Article {

	private int noArticle, prixInitial, prixVente, noUtilisateur, noCategorie;
	private String nomArticle, description, etatVente, image;
	private Date dateDebutEnchere, DateFinEnchere;
	
	
	public int getNoArticle() {
		return noArticle;
	}

	public int getPrixInitial() {
		return prixInitial;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public int getNoCategorie() {
		return noCategorie;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public String getImage() {
		return image;
	}

	public Date getDateDebutEnchere() {
		return dateDebutEnchere;
	}

	public Date getDateFinEnchere() {
		return DateFinEnchere;
	}

	public Article(int noArticle, int prixInitial, int prixVente, int noUtilisateur, int noCategorie, String nomArticle,
			String description, String etatVente, String image, Date dateDebutEnchere, Date dateFinEnchere) {
		super();
		this.noArticle = noArticle;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.noUtilisateur = noUtilisateur;
		this.noCategorie = noCategorie;
		this.nomArticle = nomArticle;
		this.description = description;
		this.etatVente = etatVente;
		this.image = image;
		this.dateDebutEnchere = dateDebutEnchere;
		DateFinEnchere = dateFinEnchere;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public void setPrixInitial(int prixInitial) {
		this.prixInitial = prixInitial;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setDateDebutEnchere(Date dateDebutEnchere) {
		this.dateDebutEnchere = dateDebutEnchere;
	}

	public void setDateFinEnchere(Date dateFinEnchere) {
		DateFinEnchere = dateFinEnchere;
	}
	
	
	
	
	
	
}
