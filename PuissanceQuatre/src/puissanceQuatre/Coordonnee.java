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
		int int_lettre = colonne + 65;
		char lettre = (char) int_lettre;
		return "" + lettre + (ligne + 1);
	}
	
	public int getLigne() {
		return this.ligne;
	}
	
	public int getColonne() {
		return this.colonne;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Coordonnee) {
			Coordonnee c = (Coordonnee) obj;
			if(this.compareTo(c)==0)
				return true; 
			return false;
		}
		return false;
	}
	
	public boolean voisine(Coordonnee c) {
		if((ligne==c.getLigne() && colonne==c.getColonne()+1)||(ligne==c.getLigne() && colonne==c.getColonne()-1))
			return true;
		else if((colonne==c.getColonne() && ligne==c.getLigne()+1)||(colonne==c.getColonne() && ligne==c.getLigne()-1))
			return true;
		else if((colonne==c.getColonne()+1 && ligne==c.getLigne()+1)||(colonne==c.getColonne()-1 && ligne==c.getLigne()-1))
			return true;
		else if((colonne==c.getColonne()+1 && ligne==c.getLigne()-1)||(colonne==c.getColonne()-1 && ligne==c.getLigne()+1))
			return true;
		return false;
	}
	public int compareTo(Coordonnee o) {
		if(ligne==o.getLigne() && colonne==o.getColonne())
			return 0;
		else if (ligne<o.getLigne() || (ligne==o.getLigne() && colonne < o.getColonne()))
			return -1;
		return 1;
	}

	public static void main(String[] args) {
		//Coordonnee c = new Coordonnee(6,6);
		//Coordonnee c = new Coordonnee();
		//Coordonnee c = new Coordonnee(""J2);
		Coordonnee c1 = new Coordonnee(3,4);
		System.out.println(c1.getLigne());
		System.out.println(c1.getColonne());
		System.out.println(c1.toString());
		Coordonnee c2 = new Coordonnee(2,6);
		System.out.println(c1.compareTo(c2));
		System.out.println(c1.voisine(c2));
	}

}
