package puissance4;

import java.util.Scanner;

public class JoueurGrille extends Joueur {
	
	private Scanner sc = new Scanner(System.in);
	
	public JoueurGrille(String nom, Jeton jetonJ, Grille grilleJ) {
		super(nom, jetonJ, grilleJ);
	}
	
	public JoueurGrille(Jeton jetonJ, Grille grilleJ) {
		super(jetonJ, grilleJ);
	}
	
	@Override
	public int choixPlacement() {//retour etat de ton jeu apres ton placement
		sc = new Scanner(System.in);
		boolean restart = true;
		int colonne = 0;
		
		System.out.println("Donner le numéro de colonne dans laquelle vous voulez mettre votre jeton de 1 à 7 : ");
		
		while (restart) {
		   	colonne = sc.nextInt() - 1;
		   	try {
			   	this.g.ajouteJeton(this.jetonJ, colonne);
		   		restart = false;
		   	} catch (IllegalArgumentException e) {
		   		restart = true;
		   		System.out.println("Valeur donnée incorrect.\n"
		   				+ "Donner le numéro de colonne dans laquelle vous voulez mettre votre jeton de 1 à 7 : ");
		   	} catch (ArrayIndexOutOfBoundsException e) {
		   		restart = true;
		   		System.out.println("Valeur donnée incorrect.\n"
		   				+ "La colonne choisit est pleine, choissisez en une autre dans laquelle vous pouvez mettre votre jeton : ");
		   	} catch (Exception e) {
		   		restart = true;
		   		System.out.println("Valeur donnée incorrect.\n"
		   				+ "Donner un numéro de colonne valide entre 1 et 7 : ");
		   	}
	   	}
	   	
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
		JoueurGrille a = new JoueurGrille("JoueurA", j, g);
	   	JoueurGrille b = new JoueurGrille("JoueurB", r, g);
	   	a.jouerAvec(b);
	}
}