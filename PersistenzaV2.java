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
 * 4 is a single digit
 * 
 * persistence(999) == 4 because :
 * 1) 9*9*9 = 729, 
 * 2) 7*2*9 = 126,
 * 3) 1*2*6 = 12,
 * 4) 1*2 = 2 
 * 2 is a single digit
 *
 * persistence(4) == 0 because 4 is already a single digit
 *
 */

public class Persistenza {

    public static void main(String[] args) {
        System.out.println(persistenza(679));
    }

    public static int persistenza(int num) {
        return (num < 10) ? 0 : calcolaPersistenza(num);
    }

    public static int calcolaPersistenza(int num) {
        int persistenza = 0;
        List<Integer> numeri = convertiInLista(num);
        int prodotto = calcolaProdotto(numeri);

        while (prodotto > 9) {
            numeri = convertiInLista(prodotto);
            prodotto = calcolaProdotto(numeri);
            persistenza++;
        }
        return persistenza + 1;
    }

    static List<Integer> convertiInLista(int num) {
        List<Integer> numeri = new ArrayList<>();
        while (num > 0) {
            numeri.add(num % 10);
            num /= 10;
        }
        return numeri;
    }

    static int calcolaProdotto(List<Integer> numeri) {
        int prodotto = 1;
        for (int numero : numeri) {
            prodotto *= numero;
        }
        return prodotto;
    }
}
