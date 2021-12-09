package puissanceQuatre;

import java.util.Scanner;

public class JoueurGrille extends Joueur {
	
	private Grille g;
	private Scanner sc = new Scanner(System.in);
	
	public JoueurGrille(String nom, Jeton couleurJ, Grille grille) {
		super(nom, couleurJ);
		g = grille;
		
	}
	
	public JoueurGrille(Jeton couleurJ, Grille grille) {
		super(couleurJ);
		g = grille;
	}
	
	public Grille getG() {
		return this.g;
	}
	
	@Override
	public int choixPlacement() {//retour etat de ton jeu apres ton placement
		 sc = new Scanner(System.in);
	   	 System.out.println("Donner la colonne dans laquelle vous voulez mettre votre jeton : ");
	   	 String c = sc.next();
	   	int colonne = Integer.parseInt(c );
		g.ajouteJeton(couleurJ, colonne);
		
		if(g.enHorizontale(g.getDernierJeton(), couleurJ.getCouleur()))
			return 1;
		else if (g.enVerticale(g.getDernierJeton(), couleurJ.getCouleur()))
			return 2;
		else if (g.enDiagonale(g.getDernierJeton(), couleurJ.getCouleur()))
			return 3;
		return 0;
	}

	@Override
	protected void retourPlacement(int etat) {//Retourne le message en fonction de l'etat
		if (etat == 1)
			System.out.println("Vous avez gagn� en Verticale");
		else if (etat == 2)
			System.out.println("Vous avez gagn� en Horizontale ");
		else if (etat == 3)
			System.out.println("Vous avez gagn� en Diagonale ");
		else if (etat == 4)
			System.out.println("Egalit� ! ");
		
		
	}

	@Override
	protected void retourObservation(int etat) { //Retourne un message en fonction du jeu de l'adversaire
		if (etat == 1)
			System.out.println("Vous avez perdu en Verticale");
		else if (etat == 2)
			System.out.println("Vous avez perdu en Horizontale ");
		else if (etat == 3)
			System.out.println("Vous avez perdu en Diagonale ");
		else if (etat == 4)
			System.out.println("Egalité ! ");
		
	}

	

	

}
