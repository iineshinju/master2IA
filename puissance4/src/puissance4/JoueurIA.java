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
		int maxVal = 0;
		int indiceMax = 0;
		for (int i = 0; i < poids.length ; i++) {
			int ligne = this.g.getLigne(i);
			poids[i] = ligne;
		    if (poids[i] > maxVal) {
		       maxVal = poids[i];
		       indiceMax = i;
		    }
		}
		return indiceMax;
	}
	
	public boolean positionNull(Coordonnee[] tableau) {
		int verification = 0;
		for (int i = 0; i < tableau.length; i++) {
			if (tableau[i] == null)
				verification++;
		}
		return verification == this.position.length;
	}
	
	public int positionIndice(Coordonnee[] tableau) {
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
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne), initColonne);

			if (this.g.getLigne(initColonne + 1) == initLigne)
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			else if (this.g.getLigne(initColonne + 1) + 1 == initLigne)
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			else if (initLigne !=5 && this.g.getLigne(initColonne + 1) + 1 == initLigne + 1) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1) + 1, initColonne +1);
				
		} else if (initColonne == 6) {

			if (this.g.getLigne(initColonne) + 1 == initLigne)
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne), initColonne);
			
			if (this.g.getLigne(initColonne - 1) == initLigne)
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			else if (this.g.getLigne(initColonne - 1) + 1 == initLigne)
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			else if (initLigne !=5 && this.g.getLigne(initColonne - 1) + 1 == initLigne + 1) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1) + 1, initColonne -1);
		
		} else {
			if (this.g.getLigne(initColonne) + 1 == initLigne) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne), initColonne);
			
			if (this.g.getLigne(initColonne + 1) == initLigne) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			else if (this.g.getLigne(initColonne + 1) + 1 == initLigne) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1), initColonne +1);
			else if (initLigne !=5 && this.g.getLigne(initColonne + 1) + 1 == initLigne + 1) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne + 1) + 1, initColonne +1);
			
			if (this.g.getLigne(initColonne - 1) == initLigne) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			else if (this.g.getLigne(initColonne - 1) + 1 == initLigne)
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1), initColonne -1);
			else if (initLigne !=5 && this.g.getLigne(initColonne - 1) + 1 == initLigne + 1) 
				vide[positionIndice(vide)] = new Coordonnee(this.g.getLigne(initColonne - 1) + 1, initColonne -1);
		}
		System.out.println("Vide : " + this.affichagetab(vide));
		return vide;
	}
	
	public Coordonnee[] concatenationVide(int indice) {
		Coordonnee[] casesVide = new Coordonnee[42];
		// PROBLEME DANS CETTE METHODE A CORRIGER
		for (int i = 2; i < indice + 1; i++) {
			Coordonnee[] intermediaire =  this.voisinVide(i);
			System.out.println("concat-intermediaire : "+ this.affichagetab(intermediaire));
			for (int j = 0; j < intermediaire.length; j++) {
				if (intermediaire[j] != null)
					casesVide[this.positionIndice(casesVide)] = intermediaire[j];
			}
		}
		System.out.println("concatenation casesVide : "+ this.affichagetab(casesVide));
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
	
	@Override
	public int choixPlacement() {//retour etat de ton jeu apres ton placement
		int colonne;
		int indice = this.positionIndice(this.position);
		Coordonnee[] voisinVideIndice = null;
		
	   	if (this.positionNull(this.position)) {
	   		colonne = this.poidsColonne();
	   	} else {
	   		if (indice == 1) {
	   			voisinVideIndice = this.voisinVide(indice);
	   		} else if (indice > 1){
	   			voisinVideIndice = this.concatenationVide(indice);
	   		} else {
	   			colonne = this.poidsColonne();
	   		}
	   		int randomI = (int)(Math.random()*(this.positionIndice(voisinVideIndice)));
	   		System.out.println("positionIndice : "+this.positionIndice(this.position));
	   		System.out.println("voisinIndice : "+this.positionIndice(voisinVideIndice));
	   		System.out.println("randomI : " + randomI);
	   		colonne = this.positionNull(voisinVideIndice) ? this.poidsColonne() : voisinVideIndice[randomI].getColonne();
	   		System.out.println("colonne : "+colonne);
	   		System.out.println("voisinVide"+this.affichagetab(voisinVideIndice));
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
