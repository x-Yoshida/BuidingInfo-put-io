package pl.put.poznan.informer.logic;

/**
 * Implenentacja klasy Pomieszczenie
 */
public class Pomieszczenie extends Lokacja{
    private double powierzchnia;
    private double kubatura;
    /**
     * Konstruktor klasy Pomieszczenie wywołujący konstruktor klasy nadrzędnej
     */
    public Pomieszczenie(int id, String nazwa){
        super(id,nazwa);
    }
    /**
     * Konstruktor klasy Pomieszczenie wywołujący konstruktor klasy nadrzędnej
     */
    public Pomieszczenie(int id){
        super(id);
    }

    /**
     * Funkcja ustawiająca pole powierzchni danego pomieszczenia
     * @param powierzchnia - Powierzchnia danego pomieszczenia
     */
    public void setPowierzchnia(double powierzchnia){
        this.powierzchnia = powierzchnia;
    }
    /**
     * Funkcja zwracająca Pole powierzchni danego pomieszczenia
     * @return  Pole powierzchni danego pomieszczenia
     */
    public double getPowierzchnia(){
        return powierzchnia;
    }
    /**
     * Funkcja ustawiająca kubaturę danego pomieszczenia
     * @param kubatura - Kubatura danego pomieszczenia
     */
    public void setKubatura(double kubatura){
        this.kubatura = kubatura;
    }
    /**
     * Funkcja zwracająca kubaturę danego pomieszczenia
     * @return  Kubatura danego pomieszczenia
     */
    public double getKubatura(){
        return kubatura;
    }
}
