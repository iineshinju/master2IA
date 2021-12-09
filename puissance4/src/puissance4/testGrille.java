package puissance4;

public class testGrille {
	
	static Jeton j = new Jeton(true);
	static Jeton r = new Jeton();
	
	public static boolean getDernierJetonVide() {
		Grille g = new Grille();
		try {
			g.getDernierJeton();
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}
	
	public static boolean getDernierJeton() {
		Grille g = new Grille();
		g.ajouteJeton(j, 0);
		Coordonnee dj;
		try {
			dj = g.getDernierJeton();
		} catch (IllegalArgumentException e) {
			return false;
		}
		return new Coordonnee(5,0).equals(dj);
	}

	public static boolean testEnVerticale() {
		Grille g = new Grille();
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 5);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 6);
		g.ajouteJeton(j, 1);
		Coordonnee dj = g.getDernierJeton();
		return g.enVerticale(dj, j.getCouleur());
	}
	
	public static boolean testEnHorizontale() {
		Grille g = new Grille();
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 3);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 4);
		Coordonnee dj = g.getDernierJeton();
		return g.enHorizontale(dj, r.getCouleur());
	}
	
	public static boolean testEnDiagonaleDecroissant() {
		Grille g = new Grille();
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 2);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 4);
		g.ajouteJeton(j, 2);
		Coordonnee dj = g.getDernierJeton();
		return g.enDiagonaleDecroissant(dj, j.getCouleur());
	}
	
	public static boolean testEnDiagonaleCroissant() {
		Grille g = new Grille();
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 2);
		g.ajouteJeton(r, 3);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 4);
		g.ajouteJeton(j, 3);
		Coordonnee dj = g.getDernierJeton();
		return g.enDiagonaleCroissant(dj, j.getCouleur());
	}
	
	public static boolean testEnDiagonaleTrueTrue() {
		Grille g = new Grille();
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 2);
		g.ajouteJeton(r, 3);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 4);
		g.ajouteJeton(j, 4);
		g.ajouteJeton(r, 5);
		g.ajouteJeton(j, 4);
		g.ajouteJeton(r, 4);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(r, 5);
		g.ajouteJeton(j, 6);
		g.ajouteJeton(r, 6);
		g.ajouteJeton(j, 3);
		Coordonnee dj = g.getDernierJeton();
		return g.enDiagonaleCroissant(dj, j.getCouleur()) && g.enDiagonaleDecroissant(dj, j.getCouleur());
	}
	
	public static boolean testEnDiagonaleTrueFalse() {
		Grille g = new Grille();
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 2);
		g.ajouteJeton(r, 3);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 4);
		g.ajouteJeton(j, 3);
		Coordonnee dj = g.getDernierJeton();
		return g.enDiagonaleCroissant(dj, j.getCouleur()) || g.enDiagonaleDecroissant(dj, j.getCouleur());
	}
	
	public static boolean testEnDiagonaleFalseTrue() {
		Grille g = new Grille();
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 2);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 0);
		g.ajouteJeton(j, 3);
		g.ajouteJeton(r, 4);
		g.ajouteJeton(j, 2);
		Coordonnee dj = g.getDernierJeton();
		return g.enDiagonaleCroissant(dj, j.getCouleur()) || g.enDiagonaleDecroissant(dj, j.getCouleur());
	}
	
	public static boolean testEnDiagonaleFalseFalse() {
		Grille g = new Grille();
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 1);
		g.ajouteJeton(j, 5);
		g.ajouteJeton(r, 2);
		g.ajouteJeton(j, 0);
		g.ajouteJeton(r, 3);
		g.ajouteJeton(j, 1);
		g.ajouteJeton(r, 4);
		Coordonnee dj = g.getDernierJeton();
		return g.enDiagonaleCroissant(dj, j.getCouleur()) || g.enDiagonaleDecroissant(dj, j.getCouleur());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDernierJetonVide());
		System.out.println(getDernierJeton());
		System.out.println(testEnVerticale());
		System.out.println(testEnHorizontale());
		System.out.println(testEnDiagonaleDecroissant());
		System.out.println(testEnDiagonaleCroissant());
		System.out.println("true true : " + testEnDiagonaleTrueTrue());
		System.out.println("true false : " + testEnDiagonaleTrueFalse());
		System.out.println("false true : " + testEnDiagonaleFalseTrue());
		System.out.println("false false : " + testEnDiagonaleFalseFalse());
	}

}
