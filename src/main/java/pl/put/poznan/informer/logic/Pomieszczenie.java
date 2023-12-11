package pl.put.poznan.informer.logic;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Pomieszczenie extends Lokacja{
    private double powierzchnia;
    private double kubatura;

    @JsonCreator
    public Pomieszczenie(@JsonProperty("id") int id, @JsonProperty("nazwa") String nazwa) {
        super(id, nazwa);
    }

    public double getPowierzchnia(){
        return powierzchnia;
    }

    public double getKubatura(){
        return kubatura;
    }
}
