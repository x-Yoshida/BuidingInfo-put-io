package pl.put.poznan.informer.logic;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Poziom extends Lokacja {
    private List<Pomieszczenie> pomieszczenia = new ArrayList<Pomieszczenie>();
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

    public double getPowierzchnia() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum += pomieszczenie.getPowierzchnia();
        }
        return sum;
    }

    public double getKubatura() {
        double sum = 0;
        for (Pomieszczenie pomieszczenie : pomieszczenia) {
            sum += pomieszczenie.getKubatura();
        }
        return sum;
    }

}
