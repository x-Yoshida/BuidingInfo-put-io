package pl.put.poznan.informer.logic;
import java.util.ArrayList;
import java.util.List;

/**
 * Implenentacja klasy BazaDanych
 */
public class BazaDanych {
    private List<Lokacja> obiekty = new ArrayList<>();

    /**
     * @param lokacja - lokacja która ma zostać dodana do listy lokacji
     */
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
