package fr.hb.poker.business;


public class Carte {
	
	//Attributs
	private Integer valeur;
	private String nom;
	private Couleur couleur;
	
	//Constructeur
	public Carte(Integer valeur, Couleur couleur) {
		this.valeur = valeur;
		this.couleur = couleur;
		switch (valeur) {
        case 11:
            nom = "Valet";
            break;
        case 12:
            nom = "Dame";
            break;
        case 13:
            nom = "Roi";
            break;
        case 14:
            nom = "As";
            break;
        default:
            nom = String.valueOf(valeur);
            break;
		}
	}
	public static void remove(int i) {
		// TODO Auto-generated method stub
		
	}

	//Get et Set
	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//ToString
	@Override
	public String toString() {
		return nom + " de " + couleur.getNom();
	}

	
	

}