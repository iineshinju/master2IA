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
		Coordonnee[] adv = adversaire.getPosition();
		int colonne = 0;
		int indice = this.dernierIndiceTab(adv);
		Coordonnee[] voisinVideIndice = null;

		if (this.tableauNull(adv)) {
			colonne = this.poidsColonne();
			System.out.println("Je suis dans le if");
		} else {
			System.out.println("Je suis dans le else");
			try {
				if (indice == 1) {
					voisinVideIndice = this.voisinVide(indice, adv);
					System.out.println("voisinVide 1 " + this.affichagetab(voisinVideIndice));

				} else if (indice > 1) {
					voisinVideIndice = this.concatenationVide(indice, adv);
					System.out.println("voisinVide 1+" + this.affichagetab(voisinVideIndice));
				}

				int[] valVoisin = new int[voisinVideIndice.length];
				for (int i = 0; i < this.dernierIndiceTab(voisinVideIndice); i++) {
					valVoisin[i] = verifVoisin(voisinVideIndice[i], adv);
					System.out.println("verifVoisin "+ i + " : "+ valVoisin[i]);
				}
				
				colonne = voisinVideIndice[this.indiceMaxTab(valVoisin)].getColonne();
			} catch (ArrayIndexOutOfBoundsException e) {
				int[] val = new int[7];
				for (int j = 0; j < 7; j++) {
					if (this.indiceJouable(j))
						val[j] = 1;
				}
				for (int k = 0; k < val.length; k++) {
					if (val[k] == 1)
						colonne = k;
				}
			}
		}

		this.g.ajouteJeton(this.jetonJ, colonne);
		System.out.println("position : " + this.affichagetab(adv));

		System.out.println(this.g.toString());

		if (this.g.enHorizontale(this.g.getDernierJeton(), this.jetonJ.getCouleur()))
			return 1;
		else if (this.g.enVerticale(this.g.getDernierJeton(), this.jetonJ.getCouleur()))
			return 2;
		else if (this.g.enDiagonale(this.g.getDernierJeton(), this.jetonJ.getCouleur()))
			return 3;
		return 0;
	}

	@Override
	protected void retourPlacement(int etat) {// Retourne le message en fonction de l'etat
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
	protected void retourObservation(int etat) { // Retourne un message en fonction du jeu de l'adversaire
		if (etat == 1)
			System.out.println("Vous avez perdu en Verticale.");
		else if (etat == 2)
			System.out.println("Vous avez perdu en Horizontale.");
		else if (etat == 3)
			System.out.println("Vous avez perdu en Diagonale.");
		else if (etat == 4)
			System.out.println("Egalite !");
	}

	public static void main(String[] args) {
		Grille g = new Grille();
		Jeton j = new Jeton();
		Jeton r = new Jeton(true);
		JoueurDefensif a = new JoueurDefensif("JoueurA Defensif", j, g);
		JoueurGrille b = new JoueurGrille("JoueurB", r, g);
		b.jouerAvec(a);

	}

}
