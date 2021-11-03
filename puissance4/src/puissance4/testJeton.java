package puissance4;

public class testJeton {
	
	public static boolean testGetPlace() {
		Jeton j = new Jeton(new Coordonnee(0,0));
		Coordonnee place = j.getPlace();
		return place.toString().equals("A1");
	}
	
	public static boolean testGetCouleur() {
		Jeton j = new Jeton(new Coordonnee(0,0), true);
		boolean couleur = j.getCouleur();
		return couleur == true;
	}
	
	public static boolean testToStringRouge() {
		Jeton j = new Jeton(new Coordonnee(0,0), true);
		return "Les coordonnées sont : A1. La couleur du jeton est rouge.".equals(j.toString()); 
	}
	
	public static boolean testToStringJaune() {
		Jeton j = new Jeton(new Coordonnee(0,0));
		return "Les coordonnées sont : A1. La couleur du jeton est jaune.".equals(j.toString()); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testGetPlace());
		System.out.println(testGetCouleur());
		System.out.println(testToStringRouge());
		System.out.println(testToStringJaune());
	}

}
