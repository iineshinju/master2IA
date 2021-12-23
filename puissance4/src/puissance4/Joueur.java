package puissance4;

public abstract class Joueur {

	public final static int HORIZONTALE = 1;
	public final static int VERTICALE = 2;
	public final static int DIAGONALE = 3;
	public final static int EGALITE = 4;

	protected Grille g;
	
	protected Joueur adversaire;
	private String nom = "";
	protected Jeton jetonJ;
	protected Coordonnee[] position = new Coordonnee[21]; // memoire des placements de nos jetons

	public Joueur(String nom, Jeton jetonJ, Grille g) {
		this.nom = nom;
		this.jetonJ = jetonJ;
		this.g = g;
	}

	public Joueur(Jeton jetonJ, Grille g) {
		this.jetonJ = jetonJ;
		this.g = g;
	}

	public String getNom() {
		return this.nom;
	}
	
	public Coordonnee[] getPosition() {
		return this.position;
	}
	
	public int dernierIndiceTab(Coordonnee[] tableau) {
		int verification = 0;
		for (int i = 0; i < tableau.length; i++) {
			if (tableau[i] != null)
				verification++;
		}
		return verification;
	}
	
	public void jouerAvec(Joueur j) {
		j.adversaire = this;
		this.adversaire = j;
		System.out.println("Le jeu peut commencer.");
		deroulementJeu(this, j);
	}

	private static void deroulementJeu(Joueur placeur, Joueur observateur) {
		int etat = 0;
		int nbJetons = 0;
		while (!(etat == HORIZONTALE || etat == VERTICALE || etat == DIAGONALE || etat == EGALITE)) {
			System.out.println("Au tour de : " + placeur.nom);
			etat = placeur.choixPlacement();
			nbJetons += 1;
			if (nbJetons == 42)
				etat = 4;
			placeur.retourPlacement(etat);
			observateur.retourObservation(etat);
			Joueur x = placeur;
			placeur = observateur;
			observateur = x;
		}
	}

	protected abstract void retourPlacement(int etat);

	protected abstract void retourObservation(int etat);

	public abstract int choixPlacement();


}