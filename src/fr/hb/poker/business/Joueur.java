package fr.hb.poker.business;

import java.time.LocalDate;

import java.util.*;

public class Joueur {
	
	//Attributs
	private Long id;
	private String pseudo;
	private LocalDate dateDeNaissance;
	private float solde;
	private Set<Carte> main;
	//on associe une ville a un joueur
	private Ville ville;
	private static Long compteur = 0L;
	
	public static final float SOLDE_INITIAL = 50;

	//Contructeur
	public Joueur() {
		id = ++compteur;
		main = new HashSet<>();
		solde = SOLDE_INITIAL;
	}
	public Joueur(String pseudo) {
		this();
		this.pseudo = pseudo;
	}
	public Joueur(String pseudo, LocalDate dateDeNaissance) {
		this(pseudo);
		this.dateDeNaissance = dateDeNaissance;
	}
	public Joueur(String pseudo, LocalDate dateDeNaissance, Ville ville) {
		this(pseudo, dateDeNaissance);
		this.ville = ville;
	}
	
	//Get et Set
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public float getSolde() {
		return solde;
	}
	public void setSolde(float solde) {
		this.solde = solde;
	}
	public Set<Carte> getMain() {
		return main;
	}
	public void setMain(Set<Carte> main) {
		this.main = main;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	public static float getSoldeInitial() {
		return SOLDE_INITIAL;
	}
	
	//toString
	@Override
	public String toString() {
		return "Joueur [id=" + id + ", pseudo=" + pseudo + ", dateDeNaissance=" + dateDeNaissance + ", solde=" + solde
				+ ", main=" + main + ", ville=" + ville + "]";
	}	
}