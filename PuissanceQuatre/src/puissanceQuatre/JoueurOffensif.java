package puissanceQuatre;

import java.util.Scanner;

public class JoueurOffensif extends JoueurGrille {
	//private int[] poids = {1, 10, 50, 100};
	//private int[] poids = {0,0,0,1,0,0,0};

	public JoueurOffensif(Jeton jeton) {
		super(jeton);
	}
	
	public JoueurOffensif(String nom, Jeton jeton) {
		super(nom, jeton);
	}
	
	public int CompteVoisin(Coordonnee c) {
		int voisin = 0;
		int col = c.getColonne();
		int lig = c.getLigne();
		
		for(int i=0; i<= memoire.length ; i++) {
			if(memoire[i].getLigne() == lig) {
				if(memoire[i].getColonne() == col+1 || memoire[i].getColonne() == col-1)
					voisin ++;
			}
			if(memoire[i].getLigne() == lig +1 || memoire[i].getLigne() == lig -1) {
				if(memoire[i].getColonne() == col+1 || memoire[i].getColonne() == col-1 || memoire[i].getColonne() == col)
					voisin ++;
			}
		}
		return voisin;
	}
	
	public int CompteVoisinLoin(Coordonnee c) {
		int voisin = 0;
		int col = c.getColonne();
		int lig = c.getLigne();
		
		for(int i=0; i<= memoire.length ; i++) {
			if(memoire[i].getLigne() <= lig +2 && memoire[i].getLigne() >= lig - 2) {
				if(memoire[i].getColonne() <= col+2 || memoire[i].getColonne() >= col-2)
					voisin ++;
			}
		}
		return voisin;
	}
	
	public int choixPlacement() {//retour etat de ton jeu apres ton placement
		int choix = 0 ;
		for(int i=0; i<= 6 ; i++) {
			if(this.CompteVoisin(new Coordonnee(g.getLigne(i),i)) > choix)
				choix = this.CompteVoisin(new Coordonnee(g.getLigne(i),i));
		}
		g.ajouteJeton(jeton, choix);
		return 0;
	}

	protected void retourPlacement(int etat) {//Retourne le message en fonction de l'etat
		
	}

	protected void retourObservation(int etat) { //Retourne un message en fonction du jeu de l'adversaire
		
	}

}
