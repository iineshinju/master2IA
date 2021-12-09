package puissance4;

public class testJeton {
	
	public static boolean testGetCouleur() {
		Jeton j = new Jeton(true);
		boolean couleur = j.getCouleur();
		return couleur;
	}
	
	public static boolean testToStringRouge() {
		Jeton j = new Jeton(true);
		return "La couleur du jeton est rouge.".equals(j.toString()); 
	}
	
	public static boolean testToStringJaune() {
		Jeton j = new Jeton();
		return "La couleur du jeton est jaune.".equals(j.toString()); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testGetCouleur());
		System.out.println(testToStringRouge());
		System.out.println(testToStringJaune());
	}

}