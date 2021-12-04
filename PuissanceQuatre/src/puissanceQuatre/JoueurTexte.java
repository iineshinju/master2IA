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
	
	protected void retourPlacement(int etat) {
		if(etat == 1) 
			System.out.println("Vous avez gagné en horizontale"+'\n');
		 if(etat == 2) 
			System.out.println("Vous avez gagné en verticale"+'\n');
		 if(etat == 3) 
			System.out.println("Vous avez gagné en diagonale"+'\n');
		 if(etat == 4) 
			System.out.println("Vous êtes à égalité avec votre adversaire"+'\n');
	}
	
	protected void retourObservation(int etat) {
		if(etat == 1) 
			System.out.println("Votre adversaire a gagné en horizontale"+'\n');
		 if(etat == 2) 
			System.out.println("Votre adversaire a gagné en verticale"+'\n');
		 if(etat == 3) 
			System.out.println("Votre adversaire a gagné en diagonale"+'\n');
		 if(etat == 4) 
			System.out.println("Vous êtes à égalité avec votre adversaire"+'\n');
	}
	
	public Coordonnee choixPlacement() {
		int etat=0;
		System.out.println(this.g.toString());
		System.out.println("Entrez la colonne de placement");
		int colonne = sc.next();
		Coordonnee c = null;
		try {
			this.g.ajouteJeton(this.couleurJ, colonne);
			Coordonnee c = this.g.getDernierJeton();
			Coordonnee[] memoire2= new Coordonnee[this.memoire.length+1];
			for(int i=0; i<this.memoire.length; i++) {
				memoire2[i]=this.memoire[i];
			}
			memoire2[memoire2.length-1]=c;
			boolean couleur = this.couleurJ.getCouleur();
			if(this.g.enHorizontale( c, couleur)) 
				etat=1;
			else if( this.g.enVerticale(c, couleur))
				etat=2;
			else if( this.g.enDiagonaleDecroissant(c, couleur || this.g.enDiagonaleCroissant(c, couleur))
				etat=3;
			else
				etat=4;	
			return etat;
		}
		catch (IllegalArgumentException l) {
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
