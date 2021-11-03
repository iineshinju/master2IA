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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
