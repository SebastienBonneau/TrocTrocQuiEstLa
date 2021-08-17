package fr.eni.jee.projet.bo;

public class User {
	
	private String identifiant;
	private String motDePasse;
	
	public User(String identifiant, String motDePasse) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

}
