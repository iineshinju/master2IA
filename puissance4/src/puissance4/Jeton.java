package puissance4;

public class Jeton {
	private Coordonnee place;
	private boolean couleur; // true = couleur rouge, false = couleur jaune
	
	public Jeton(Coordonnee place) {
		this.place = place;
		// La valeur par d�faut du boolean est false donc la couleur par d�faut est jaune
	}
	
	public Jeton(Coordonnee place, boolean couleur) {
		this.place = place;
		this.couleur = couleur;
	}
	
	public Coordonnee getPlace() {
		return this.place;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
