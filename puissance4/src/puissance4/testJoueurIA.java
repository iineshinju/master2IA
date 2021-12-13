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
		return ia.tableauNull(ia.position);
	}
	
	public static boolean testPositionIndice() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		for (int i = 0; i < 3; i++) {
			ia.position[i] = new Coordonnee(5,i);
		}
		return ia.dernierIndiceTab(ia.position) == 3;
	}
	
	public static boolean testVerifVide() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		Coordonnee c = new Coordonnee("A6");
		return ia.verifVide(c);
	}
	
	public static boolean testDiagDecroissantHaut() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("B6");
		return ia.diagDecroissantHaut(c) == 1;
	}
	
	public static boolean testDiagDecroissantBas() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 1);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("A5");
		return ia.diagDecroissantBas(c) == 1;
	}
	
	public static boolean testDiagCroissantHaut() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 1);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 1);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("A6");
		return ia.diagCroissantHaut(c) == 1;
	}
	
	public static boolean testDiagCroissantBas() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 1);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("B5");
		return ia.diagCroissantBas(c) == 1;
	}
	
	public static boolean testGauche() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 1);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("C6");
		return ia.gauche(c) == 2;
	}
	
	public static boolean testDroite() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 2);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 1);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("A6");
		return ia.droite(c) == 2;
	}
	
	public static boolean testBas() {
		Grille g = new Grille();
		JoueurIA ia = new JoueurIA(j, g);
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		g.ajouteJeton(j, 0);
		ia.position[ia.dernierIndiceTab(ia.position)]= g.getDernierJeton();
		Coordonnee c = new Coordonnee("A4");
		return ia.bas(c) == 2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testPoidsColonneToutVide());
		System.out.println(testPoidsColonneUnVide());
		System.out.println(testPoidsColonne());
		System.out.println(testPositionNull());
		System.out.println(testPositionIndice());
		System.out.println(testVerifVide());
		System.out.println(testDiagDecroissantHaut());
		System.out.println(testDiagDecroissantBas());
		System.out.println(testDiagCroissantHaut());
		System.out.println(testDiagCroissantBas());
		System.out.println(testGauche());
		System.out.println(testDroite());
		System.out.println(testBas());
	}

}
