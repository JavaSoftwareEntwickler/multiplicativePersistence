import java.util.ArrayList;
import java.util.List;

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
