package pl.put.poznan.informer.logic;

public abstract class Lokacja {
    private int id;
    private String nazwa;

    public Lokacja(int id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
    }

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
