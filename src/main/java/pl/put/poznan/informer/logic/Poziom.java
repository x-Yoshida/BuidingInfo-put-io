package pl.put.poznan.informer.logic;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implenentacja klasy Poziom
 */
public class Poziom extends Lokacja {
    private List<Pomieszczenie> pomieszczenia = new ArrayList<Pomieszczenie>();
    /**
     * Konstruktor klasy Poziom wywołujący konstruktor klasy nadrzędnej
     */
    @JsonCreator
    public Poziom(@JsonProperty("id") int id, @JsonProperty("nazwa") String nazwa) {
        super(id, nazwa);
    }

    public Pomieszczenie getPomieszczenieById(int roomId) {
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            if (pomieszczenie.getId() == roomId) {
                return pomieszczenie;
            }
        }
        return null;
    }

    public List<Pomieszczenie> getPomieszczenia(){
        return pomieszczenia;
    }

    /**
     * @return sum - suma powierzchni we wszystkich pomieszczeniach na poziomie
     */
    public double getPowierzchnia() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum += pomieszczenie.getPowierzchnia();
        }
        return sum;
    }

    /**
     * @return sum - suma kubatur we wszystkich pomieszczeniach na poziomie
     */
    public double getKubatura() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum += pomieszczenie.getKubatura();
        }
        return sum;
    }

}
