package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementacja klasy Budynek
 */
public class Budynek extends Lokacja{

    private List<Poziom> poziomy = new ArrayList<Poziom>();

    /**
     * Konstruktor klasy Budynek wywołujący konstruktor klasy nadrzędnej
     */
    public Budynek(int id, String nazwa) {
         super(id, nazwa);
     }
    /**
     * Konstruktor klasy Budynek wywołujący konstruktor klasy nadrzędnej
     */
     public Budynek(int id) {
        super(id);
    }

    public List<Poziom> getPoziomy(){
         return poziomy;
    }
    /**
     * Funkcja dodająca nowy obiekt klasy Poziom do Listy poziomów
     */
    public void addPoziom(Poziom poz){
         this.poziomy.add(poz);
    }

    /**
     * @return sum - suma powierzchni na wszystkich poziomach budynku
     */
    public double getPowierzchnia() {
        double sum = 0;
        for (Poziom poziom : poziomy) {
            sum += poziom.getPowierzchnia();
        }
        return sum;
    }
    /**
     * @return sum - suma kubatur na wszystkich poziomach budynku
     */
    public double getKubatura() {
        double sum = 0;
        for (Poziom poziom : poziomy) {
            sum += poziom.getKubatura();
        }
        return sum;
    }
}
