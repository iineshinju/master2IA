package puissanceQuatre;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne; 
	private int colonne;


	public Coordonnee(int ligne, int colonne) {
		if(ligne < 0 || ligne > 5 || colonne < 0 || colonne > 6)
			throw new IllegalArgumentException("La coordonnée (" + colonne +"," +ligne + ") est en dehors des indices valides");
		this.ligne=ligne;
		this.colonne=colonne;
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
		Coordonnee c = new Coordonnee(6,6);
	}

}
