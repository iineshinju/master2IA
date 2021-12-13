package puissance4;

public class testJoueurIA {
	
	static Jeton j = new Jeton();
	
	public static boolean testPoidsColonneToutVide() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		return ia.poidsColonne() == 0;
	}
	
	public static boolean testPoidsColonneUnVide() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(j, 6);
		g.ajouteJeton(j, 2);
		return ia.poidsColonne() == 4;
	}

	public static boolean testPoidsColonne() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(j, 4);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(j, 4);
		g.ajouteJeton(j, 6);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(j, 2);
		g.ajouteJeton(j, 0);
		return ia.poidsColonne() == 2;
	}
	
	public static boolean testPositionNull() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		return ia.positionNull(ia.position);
	}
	
	public static boolean testPositionIndice() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		for (int i = 0; i < 3; i++) {
			ia.position[i] = new Coordonnee(5,i);
		}
		return ia.positionIndice(ia.position) == 3;
	}
	
	public static boolean testVoisinVide() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(ia.jetonJ, 0);
		ia.position[0] = g.getDernierJeton();
		ia.voisinVide(1);
		System.out.println(g.getLigne(0));
		System.out.println(g.getLigne(1));
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testPoidsColonneToutVide());
		System.out.println(testPoidsColonneUnVide());
		System.out.println(testPoidsColonne());
		System.out.println(testPositionNull());
		System.out.println(testPositionIndice());
		System.out.println(testVoisinVide());
	}

}
