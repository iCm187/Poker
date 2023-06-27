package fr.hb.poker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import com.github.javafaker.Faker;
import java.util.Scanner;

import fr.hb.poker.business.Carte;
import fr.hb.poker.business.Combinaison;
import fr.hb.poker.business.Couleur;
import fr.hb.poker.business.Joueur;
import fr.hb.poker.business.Ville;


public class App {
	
		// Attributs
		private static List<Couleur> couleurs = new ArrayList<>();
		private static List<Carte> cartes = new ArrayList<>();
		private static List<Joueur> joueurs = new ArrayList<>();
		private static List<Ville> villes = new ArrayList<>();
		private static Scanner scanner = new Scanner(System.in);
		private static final String FORMAT_DATE = "dd/MM/yyyy";
		private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE);
		private static final int NB_CARTES_A_REMETTRE_A_CHAQUE_JOUEUR = 5;
		private static final String URL_FICHIER_CSV = "https://www.clelia.fr/villes2020.csv";

    	public static void main(String[] args) {
    		
            System.out.println("Bienvenue sur Poker Booster !");
            
            constituerJeu();
            melangerJeu();
            afficherJeu();
            ajouterJoueurs();
            distribuerCartes();
            afficherVilles();
            analyserMain(joueurs.get(0));
            demanderPseudo();
            demanderDateDeNaissance();
            importerVilles();
  
            for (Joueur joueur : joueurs) {
                System.out.println((joueur));            
            }
    	}
    	
        private static String demanderPseudo() {
			System.out.println("Veuillez saisir votre pseudo");
			return scanner.nextLine();			
		}
        
		private static void afficherVilles() {
			// TODO Auto-generated method stub
			
		}
		
		private static Combinaison analyserMain(Joueur joueur) {
		    List<Carte> main = new ArrayList<>(joueur.getMain());
		    int[] occurrencesParValeur = new int[15];

		    for (Carte carte : main) {
		        int valeurCarte = carte.getValeur();
		        occurrencesParValeur[valeurCarte]++;
		    }

		    // Vérifier les différentes combinaisons de cartes
		    for (int i = 2; i <= 14; i++) {
		        switch (occurrencesParValeur[i]) {
		            case 2:
		                // Paire
		                if (occurrencesParValeur[i] == 2) {
		                    return Combinaison.PAIRE;
		                }
		                // Faites quelque chose pour gérer la paire
		                break;
		            case 3:
		                // Brelan
		                if (occurrencesParValeur[i] == 3) {
		                    return Combinaison.BRELAN;
		                }
		                // Faites quelque chose pour gérer le brelan
		                System.out.println("Vous avez un Brelan.");
		                break;
		            case 4:
		                // Carré
		                if (occurrencesParValeur[i] == 4) {
		                    return Combinaison.CARRE;
		                }
		                // Faites quelque chose pour gérer le carré
		                System.out.println("Vous avez un Carré.");
		                break;
		            case 5:
		                // Double paire
		                if (occurrencesParValeur[i] == 2) {
		                    return Combinaison.DOUBLE_PAIRE;
		                }
		                // Faites quelque chose pour gérer la double paire
		                System.out.println("Vous avez une Double paire.");
		                break;
		            case 6:
		                // Suite
		                if (occurrencesParValeur[i] == 1) {
		                    return Combinaison.SUITE;
		                }
		                // Faites quelque chose pour gérer la suite
		                System.out.println("Vous avez une Suite.");
		                break;
		            case 7:
		                // Couleur
		                if (occurrencesParValeur[i] == 1) {
		                    return Combinaison.COULEUR;
		                }
		                // Faites quelque chose pour gérer la couleur
		                System.out.println("Vous avez une Couleur.");
		                break;
		            case 8:
		                // Carte haute
		                if (occurrencesParValeur[i] == 1) {
		                    return Combinaison.CARTE_HAUTE;
		                }
		                // Faites quelque chose pour gérer la carte haute
		                System.out.println("Vous avez une Carte haute.");
		                break;
		            case 9:
		                // Quinte flush
		                if (occurrencesParValeur[i] == 1) {
		                    return Combinaison.QUINTE_FLUSH;
		                }
		                // Faites quelque chose pour gérer la quinte flush
		                System.out.println("Vous avez une Quinte flush.");
		                break;
		            case 10:
		                // Quinte flush royal
		                if (occurrencesParValeur[i] == 1) {
		                    return Combinaison.QUINTE_FLUSH_ROYALE;
		                }
		                // Faites quelque chose pour gérer la quinte flush royal
		                System.out.println("Vous avez une Quinte flush royal.");
		                break;
		            default:
		                // Rien à faire pour les autres occurrences
		                break;
		        }
				System.out.print(occurrencesParValeur[i]);
			}
			return null;
		}

        private static void distribuerCartes() {
            
            for (int i = 0; i < 5 ; i++) {
            	for(Joueur joueur : joueurs) {
                    Carte carte = cartes.remove(0);
                    joueur.getMain().add(carte);
            	}            
            }
        }
			
		private static void ajouterJoueurs() {
			List<String> pseudos = Arrays.asList("Ibrahim", "Jean-Paul", "Ewan", "Ibra", "Romain", "Mohamed", "Adnane", "Killian", "Ryad", "Younous");
			pseudos.forEach(pseudo -> joueurs.add(new Joueur (pseudo)));
		}
		private static void afficherJeu() {
			
		}
		private static void melangerJeu() {
			Collections.shuffle(cartes);
		}
		private static void constituerJeu() {
			// TODO Auto-generated method stub
			Couleur couleur1 = new Couleur("Coeur");
			Couleur couleur2 = new Couleur("Trèfle");
			Couleur couleur3 = new Couleur("Carreau");
			Couleur couleur4 = new Couleur("Pique");
			
			couleurs.add(couleur1);
			couleurs.add(couleur2);
			couleurs.add(couleur3);
			couleurs.add(couleur4);
			
			//parcourir la liste des couleurs
			for (Couleur couleur : couleurs) {
				//Pour chaque couleur ajoute 13 cartes
				for (int i = 2; i <= 14; i++) {
					cartes.add(new Carte(i, couleur));
				}
			}
			System.out.println(cartes);
		}
		
		private static int importerVilles() {
			 URL url = null;
			 int compteur = 0;

	         try {
	                 url = new URL(URL_FICHIER_CSV);
	         } catch (MalformedURLException e) {
	                 System.out.println("Fichier CSV indisponible, raison : " + e.getMessage());
	                 System.exit(-1);
	         }

		         // On parcourt le fichier CSV et on ajoute des villes dans la liste locale
		         // Utilisation d'un try with resources (les ressources seront fermées par Java)
		         try (Reader reader = new InputStreamReader(url.openStream(), "UTF-8");
		        		// La classe BufferedReader offre une méthode readLine()
		        		 BufferedReader bufferedReader = new BufferedReader(reader);
		        		 ) {
		             String ligne = "";
		             // On lit la première ligne du fichier CSV
		             // qui correspond à l'entête
		             bufferedReader.readLine();

	             // Tant qu'il y a des lignes à lire dans le fichier CSV
		             // D'abord on affecte l'objet ligne avec ce que renvoie
		             // la méthode readLine()
		             // puis on teste si l'objet ligne est différent de null
	             while ((ligne = bufferedReader.readLine()) != null) {
	            	 System.out.println(ligne);
	                     String[] elements = ligne.split(";");
	                     // On récupère le nom de la ville
	                     // dans la deuxième colonne
	                     String nom = elements[1];
	                     String codePostal = elements[2];
	                     double latitude = 0;
	                     double longitude = 0;
	                     // Certaines lignes n'ont pas de coordonnées
	                     // si la ligne contient 6 données
	                     // (length renvoie le nombre de cases du tableau)
	                     if (elements.length == 6) {
	                             String coordonnees = elements[5];
	                             latitude = Double.parseDouble(coordonnees.split(",")[0]);
	                             longitude = Double.parseDouble(coordonnees.split(",")[1]);
	                     }
	                     
	                     Ville ville = new Ville();
	                     ville.setNom(nom);
	                     ville.setCodePostal(codePostal);
	                     ville.setLongitude(longitude);
	                     ville.setLatitude(latitude);
	                     villes.add(ville);
	                     compteur++;
	             }
	         } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return compteur;
		  }
		private static LocalDate demanderDateDeNaissance() {
			System.out.println("Veuillez saisir votre date de naissance du type " + FORMAT_DATE);
			String dateDeNaissance = scanner.nextLine();
			return LocalDate.parse(dateDeNaissance, dateTimeFormatter);
			
		}
	}