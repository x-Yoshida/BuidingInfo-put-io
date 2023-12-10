package pl.put.poznan.informer.logic;

import java.util.ArrayList;
import java.util.List;

public class Budynek extends Lokacja{

    private List<Poziom> poziomy = new ArrayList<Poziom>();
    public Budynek(int id, String nazwa) {
         super(id, nazwa);
     }
    public Budynek(int id) {
        super(id);
    }

    public List<Poziom> getPoziomy(){
         return poziomy;
    }

    public void addPoziom(Poziom poz){
         this.poziomy.add(poz);
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
