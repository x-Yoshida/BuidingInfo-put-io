package pl.put.poznan.informer.logic;

public class Pomieszczenie extends Lokacja{
    private double powierzchnia;
    private double kubatura;

    public Pomieszczenie(int id, String nazwa){
        super(id,nazwa);
    }
    public Pomieszczenie(int id){
        super(id);
    }

    public void setPowierzchnia(double powierzchnia){
        this.powierzchnia = powierzchnia;
    }

    public double getPowierzchnia(){
        return powierzchnia;
    }

    public void setKubatura(double kubatura){
        this.kubatura = kubatura;
    }

    public double getKubatura(){
        return kubatura;
    }
}
