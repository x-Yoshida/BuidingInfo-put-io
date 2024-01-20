package pl.put.poznan.informer.logic;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Implementacja klasy Pomieszczenie
 */
public class Pomieszczenie extends Lokacja{
    private double powierzchnia;
    private double kubatura;

    private double heating;
    private double light;
    /**
     * Konstruktor klasy Pomieszczenie wywołujący konstruktor klasy nadrzędnej
     */
    @JsonCreator
    public Pomieszczenie(@JsonProperty("id") int id, @JsonProperty("nazwa") String nazwa) {
        super(id, nazwa);
    }
    /**
     * Funkcja zwracająca Pole powierzchni danego pomieszczenia
     * @return  Pole powierzchni danego pomieszczenia
     */
    public double getPowierzchnia(){
        return powierzchnia;
    }
    /**
     * Funkcja zwracająca kubaturę danego pomieszczenia
     * @return  Kubatura danego pomieszczenia
     */
    public double getKubatura(){
        return kubatura;
    }

    @Override
    public double getLight() { return light/powierzchnia; }

    @Override
    public double getLightPower() { return light; }

    @Override
    public double getHeating() { return heating/kubatura; }

    @Override
    public double getHeatingPower() { return heating; }
}
