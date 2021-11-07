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
		super(couleur);
	}
	
	protected void retourPlacement(Coordonnee c, int etat) {
		if(etat == 1) 
			System.out.println("Vous avez gagné en horizontale"+'\n');
		 if(etat == 2) 
			System.out.println("Vous avez gagné en verticale"+'\n');
		 if(etat == 3) 
			System.out.println("Vous avez gagné en diagonale"+'\n');
		 if(etat == 4) 
			System.out.println("Vous êtes à égalité avec votre adversaire"+'\n');
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
