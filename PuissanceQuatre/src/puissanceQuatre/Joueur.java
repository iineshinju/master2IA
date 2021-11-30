package puissanceQuatre;

public abstract class Joueur {

	public final static int HORIZONTALE = 1;
	public final static int VERTICALE = 2;
	public final static int DIAGONALE = 3;
	public final static int EGALITE = 4;

	private Coordonnee[] memoire; // memoire des placements des jetons d’une couleur

	private Joueur adversaire;
	private String nom;
	protected Jeton couleurJ;

	public Joueur(String nom, Jeton couleurJ) {
		this.nom = nom;
		this.couleurJ = couleurJ;
	}

	public Joueur(Jeton couleurJ) {
		this.couleurJ = couleurJ;
	}

	public String getNom() {
		return this.nom;
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
		while (etat != HORIZONTALE || etat != VERTICALE || etat != DIAGONALE || etat != EGALITE) {
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