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

    /**
     * Funkcja zwracajaca stosunek mocy oswietlenia na poziomie budynku w stosunku do jego powierzchni
     * @return stosunek mocy oswietlenia do powierzchni poziomy
     */
    @Override
    public double getLight() {
        double arr = 0;
        double pow = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            arr += pomieszczenie.getPowierzchnia();
            pow += pomieszczenie.getLightPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca sume mocy oswietlenia wszystkich pomimeszczen na danym poziomie
     * @return suma mocy oswietlenia pomieszczen na poziomie
     */
    @Override
    public double getLightPower() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum +=  pomieszczenie.getLightPower();
        }
        return sum;
    }

    /**
     * Funkcja zwracajaca stosunek zuzycia energii na ogrzewanie w przeliczeniu na jednostke objetosci poziomu budynku
     * @return stosunek zuzycia energii do objetosci poziomu budynku
     */
    @Override
    public double getHeating() {
        double arr = 0;
        double pow = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            arr += pomieszczenie.getKubatura();
            pow += pomieszczenie.getHeatingPower();
        }
        return pow/arr;
    }

    /**
     * Funkcja zwracajaca sume zuzycia energii na ogrzewanie danego poziomu budynku
     * @return suma zuzycia energii na ogrzewanie
     */
    @Override
    public double getHeatingPower() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum +=  pomieszczenie.getHeatingPower();
        }
        return sum;
    }

}
