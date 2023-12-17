package pl.put.poznan.informer.logic;

/**
 * Implementacja abstrakcyjnej klasy Lokacja
 */
public abstract class Lokacja {
    private int id;
    private String nazwa;


    /**
     * Konstruktor klasy Lokacja
     */
    public Lokacja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }
    /**
     * Konstruktor klasy Lokacja
     */
    public Lokacja(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa (String nazwa) {
        this.nazwa = nazwa;
    }

    public abstract double getPowierzchnia();
    public abstract double getKubatura();
}
