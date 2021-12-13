package puissance4;

public class Grille {

	private Jeton[][] jetons = new Jeton[6][7]; //jetons mis dans chaque colonnes
	private Coordonnee dernierJeton;

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int ligne = 0 ; ligne < 6 ; ligne++) {
			sb.append("[");
			for(int col = 0 ; col < 7 ; col++) {
				if(jetons[ligne][col] != null) {
					if(jetons[ligne][col].getCouleur())
						sb.append("X");
					else
						sb.append("O");
				}
				sb.append("	");
			}
			sb.append("]\n");
		}
		return sb.toString();
	}
	
	public Coordonnee getDernierJeton() {
		if (this.dernierJeton == null)
			throw new IllegalArgumentException("Aucun jeton n'a été ajouté");
		return this.dernierJeton;
	}
	
	public int getLigne(int colonne) {
		if (colonne < 0 || colonne > 6)
			throw new IllegalArgumentException("La colonne " + colonne +" est en dehors de la grille.");
		int ligne = 5;
		while (jetons[ligne][colonne] != null) {
			ligne--;
		}
		return ligne;
	}
	
	public void ajouteJeton(Jeton jeton, int colonne) {
		if (colonne < 0 || colonne > 6)
			throw new IllegalArgumentException("La colonne " + colonne +" est en dehors de la grille.");
		int ligne = this.getLigne(colonne);
		if(ligne>=0) {
			jetons[ligne][colonne] = jeton;
			dernierJeton = new Coordonnee(ligne, colonne);
		}
	}
	
	public boolean enHorizontale(Coordonnee c, boolean couleurJ) {
		int aligner = 1;
		int col = c.getColonne();
		int lig = c.getLigne();

		for (int i = 1; i+col < 6; i++) {
			if (jetons[lig][col+i] != null && jetons[lig][col+i].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig][col+i] != null && jetons[lig][col+i].getCouleur() != couleurJ)
				i = 10;
		}
		
		for (int j = 1; col-j >= 0; j++) {
			if (jetons[lig][col-j] != null && jetons[lig][col-j].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig][col-j] != null && jetons[lig][col-j].getCouleur() != couleurJ)
				j = 10;
		}
		
		if(aligner >= 4)
			return true;
		return false;
	}
	
	public boolean enVerticale(Coordonnee c, boolean couleurJ) {
		int aligner = 1;
		int col = c.getColonne();
		int lig = c.getLigne();
		
		for (int i = 1; lig-i >=0; i++) {
			if (jetons[lig-i][col] != null && jetons[lig-i][col].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig-i][col] != null && jetons[lig-i][col].getCouleur() != couleurJ)
				i = 10;
		}
		
		for (int j = 1; j+lig < 6; j++) {
			if (jetons[lig+j][col] != null && jetons[lig+j][col].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig+j][col] != null && jetons[lig+j][col].getCouleur() != couleurJ)
				j = 10;
		}
		
		if(aligner >= 4)
			return true;
		return false;
	}
	
	public boolean enDiagonaleDecroissant(Coordonnee c,boolean couleurJ) {
		int aligner = 1;
		int col = c.getColonne();
		int lig = c.getLigne();

		for (int i = 1; lig-i >=0 && col-i >=0; i++) {
			if (jetons[lig-i][col-i] != null && jetons[lig-i][col-i].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig-i][col-i] != null && jetons[lig-i][col-i].getCouleur() != couleurJ)
				i = 10;
		}

		for (int j = 1; j+lig < 6 && col+j < 7; j++) {
			if (jetons[lig+j][col+j] != null && jetons[lig+j][col+j].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig+j][col+j] != null && jetons[lig+j][col+j].getCouleur() != couleurJ)
				j = 10;
		}

		if(aligner >= 4)
			return true;
		return false;
	}
	
	public boolean enDiagonaleCroissant(Coordonnee c,boolean couleurJ) {
		int aligner = 1;
		int col = c.getColonne();
		int lig = c.getLigne();
		
		for (int i = 1; lig-i >=0 && col+i < 7; i++) {
			if (jetons[lig-i][col+i] != null && jetons[lig-i][col+i].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig-i][col+i] != null && jetons[lig-i][col+i].getCouleur() != couleurJ)
				i = 10;
		}

		for (int j = 1; j+lig < 6 && col-j >= 0; j++) {
			if (jetons[lig+j][col-j] != null && jetons[lig+j][col-j].getCouleur() == couleurJ)
				aligner++;
			else if (jetons[lig+j][col-j] != null && jetons[lig+j][col-j].getCouleur() != couleurJ)
				j = 10;
		}

		if(aligner >= 4)
			return true;
		return false;
	}
	
	public boolean enDiagonale(Coordonnee c,boolean couleurJ) {
		return this.enDiagonaleCroissant(c, couleurJ) || this.enDiagonaleDecroissant(c, couleurJ);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}