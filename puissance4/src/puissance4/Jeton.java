package puissance4;

public class Jeton {
	private boolean couleur; // true = couleur rouge, false = couleur jaune
	
	public Jeton() {
		this.couleur = false;
	}
	
	public Jeton(boolean couleur) {
		this.couleur = couleur;
	}

	public boolean getCouleur() {
		return this.couleur;
	}
	
	public String toString() {
		return "La couleur du jeton est " + (couleur ? "rouge." : "jaune."); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
