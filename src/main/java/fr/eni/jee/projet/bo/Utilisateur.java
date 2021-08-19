package fr.eni.jee.projet.bo;

public class Utilisateur {
	
	private String pseudo ,nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe ;
	private int	no_utilisateur, credit ;
	private boolean administrateur ;
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	public Utilisateur(int	no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
		this(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);
		this.no_utilisateur = no_utilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getRue() {
		return rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public String getVille() {
		return ville;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public int getCredit() {
		return credit;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	
}
