package puissanceQuatre;

public class testCoordonnee {
	
	public boolean testLigneOrColonneNull() {
		try {
			Coordonnee c = new Coordonnee(null, null);
		} catch (NullPointerException)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false; //Si on n'a pas attrapé l'exception c'est que les null sont accepté
	}
	
	public boolean testCoordonneeNotInRangeColonne() {
		try {
			Coordonnee c = new Coordonnee(7, 1); // 7 est la 8e lettre de l'alphabet soit H, il ne fait pas partie de la grille
		} catch (IllegalArgumentException)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}

	public boolean testCoordonneeNotInRangeLigne() {
		try {
			Coordonnee c = new Coordonnee(1, 6); // 6 est la 7e ligne, elle ne fait pas partie de la grille
		} catch (IllegalArgumentException)){
			return true; //Si on a bien attrapé l'exception alors c'est vrai
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
