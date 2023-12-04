package pl.put.poznan.informer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.informer.logic.*;
import org.json.JSONObject;


@RestController

public class BuildingInfoController {

    BazaDanych db = new BazaDanych();
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);

    public  BuildingInfoController(){
        Budynek bud1 = new Budynek(1, "Blok");
        Poziom poz10 = new Poziom(10, "Parter");
        db.add(bud1);
        db.add(poz10);
        bud1.addPoziom(poz10);

        for (int i = 1; i < 6; i++){
            Pomieszczenie p = new Pomieszczenie(100+i);
            p.setPowierzchnia(20);
            db.add(p);
            poz10.addPomieszczenia(p);
        }

        Poziom poz11 = new Poziom(11, "1 Piętro");
        db.add(poz11);
        bud1.addPoziom(poz11);

        for (int i = 1; i < 4; i++){
            Pomieszczenie p = new Pomieszczenie(110+i);
            p.setPowierzchnia(i*10+20);
            db.add(p);
            poz11.addPomieszczenia(p);
        }

        Budynek bud2 = new Budynek(2, "Dom");
        Poziom poz20 = new Poziom(20, "Parter");
        db.add(bud2);
        db.add(poz20);
        bud2.addPoziom(poz20);

        for (int i = 1; i < 6; i++){
            Pomieszczenie p = new Pomieszczenie(200+i);
            p.setPowierzchnia(40);
            db.add(p);
            poz20.addPomieszczenia(p);
        }
    }
    @GetMapping(value = "/get_powierzchnia/{id}", produces = "application/json")
    public ResponseEntity<String> getAreaById(@PathVariable int id) {
        logger.debug("Get_powierzchnia, id: {}", id);

        Lokacja lokacja = db.getObjectById(id);
        if (lokacja != null) {
            JSONObject responseJson = new JSONObject();
            responseJson.put("area", lokacja.getPowierzchnia());

            logger.debug(responseJson.toString());
            return ResponseEntity.ok(responseJson.toString());
        }

        logger.debug("Id_not_found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id_not_found");
    }


}


