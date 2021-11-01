package puissanceQuatre;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne; // La ligne est déterminée automatiquement
	private int colonne;


	public Coordonnee(int ligne, int colonne) {
		
	}
	
	public Coordonnee(String s) {
		
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
	
	}

}
