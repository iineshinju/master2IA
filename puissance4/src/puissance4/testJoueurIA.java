package puissance4;

public class testJoueurIA {
	
	static Jeton j = new Jeton();
	
	public static boolean poidsColonneToutVide() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		return ia.poidsColonne() == 0;
	}
	
	public static boolean poidsColonneUnVide() {
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

	public static boolean poidsColonne() {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(poidsColonneToutVide());
		System.out.println(poidsColonneUnVide());
		System.out.println(poidsColonne());
		
	}

}
