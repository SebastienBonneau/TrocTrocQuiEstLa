package fr.eni.jee.projet.bo;

import java.time.LocalDateTime;

public class Article {

	private int  no_article, prix_initial, prix_vente;
	private String nom_article, description, etat_vente, image;
	private LocalDateTime date_debut_enchere, date_fin_enchere;
	private Utilisateur no_utilisateur;
	private Categorie no_categorie;

	public Article(String nom_article, String description, LocalDateTime date_debut_enchere, LocalDateTime date_fin_enchere, int prix_initial, int prix_vente,
			Utilisateur no_utilisateur, Categorie no_categorie, String etat_vente, String image) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.etat_vente = etat_vente;
		this.image = image;
	}

	

	public Article(int no_article, String nom_article, String description, LocalDateTime date_debut_enchere, LocalDateTime date_fin_enchere, int prix_initial, int prix_vente,
			Utilisateur no_utilisateur, Categorie no_categorie, String etat_vente, String image) {
		this(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente, image);
		this.no_article = no_article;
	}

	

	public Article(String nom_article, String description, LocalDateTime date_debut_enchere, LocalDateTime date_fin_enchere,
			 int prix_initial, Categorie no_categorie, String image) {
		super();
		this.prix_initial = prix_initial;
		this.nom_article = nom_article;
		this.description = description;
		this.image = image;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.no_categorie = no_categorie;
	}



	public int getNo_article() {
		return no_article;
	}
	

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public Utilisateur getNo_utilisateur() {
		return no_utilisateur;
	}

	public Categorie getNo_categorie() {
		return no_categorie;
	}

	public String getNom_article() {
		return nom_article;
	}

	public String getDescription() {
		return description;
	}

	public String getEtat_vente() {
		return etat_vente;
	}

	public String getImage() {
		return image;
	}

	public LocalDateTime getDate_debut_enchere() {
		return date_debut_enchere;
	}

	public LocalDateTime getDate_fin_enchere() {
		return date_fin_enchere;
	}
	
}
