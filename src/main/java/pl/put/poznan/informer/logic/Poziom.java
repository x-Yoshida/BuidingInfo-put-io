package pl.put.poznan.informer.logic;
import java.util.List;
import java.util.ArrayList;

public class Poziom extends Lokacja {
    private List<Pomieszczenie> pomieszczenia = new ArrayList<Pomieszczenie>();
    public Poziom(int id, String nazwa){
        super(id,nazwa);
    }

    public Poziom(int id){
        super(id);
    }
    public void addPomieszczenia(Pomieszczenie p){
        this.pomieszczenia.add(p);
    }
    public List<Pomieszczenie> getPomieszczenia(){
        return pomieszczenia;
    }

    public double getPowierzchnia() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum += pomieszczenie.getPowierzchnia();
        }
        return sum;
    }

}
