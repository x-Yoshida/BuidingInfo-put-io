package pl.put.poznan.informer.logic;
import java.util.ArrayList;
import java.util.List;

/**
 * Implenentacja BazyDanych
 * @version 0.1
 * @author Gamma
 */
public class BazaDanych {
    private List<Lokacja> obiekty = new ArrayList<>();

    public void add(Lokacja lokacja) {
        this.obiekty.add(lokacja);
    }

    /**
     * @param id - id szukanej lokalizacji
     * @return jeśli istnieje, zwraca lokalizacje o szukanym id
     */
    public Lokacja getObjectById(int id) {
        for (Lokacja lokacja : obiekty) {
            if (lokacja.getId() == id) {
                return lokacja;
            }
        }
        return null;
    }

}
