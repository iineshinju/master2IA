package puissanceQuatre;

public class testCoordonnee {
	
	public boolean testLigneOrColonneNull() {
		try {
			Coordonnee c = new Coordonnee(null, null);
		} catch (NullPointerException)){
			return true; //Si on a bien attrap� l'exception alors c'est vrai
		}
		return false; //Si on n'a pas attrap� l'exception c'est que les null sont accept�
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
