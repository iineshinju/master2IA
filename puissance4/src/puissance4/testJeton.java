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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(testGetPlace());
		System.out.println(testGetCouleur());
	}

}
