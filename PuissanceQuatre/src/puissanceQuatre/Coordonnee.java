package puissanceQuatre;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne; 
	private int colonne;

	public Coordonnee() {
		throw new IllegalArgumentException("La coordonnée ne peut pas être null");
	}
	public Coordonnee(int ligne, int colonne) {
		if(ligne < 0 || ligne > 5 || colonne < 0 || colonne > 6)
			throw new IllegalArgumentException("La coordonnée (" + colonne +"," +ligne + ") est en dehors des indices valides");
		this.ligne=ligne;
		this.colonne=colonne;
	}
	
	public Coordonnee(String s) {
		if (s.length() < 2) {
			throw new IllegalArgumentException("La coordonnée n'est pas complète");
		}
		if (s.length() < 3) {
			String lettre = s.substring(0, 1);
			lettre = lettre.toUpperCase();
			this.colonne = lettre.charAt(0) - 65;
			this.ligne = Integer.parseInt(s.substring(1)) - 1;
			if (this.colonne < 0 || this.colonne > 6 || this.ligne < 0 || this.ligne > 5)
				throw new IllegalArgumentException("La coordonnée n'est pas valide");
		}
		else {
			throw new IllegalArgumentException("La coordonnée " + this.colonne + this.ligne + " n'est pas valide");
		}
	}

	public String toString() {
		return "";
	}
	
	public int getLigne() {
		return 0;
	}
	
	public int getColonne() {
		return 0;
	}
	
	public boolean equals(Object obj) {
		return false;
	}
	
	public boolean voisine(Coordonnee c) {
		return false;
	}
	public int compareTo(Coordonnee o) {
		return 0;
	}

	public static void main(String[] args) {
		//Coordonnee c = new Coordonnee(6,6);
		Coordonnee c = new Coordonnee();
	}

}
