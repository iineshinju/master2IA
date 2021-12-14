package puissance4;

public class JoueurDefensif extends JoueurIA {
	
	protected Coordonnee[] position = new Coordonnee[21];

	public JoueurDefensif(String nom, Jeton jetonJ, Grille grilleJ) {
		super(nom, jetonJ, grilleJ);
	}
	
	public JoueurDefensif(Jeton jetonJ, Grille grilleJ) {
		super(jetonJ, grilleJ);
	}
	
	@Override
	public int choixPlacement() {
		this.position= adversaire.getPosition();
		int colonne;
		int indice = this.dernierIndiceTab(this.position);
		Coordonnee[] voisinVideIndice = null;
		
	   	if (this.tableauNull(this.position)) {
	   		colonne = this.poidsColonne();
	   	} else {
	   		if (indice == 1) {
	   			try {
	   			System.out.println(this.voisinVide(indice));
	   			voisinVideIndice = this.voisinVide(indice);
	   			}
	   			catch() {
	   			}
	   		} else if (indice > 1){
	   			voisinVideIndice = this.concatenationVide(indice);
	   		}

	   		int[] valVoisin = new int[voisinVideIndice.length];
	   		for(int i = 0; i < this.dernierIndiceTab(voisinVideIndice) ; i++) {
	   			valVoisin[i] = verifVoisin(voisinVideIndice[i]);
	   			
	   		}
	   		
	   		colonne = voisinVideIndice[this.indiceMaxTab(valVoisin)].getColonne();
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
			System.out.println("Egalit� !");
		
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
		Grille g = new Grille();
		Jeton j = new Jeton();
		Jeton r = new Jeton(true);
		JoueurIA a = new JoueurDefensif("JoueurA", j, g);
	   	JoueurGrille b = new JoueurGrille("JoueurB", r, g);
	   	b.jouerAvec(a);	

	}

}
