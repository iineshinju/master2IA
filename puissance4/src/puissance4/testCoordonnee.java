package puissance4;

public class testCoordonnee {
	
	public static boolean testCoordonneeEmpty() {
		try {
			Coordonnee c = new Coordonnee();
		} catch (IllegalArgumentException e){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false; //Si on n'a pas attrapé l'exception c'est que les null sont accepté
	}
	
	public static boolean testCoordonneeNotInRangeColonne() {
		try {
			Coordonnee c = new Coordonnee(1, 7); // 7 est la 8e lettre de l'alphabet soit H, il ne fait pas partie de la grille
		} catch (IllegalArgumentException e){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}
	
	public static boolean testCoordonneeNotInRangeLigne() {
		try {
			Coordonnee c = new Coordonnee(6, 1); // 6 est la 7e ligne, elle ne fait pas partie de la grille
		} catch (IllegalArgumentException e){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}
	
	public static boolean testCoordonneeInRange() {
		try {
			Coordonnee c = new Coordonnee(1, 1);
		} catch (IllegalArgumentException e){
			return false; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return true;
	}
	
	public static boolean testCoordonneeNotInRange() {
		try {
			Coordonnee c = new Coordonnee(6, 7);
		} catch (IllegalArgumentException e){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}
	
	public static boolean testCoordonneeStringIncorrect() {
		try {
			Coordonnee c = new Coordonnee("H7");
		} catch (IllegalArgumentException e){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}

	public static boolean testCoordonneeStringCorrect() {
		try {
			Coordonnee c = new Coordonnee("A1");
		} catch (IllegalArgumentException e){
			return false; 
		}
		return true;
	}
	
	public static boolean testGetLigne() {
		Coordonnee c = new Coordonnee("A1");
		int ligne = c.getLigne();
		return ligne == 0;
	}
	
	public static boolean testGetColonne() {
		Coordonnee c = new Coordonnee("A1");
		int colonne = c.getColonne();
		return colonne == 0;
	}
	
	public static boolean testCompareToEquals() {
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee d = new Coordonnee(1,1);
		int compare = c.compareTo(d);
		return compare == 0;
	}
	
	public static boolean testCompareToLigne() {
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee d = new Coordonnee(0,1);
		int compare = c.compareTo(d);
		return compare == 1;
	}
	
	public static boolean testCompareToColonne() {
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee d = new Coordonnee(2,0);
		int compare = c.compareTo(d);
		return compare == -1;
	}
	
	public static boolean testEquals() {
		Coordonnee c = new Coordonnee(0,0);
		Coordonnee d = new Coordonnee(0,0);
		return c.equals(d);
	}
	
	public static boolean testVoisineHautDroit() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("D2");
		return c.voisine(d);
	}
	
	public static boolean testVoisineHautGauche() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("B2");
		return c.voisine(d);
	}
	
	public static boolean testVoisineDroit() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("D3");
		return c.voisine(d);
	}
	
	public static boolean testVoisineGauche() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("B3");
		return c.voisine(d);
	}
	
	public static boolean testVoisineBasDroit() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("D4");
		return c.voisine(d);
	}
	
	public static boolean testVoisineBasGauche() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("B4");
		return c.voisine(d);
	}
	
	public static boolean testVoisineHaut() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("C2");
		return c.voisine(d);
	}
	
	public static boolean testVoisineBas() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("C4");
		return c.voisine(d);
	}
	
	public static boolean testNonVoisine() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("F4");
		return c.voisine(d);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
