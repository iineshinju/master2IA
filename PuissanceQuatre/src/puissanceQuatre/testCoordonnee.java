package puissanceQuatre;

public class testCoordonnee {
	
	public boolean testCoordonneeEmpty() {
		try {
			Coordonnee c = new Coordonnee();
		} catch (IllegalArgumentException e)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false; //Si on n'a pas attrapé l'exception c'est que les null sont accepté
	}
	
	public boolean testCoordonneeNotInRangeColonne() {
		try {
			Coordonnee c = new Coordonnee(1, 7); // 7 est la 8e lettre de l'alphabet soit H, il ne fait pas partie de la grille
		} catch (IllegalArgumentException e)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}

	public boolean testCoordonneeNotInRangeLigne() {
		try {
			Coordonnee c = new Coordonnee(6, 1); // 6 est la 7e ligne, elle ne fait pas partie de la grille
		} catch (IllegalArgumentException e)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}
	
	public boolean testCoordonneeInRange() {
		try {
			Coordonnee c = new Coordonnee(1, 1);
		} catch (IllegalArgumentException e)){
			return false; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return true;
	}
	
	public boolean testCoordonneeNotInRange() {
		try {
			Coordonnee c = new Coordonnee(6, 7);
		} catch (IllegalArgumentException e)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}
	
	public boolean testCoordonneeStringIncorrect() {
		try {
			Coordonnee c = new Coordonnee("H7");
		} catch (IllegalArgumentException)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}
	
	public boolean testCoordonneeStringCorrect() {
		try {
			Coordonnee c = new Coordonnee("A1");
		} catch (IllegalArgumentException)){
			return false; 
		}
		return true;
	}
	
	public int testGetLigne() {
		Coordonnee c = new Coordonnee("A1");
		int ligne = c.getLigne();
		return 0;
	}
	
	public int testGetcolonne() {
		Coordonnee c = new Coordonnee("A1");
		int colonne = c.getColonne();
		return 0;
	}
	
	public boolean testCompareToEquals() {
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee d = new Coordonnee(1,1);
		compare = c.compareTo(d);
		return compare == 0;
	}
	
	public boolean testCompareToLigne() {
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee d = new Coordonnee(0,1);
		compare = c.compareTo(d);
		return compare == 1;
	}
	
	public boolean testCompareToColonne() {
		Coordonnee c = new Coordonnee(1,1);
		Coordonnee d = new Coordonnee(2,0);
		compare = c.compareTo(d);
		return compare == -1;
	}
	
	public boolean testEquals() {
		Coordonnee c = new Coordonnee(0,0);
		Coordonnee d = new Coordonnee(0,0);
		return c.equals(d);
	}
	
	public boolean testVoisineHautDroit() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("D2");
		return c.voisine(d);
	}
	
	public boolean testVoisineHautGauche() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("B2");
		return c.voisine(d);
	}
	
	public boolean testVoisineGauche() {
		Coordonnee c = new Coordonnee("C3");
		Coordonnee d = new Coordonnee("B3");
		return c.voisine(d);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
