package pl.put.poznan.informer.logic;
import java.util.ArrayList;
import java.util.List;

public class BazaDanych {
    private List<Lokacja> obiekty = new ArrayList<>();

    public void add(Lokacja lokacja) {
        this.obiekty.add(lokacja);
    }

    public Lokacja getObjectById(int id) {
        for (Lokacja lokacja : obiekty) {
            if (lokacja.getId() == id) {
                return lokacja;
            }
        }
        return null;
    }

}
