package puissanceQuatre;

public class Jeton {

	public Jeton() {
		// TODO Auto-generated constructor stub
		private Coordonnee place;
		private boolean couleur; // true = couleur rouge, false = couleur jaune
		
		public Jeton(Coordonnee place) {
			this.place = place;
			// La valeur par défaut du boolean est false donc la couleur par défaut est jaune
		}
		
		public Jeton(Coordonnee place, boolean couleur) {
			this.place = place;
			this.couleur = couleur;
		}
		
		public Coordonnee getPlace() {
			return this.place;
		}
		
		public boolean getCouleur() {
			return this.couleur;
		}
		
		public String toString() {
			return "Les coordonnées sont : " + this.place + ". La couleur du jeton est " + 
		if couleur ? "rouge." : "jaune."; 
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
