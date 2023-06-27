package fr.hb.poker.business;



public class Couleur {
	
	//Attributs
	private String nom;

	//Constructeur
	public Couleur(String nom) {
		super();
		this.nom = nom;
	}

	//Get et Set
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Couleur [nom=" + nom + "]";
	}	

}