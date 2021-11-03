package puissanceQuatre;

public class Grille {

	private Jeton[][] jetons = new Jeton[5][6]; //jetons mis dans chaque colonnes

	public Grille() {}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=5 ; i>=0 ; i--) {
			sb.append("[");
			for(int j = 0; j<7;j++) {
				if(jetons[i][j] != null) {
					if(jetons[i][j].getCouleur())
						sb.append("x");
					sb.append("O");
				}
				sb.append("	");
			}
			sb.append("]");
			sb.append('\n');
			
		}
		return sb.toString();
	}
	
	public boolean ajouteJeton(Jeton jeton, int colonne) {
		if (colonne < 0 || colonne > 6)
			throw new IllegalArgumentException("les colonnes sont de 0 a 6");
		int i = 5;
		while (jetons[i][colonne] != null) {
			i--;
		}
		if(i<0)
			return false;
		jetons[i][colonne] = jeton;
		return true;
	}
	
	private boolean estDansGrille(Coordonnee c) {
		if(c.getLigne() < 0 || c.getColonne() > 6 || c.getColonne() < 0 || c.getLigne() > 5)
			return false;
		return true;
	}
	
	public boolean enHorizontale(Coordonnee c) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int l = c.getLigne();
		int i = 1;
		//verification a droite
		//la ligne reste la meme et la colonne augmente
		while((jetons[col+i][l].getCouleur() == jetons[col][l].getCouleur()) || (i<6-col)) {
			n++;
			i++;
		}
		//verification a gauche
		//la ligne reste la meme et la colonne diminue
		int j = 1;
		while((jetons[col-j][l].getCouleur() == jetons[col][l].getCouleur()) || (col-j>=0)) {
			n++;
			j++;
		}
		//si n >= 4 alors on gagne a l'horizontale
		if(n >= 4)
			return true;
		return false;
	}
	
	public boolean enVerticale(Coordonnee c) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int l = c.getLigne();
		int i = 1;
		//verification en haut
		//la colonne reste la meme et la ligne diminue
		while((jetons[col][l-i].getCouleur() == jetons[col][l].getCouleur()) || (l-i>=0)) {
			n++;
			i++;
		}
		//verification a bas
		//la colonne reste la meme et la ligne augmente
		int j = 1;
		while((jetons[col][l+j].getCouleur() == jetons[col][l].getCouleur()) || (j+l<7)) {
			n++;
			j++;
		}
		//si n >= 4 alors on gagne a la verticale
		if(n >= 4)
			return true;
		return false;
	}
	
	public boolean enDiagonale(Coordonnee c) {
		int n = 1;//n compte le nombre de jeton aligné
		int col = c.getColonne();
		int l = c.getLigne();
		int i = 1;
		//verification diagonale d'en haut a droite a en bas a gauche
		//verification en haut a droite
		//la colonne augmente et la ligne diminue
		while((jetons[col+i][l-i].getCouleur() == jetons[col][l].getCouleur()) || (l-i>=0) || (col+i<7)) {
			n++;
			i++;
		}
		//verification en bas a gauche
		//la colonne diminue et la ligne augmente
		int j = 1;
		while((jetons[col-j][l+j].getCouleur() == jetons[col][l].getCouleur()) || (j+l<7) || (col-j>=0)) {
			n++;
			j++;
		}
		//si n >= 4 alors on gagne
		if(n >= 4)
			return true;
		
		//verification diagonale d'en haut a gauche a en bas a droite
		n=1; //on reinitialise n 
		//verification en haut a gauche
		//la colonne diminue et la ligne diminue
		i = 1; //on reinitialise i
		while((jetons[col-i][l-i].getCouleur() == jetons[col][l].getCouleur()) || (l-i>=0) || (col-i>=0)) {
			n++;
			i++;
		}
		//verification en bas a droite
		//la colonne augmente et la ligne augmente
		j = 1; //on reinitialise j
		while((jetons[col+j][l+j].getCouleur() == jetons[col][l].getCouleur()) || (j+l<7) || (col+j<6)) {
			n++;
			j++;
		}
		//si n >= 4 alors on gagne
				if(n >= 4)
					return true;
				
		return false;
	}
	
	/*public boolean perdu() {}*/


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grille g = new Grille();
		System.out.println(g.toString());

	}

}
