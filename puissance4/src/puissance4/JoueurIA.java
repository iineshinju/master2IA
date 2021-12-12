package puissance4;

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
	
	@Override
	public int choixPlacement() {//retour etat de ton jeu apres ton placement
		
	   	System.out.println("Donner la colonne dans laquelle vous voulez mettre votre jeton : ");
		
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
		
	}

}
