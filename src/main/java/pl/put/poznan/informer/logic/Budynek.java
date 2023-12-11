package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Budynek extends Lokacja{

    private List<Poziom> poziomy = new ArrayList<Poziom>();
    @JsonCreator
    public Budynek(@JsonProperty("id") int id, @JsonProperty("nazwa") String nazwa) {
        super(id, nazwa);
    }

    public List<Poziom> getPoziomy(){
         return poziomy;
    }


    public Poziom getPoziomById(int id) {
        for (Poziom poziom : poziomy) {
            if (poziom.getId() == id) {
                return poziom;
            }
        }
        return null;
    }

    public double getPowierzchnia() {
        double sum = 0;
        for (Poziom poziom : poziomy) {
            sum += poziom.getPowierzchnia();
        }
        return sum;
    }

    public double getKubatura() {
        double sum = 0;
        for (Poziom poziom : poziomy) {
            sum += poziom.getKubatura();
        }
        return sum;
    }
}
