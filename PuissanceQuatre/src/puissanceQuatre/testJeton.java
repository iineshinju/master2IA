package puissanceQuatre;

public class testJeton {
	
	public Coordonnee testGetPlace() {
		Jeton j = new Jeton(new Coordonnee(0,0));
		Coordonneee place = j.getPlace();
		return place;
	}

	public boolean testGetCouleur() {
		Jeton j = new Jeton(new Coordonnee(0,0), true);
		boolean couleur = j.getCouleur();
		return couleur == true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
