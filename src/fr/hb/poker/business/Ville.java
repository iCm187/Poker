package fr.hb.poker.business;

import java.util.*;


public class Ville {

	//Attributs
		private static Long id;
		private static String nom;
		private static String codePostal;
		private Double latitude;
		private Double longitude;
		private String codeInsee;
		private static Long compteur = 0L;
		
		//Constructeur
		public Ville() {
			id = ++compteur;
		}

		public Ville(Long id, String nom, String codePostal) {
			this();
			this.nom = nom;
			this.codePostal = codePostal;
		}

		public Ville() {
			this(id, nom, codePostal);
			this.latitude = latitude;
			this.longitude = longitude;
			this.codeInsee = codeInsee;
		}

		//Get et Set
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getCodePostal() {
			return codePostal;
		}

		public void setCodePostal(String codePostal) {
			this.codePostal = codePostal;
		}

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public String getCodeInsee() {
			return codeInsee;
		}

		public void setCodeInsee(String codeInsee) {
			this.codeInsee = codeInsee;
		}

		// toString		
		@Override
		public String toString() {
			return "Ville [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + ", latitude=" + latitude
					+ ", longitude=" + longitude + ", codeInsee=" + codeInsee + "]";
		}
		
}