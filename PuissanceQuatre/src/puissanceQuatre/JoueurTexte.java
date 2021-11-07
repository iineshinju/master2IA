package puissanceQuatre;

import java.util.Scanner;

import puissanceQuatre.Coordonnee;
import puissanceQuatre.Grille;
import puissanceQuatre.JoueurAvecGrille;
public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc = new Scanner(System.in);
	
	public JoueurTexte(Grille g, String nom ) {
		}
	
	public JoueurTexte(Grille g) {
	}
	
	protected void retourPlacement(Coordonnee c, int etat) {
	}
	
	protected void retourObservation(Coordonnee c, int etat) {
	}
	
	public Coordonnee choixPlacement() {
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
