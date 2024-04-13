package Esercizio1;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise: Write the "persistence" function, which takes a positive integer
 * parameter and returns its "multiplicative persistence", which is the number
 * of times you have to multiply digits with each other until you have a single
 * character.
 * 
 * examples: persistence(39) == 3 because 
 * 1) 3*9 = 27, 
 * 2) 2*7 = 14,
 * 3) 1*4 = 4 
 * 4) 4 is a single digit
 * 
 * persistence(999) == 4 because :
 * 1) 9*9*9 = 729, 
 * 2) 7*2*9 = 126,
 * 3) 1*2*6 = 12,
 * 4) 1*2 = 2 
 * 2 is a single digit
 * persistence(4) == 0 because 4 is already a single digit
 */

public class Persistenza {

	public static void main(String[] args) {

		System.out.println(persistenza(679));
	}

	public static Integer persistenza(Integer num) {

		return (num < 0 || num > 0 && num < 10) ? 0 : calcolaPersistenza(num);

	}

	public static Integer calcolaPersistenza(Integer num) {

		int persistenza = 0;
		int lung = num.toString().length();
		List<Integer> numeri = new ArrayList<>(lung);
		Integer prodotto = 1;

		for (int i = 0; i < lung; i++) {
			numeri.add(intAt(num, i));
			prodotto *= numeri.get(i);
		}
		persistenza++;
		while (prodotto > 9) {

			numeri.clear();
			for (int i = 0; i < prodotto.toString().length(); i++) {
				numeri.add(intAt(prodotto, i));
			}

			prodotto = 1;
			for (int i = 0; i < numeri.size(); i++) {
				prodotto *= numeri.get(i);
			}
			persistenza++;
		}
		return persistenza;
	}

	/**
	 * prerequisito paramenti: numeri interi e positivi e indice inferiore
         * alla lunghezza del numero passato in input.
	 * 
	 * @param numero intero
	 * @param indice
	 * @return il numero presente all'indice 
	 */
	static int intAt(Integer numero, int indice) {
		return numero.toString().charAt(indice) - 48;
	}
}
