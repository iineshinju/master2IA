package puissanceQuatre;

import java.util.Scanner;

import puissanceQuatre.Coordonnee;
import puissanceQuatre.Grille;
import puissanceQuatre.JoueurAvecGrille;
public class JoueurTexte extends JoueurAvecGrille {
	private Scanner sc = new Scanner(System.in);
	
	public JoueurTexte(String nom, boolean couleur) {
		super(nom,couleur);
		}
	
	public JoueurTexte(boolean couleur) {
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
