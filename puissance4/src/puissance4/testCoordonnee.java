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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
