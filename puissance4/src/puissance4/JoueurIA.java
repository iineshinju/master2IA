package puissance4;

import java.lang.Math;   

public class JoueurIA extends Joueur {
	
	protected Coordonnee[] position = new Coordonnee[21]; // memoire des placements de nos jetons

	public JoueurIA(String nom, Jeton jetonJ, Grille grilleJ) {
		super(nom, jetonJ, grilleJ);
	}
	
	public JoueurIA(Jeton jetonJ, Grille grilleJ) {
		super(jetonJ, grilleJ);
	}
	
	public int poidsColonne() {
		int[] poids = new int[7]; // on crée un tableau contenant le nombre de ligne vide dans chaque colonne
		int maxVal = 5;
		int ligneMin = 0;
		
		for (int i = 0; i < poids.length ; i++) {
			int ligne = this.g.getLigne(i);
			poids[i] = ligne;
			
		    if (poids[i] < maxVal) {
		       maxVal = poids[i];
		       ligneMin = i;
		    }
		}
		
		if (ligneMin == 0)
			ligneMin = 4;
		if (ligneMin == 6)
			ligneMin = 5;
		else
		    ligneMin += Math.random() * (3) -1;  
		return ligneMin;
	}
	
	public boolean tableauNull(Coordonnee[] tableau) {
		int verification = 0;
		for (int i = 0; i < tableau.length; i++) {
			if (tableau[i] == null)
				verification++;
		}
		return verification == this.position.length;
	}
	
	public int dernierIndiceTab(Coordonnee[] tableau) {
		int verification = 0;
		for (int i = 0; i < tableau.length; i++) {
			if (tableau[i] != null)
				verification++;
		}
		return verification;
	}
	
