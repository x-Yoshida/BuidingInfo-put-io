package pl.put.poznan.informer.logic;
import java.util.List;
import java.util.ArrayList;

/**
 * Implenentacja klasy Poziom
 */
public class Poziom extends Lokacja {
    private List<Pomieszczenie> pomieszczenia = new ArrayList<Pomieszczenie>();
    /**
     * Konstruktor klasy Poziom wywołujący konstruktor klasy nadrzędnej
     */
    public Poziom(int id, String nazwa){
        super(id,nazwa);
    }
    /**
     * Konstruktor klasy Poziom wywołujący konstruktor klasy nadrzędnej
     */
    public Poziom(int id){
        super(id);
    }

    /**
     * @param p - pomieszczenie które zostanie dodane do Listy pomieszczeń
     */
    public void addPomieszczenia(Pomieszczenie p){
        this.pomieszczenia.add(p);
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
