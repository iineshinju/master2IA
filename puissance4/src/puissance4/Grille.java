package puissance4;

public class Grille {

	private Jeton[][] jetons = new Jeton[6][7]; //jetons mis dans chaque colonnes

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
	
	public void ajouteJeton(Jeton jeton, int colonne) {
		if (colonne < 0 || colonne > 6)
			throw new IllegalArgumentException("La colonne " + colonne +" est en dehors de la grille.");
		int ligne = 5;
		while (jetons[ligne][colonne] != null) {
			ligne--;
		}
		if(ligne>0) {
			jetons[ligne][colonne] = jeton;
			Coordonnee c = new Coordonnee(ligne, colonne);
			boolean couleur = jeton.getCouleur();
			if (enHorizontale(c, couleur))
				System.out.println("Gagné en horizontale par les " + couleur);
			/*if (enVerticale(c, couleur))
				System.out.println("Gagné en verticale par les " + couleur);
			if (enDiagonaleCroissant(c, couleur))
				System.out.println("Gagné en diagonale par les " + couleur);
		*/}
	}
	
	public boolean enHorizontale(Coordonnee c, boolean couleurJ) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int lig = c.getLigne();
		//verification a droite la ligne reste la meme et la colonne augmente
		for (int i = 1; i+col < 6; i++) {
			if (jetons[lig][col+i] != null && jetons[lig][col+i].getCouleur() == couleurJ)
				n++;
			else if (jetons[lig][col+i] != null && jetons[lig][col+i].getCouleur() != couleurJ)
				i = 10;
		}
		
		//verification a gauche la ligne reste la meme et la colonne diminue
		for (int j = 1; col-j >= 0; j++) {
			if (jetons[lig][col-j] != null && jetons[lig][col-j].getCouleur() == couleurJ)
				n++;
			else if (jetons[lig][col-j] != null && jetons[lig][col-j].getCouleur() != couleurJ)
				j = 10;
		}
		//si n >= 4 alors on gagne a l'horizontale
		if(n >= 4)
			return true;
		return false;
	}
	
	public boolean enVerticale(Coordonnee c, boolean couleurJ) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int lig = c.getLigne();
		//verification en haut la colonne reste la meme et la ligne diminue
		for (int i = 1; lig-i >=0; i++) {
			if (jetons[lig-i][col] != null && jetons[lig-i][col].getCouleur() == couleurJ)
				n++;
			else if (jetons[lig-i][col] != null && jetons[lig-i][col].getCouleur() != couleurJ)
				i = 10;
		}
		
		//verification a bas la colonne reste la meme et la ligne augmente
		for (int j = 1; j+lig < 6; j++) {
			if (jetons[lig+j][col] != null && jetons[lig+j][col].getCouleur() == couleurJ)
				n++;
			else if (jetons[lig+j][col] != null && jetons[lig+j][col].getCouleur() != couleurJ)
				j = 10;
		}
		if(n >= 4)
			return true;
		return false;
	}
	
	public boolean enDiagonaleDecroissant(Coordonnee c,boolean couleurJ) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int lig = c.getLigne();
		//verification diagonale d'en haut a droite a en bas a gauche
		//verification en haut a droite la colonne augmente et la ligne diminue
		for (int i = 1; lig-i >=0 && col-i >=0; i++) {
			System.out.println(c + " " + jetons[lig-i][col-i] + " " + (new Coordonnee(lig-i, col-i)).toString());
			if (jetons[lig-i][col-i] != null && jetons[lig-i][col-i].getCouleur() == couleurJ)
				n++;
		}
		//verification en bas a gauche la colonne diminue et la ligne augmente
		for (int j = 1; j+lig < 6 && col+j < 7; j++) {
			System.out.println(c + " " + jetons[lig+j][col+j] + " " + (new Coordonnee(lig+j, col+j)).toString());
			if (jetons[lig+j][col+j] != null && jetons[lig+j][col+j].getCouleur() == couleurJ)
				n++;
		}
		System.out.println(n);
		//si n >= 4 alors on gagne
		if(n >= 4)
			return true;
		return false;
	}
	
	public boolean enDiagonaleCroissant(Coordonnee c,boolean couleurJ) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int lig = c.getLigne();
		//verification diagonale d'en haut a droite a en bas a gauche
		//verification en haut a droite la colonne augmente et la ligne diminue
		for (int i = 1; lig-i >=0 && col+i < 7; i++) {
			System.out.println(c + " " + jetons[lig-i][col+i] + " " + (new Coordonnee(lig-i, col+i)).toString());
			if (jetons[lig-i][col+i] != null && jetons[lig-i][col+i].getCouleur() == couleurJ)
				n++;
		}
		//verification en bas a gauche la colonne diminue et la ligne augmente
		for (int j = 1; j+lig < 6 && col-j >= 0; j++) {
			System.out.println(c + " " + jetons[lig+j][col+j] + " " + (new Coordonnee(lig+j, col+j)).toString());
			if (jetons[lig+j][col] != null && jetons[lig+j][col].getCouleur() == couleurJ)
				n++;
		}
		//si n >= 4 alors on gagne
		if(n >= 4)
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}