	public Coordonnee[] voisinVide(int indice) {
		Coordonnee initial = this.position[indice-1];
		int initLigne = initial.getLigne();
		int initColonne = initial.getColonne();
		Coordonnee[] vide = new Coordonnee[21];
		
		if (initColonne == 0) {
			if (this.g.getLigne(initColonne) + 1 == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne), initColonne);

			if (this.g.getLigne(initColonne + 1) == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			else if (this.g.getLigne(initColonne + 1) + 1 == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			
			if (initLigne !=5 && (this.g.getLigne(initColonne + 1) == initLigne + 1)) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(initLigne + 1, initColonne +1);
				
		} else if (initColonne == 6) {

			if (this.g.getLigne(initColonne) + 1 == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne), initColonne);
			
			if (this.g.getLigne(initColonne - 1) == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			else if (this.g.getLigne(initColonne - 1) + 1 == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			
			if (initLigne !=5 && (this.g.getLigne(initColonne - 1) == initLigne + 1))
				vide[dernierIndiceTab(vide)] = new Coordonnee(initLigne + 1, initColonne -1);
		
		} else {
			if (this.g.getLigne(initColonne) + 1 == initLigne) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne), initColonne);
			
			if (this.g.getLigne(initColonne + 1) == initLigne) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			else if (this.g.getLigne(initColonne + 1) + 1 == initLigne) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			
			if (initLigne !=5 && (this.g.getLigne(initColonne + 1) == initLigne + 1)) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(initLigne + 1, initColonne +1);
			
			if (this.g.getLigne(initColonne - 1) == initLigne) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			else if (this.g.getLigne(initColonne - 1) + 1 == initLigne)
				vide[dernierIndiceTab(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			
			if (initLigne !=5 && (this.g.getLigne(initColonne + 1) == initLigne + 1)) 
				vide[dernierIndiceTab(vide)] = new Coordonnee(initLigne + 1, initColonne -1);
		}
		
		return vide;
	}
	
	public Coordonnee[] concatenationVide(int indice) {
		Coordonnee[] casesVide = new Coordonnee[82];

		for (int i = 1; i < indice + 1; i++) {
			Coordonnee[] intermediaire =  this.voisinVide(i);
			for (int j = 0; j < intermediaire.length; j++) {
				if (intermediaire[j] != null)
					casesVide[this.dernierIndiceTab(casesVide)] = intermediaire[j];
			}
		}
		return casesVide;
	}
	
	public String affichagetab(Coordonnee[] tab) {
		String res = "[ ";
		for (int i = 0 ; i < tab.length; i++) {
			if (tab[i] != null)
				res += tab[i] + ", ";
		}
		res += "]";
		return res;
	}
	
	public int indiceMaxTab(int[] tab) {
		int valeurMax = tab[0];
		int indiceMax = 0;
		
		for (int i = 1; i < tab.length; i++) {
			if (tab[i] > valeurMax) {
				valeurMax = tab[i];
				indiceMax = i;
			}
		}
			
		return indiceMax;
	}
	
	public boolean verifVide(Coordonnee c) {
		int ligneC = c.getLigne();
		int colonneC = c.getColonne();
		int ligneVerif = this.g.getLigne(colonneC);
		return ligneVerif == ligneC;
	}
	
	public int verifVoisin(Coordonnee c) {
		int[] v = new int[4];
		v[0] = diagDecroissant(c);
		v[1] = gauche(c) + droite(c);
		v[2] = diagCroissant(c);
		v[3] = bas(c);
		return indiceMaxTab(v);
		
	}
	
	public int diagDecroissant(Coordonnee c) {
		if()
			
	}
	
	public int diagCroissant(Coordonnee c) {
		return 0;
	}
	
	public int gauche(Coordonnee c) {
		return 0;
	}
	
	public int droite(Coordonnee c) {
		return 0;
	}
	
	public int bas(Coordonnee c) {
		return 0;
			
	}
	
	@Override
	public int choixPlacement() {//retour etat de ton jeu apres ton placement
		int colonne;
		int indice = this.dernierIndiceTab(this.position);
		Coordonnee[] voisinVideIndice = null;
		
	   	if (this.tableauNull(this.position)) {
	   		colonne = this.poidsColonne();
	   	} else {
	   		if (indice == 1) {
	   			voisinVideIndice = this.voisinVide(indice);
	   		} else if (indice > 1){
	   			voisinVideIndice = this.concatenationVide(indice);
	   		}
	   		int randomI = (int)(Math.random()*(this.dernierIndiceTab(voisinVideIndice)));
	   		colonne = this.tableauNull(voisinVideIndice) ? this.poidsColonne() : voisinVideIndice[randomI].getColonne();
	   	}
		
		this.g.ajouteJeton(this.jetonJ, colonne);
		position[indice]= g.getDernierJeton();
   		System.out.println("position : " + this.affichagetab(this.position));

		System.out.println(this.g.toString());
		
		if(this.g.enHorizontale(this.g.getDernierJeton(), this.jetonJ.getCouleur()))
			return 1;
		else if (this.g.enVerticale(this.g.getDernierJeton(), this.jetonJ.getCouleur()))
			return 2;
		else if (this.g.enDiagonale(this.g.getDernierJeton(), this.jetonJ.getCouleur()))
			return 3;
		return 0;
	}

	@Override
	protected void retourPlacement(int etat) {//Retourne le message en fonction de l'etat
		if (etat == 1)
			System.out.println("Vous avez gagné en Verticale.");
		else if (etat == 2)
			System.out.println("Vous avez gagné en Horizontale.");
		else if (etat == 3)
			System.out.println("Vous avez gagné en Diagonale.");
		else if (etat == 4)
			System.out.println("Egalité !");
		
	}

	@Override
	protected void retourObservation(int etat) { //Retourne un message en fonction du jeu de l'adversaire
		if (etat == 1)
			System.out.println("Vous avez perdu en Verticale.");
		else if (etat == 2)
			System.out.println("Vous avez perdu en Horizontale.");
		else if (etat == 3)
			System.out.println("Vous avez perdu en Diagonale.");
		else if (etat == 4)
			System.out.println("Egalité !");
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grille g = new Grille();
		Jeton j = new Jeton();
		Jeton r = new Jeton(true);
		JoueurIA a = new JoueurIA("JoueurA", j, g);
	   	JoueurGrille b = new JoueurGrille("JoueurB", r, g);
	   	b.jouerAvec(a);		
	}

}
