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
		System.out.println(this.grille.toString());
		System.out.println("Entrez la coordonnée de placement");
		String input = sc.next();
		Coordonnee c = new Coordonnee(input);
		int i=0;
		while(memoire[i]!=c && i<this.memoire.length) {
			i++;
		}
		if(i==this.memoire.length) {
			Coordonnee[] memoire2= new Coordonnee[this.memoire.length+1];
			for(int i=0; i<this.memoire.length; i++) {
				memoire2[i]=this.memoire[i];
			}
			memoire2[memoire2.length-1]=c;
			if(this.grille.enHorizontale( c, this.couleurJ)) 
				etat=1;	
			else if( this.grille.enVerticale(c, this.couleurJ))
				etat=2;
			else if( this.grille.enDiagonaleDecroissant(c, this.couleurJ) || this.grille.enDiagonaleCroissant(c, this.couleurJ))
				etat=3;
			else
				etat=4;	
			return etat;
		}
		else
			throw new IllegalArgumentException("La case que vous avez choisit est déjà occupée, Choisissez une autre coordonnée");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
