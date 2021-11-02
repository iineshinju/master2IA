package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import puissanceQuatre.Coordonnee;

public class TestCoordonnee {
	
		@Test
		public boolean testLigneOrColonneNull() {
			try {
				Coordonnee c = new Coordonnee();
			} catch (NullPointerException n){
				return true; //Si on a bien attrapé l'exception alors c'est vrai
			}
			return false; //Si on n'a pas attrapé l'exception c'est que les null sont accepté
		}
		
		@Test
		public boolean testCoordonneeNotInRangeColonne() {
			try {
				Coordonnee c = new Coordonnee(7, 1); // 7 est la 8e lettre de l'alphabet soit H, il ne fait pas partie de la grille
			} catch (IllegalArgumentException l){
				return true; //Si on a bien attrapé l'exception alors c'est vrai
			}
			return false;
		}
		
		@Test
		public boolean testCoordonneeNotInRangeLigne() {
			try {
				Coordonnee c = new Coordonnee(1, 6); // 6 est la 7e ligne, elle ne fait pas partie de la grille
			} catch (IllegalArgumentException l){
				return true; //Si on a bien attrapé l'exception alors c'est vrai
			}
			return false;
		}
		
		@Test
		public boolean testCoordonneeInRange() {
			try {
				Coordonnee c = new Coordonnee(1, 1);
			} catch (IllegalArgumentException l){
				return false; //Si on a bien attrapé l'exception alors c'est vrai
			}
			return true;
		}
		
		@Test
		public boolean testCoordonneeNotInRange() {
			try {
				Coordonnee c = new Coordonnee(7, 6);
			} catch (IllegalArgumentException l){
				return true; //Si on a bien attrapé l'exception alors c'est vrai
			}
			return false;
		}
		
		@Test
		public boolean testCoordonneeStringIncorrect() {
			try {
				Coordonnee c = new Coordonnee("H7");
			} catch (IllegalArgumentException l){
				return true; //Si on a bien attrapé l'exception alors c'est vrai
			}
			return false;
		}
		
		@Test
		public boolean testCoordonneeStringCorrect() {
			try {
				Coordonnee c = new Coordonnee("A1");
			} catch (IllegalArgumentException l){
				return false; 
			}
			return true;
		}
}


