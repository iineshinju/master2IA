package puissance4;

public class testJeton {
	
	public static Coordonnee testGetPlace() {
		Jeton j = new Jeton(new Coordonnee(0,0));
		Coordonnee place = j.getPlace();
		return place;
	}
	
	public static boolean testGetCouleur() {
		Jeton j = new Jeton(new Coordonnee(0,0), true);
		boolean couleur = j.getCouleur();
		return couleur == true;
	}
	
	public static boolean testToStringRouge() {
		Jeton j = new Jeton(new Coordonnee(0,0), true);
		return "Les coordonnées sont : A1. La couleur du jeton est rouge." == j.toString(); 
	}
	
	public static boolean testToStringJaune() {
		Jeton j = new Jeton(new Coordonnee(0,0));
		return "Les coordonnées sont : A1. La couleur du jeton est jaune." == j.toString(); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testGetPlace());
		System.out.println(testGetCouleur());
		System.out.println(testToStringRouge());
		System.out.println(testToStringJaune());
	}

}
