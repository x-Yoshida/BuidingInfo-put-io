package pl.put.poznan.informer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.informer.logic.*;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/building")
public class BuildingInfoController {

    BazaDanych db = new BazaDanych();
    private static final Logger logger = LoggerFactory.getLogger(BuildingInfoController.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addBuilding(@RequestBody String buildingJson) {
        logger.debug("Received request to add building");

        try {
            Budynek building = objectMapper.readValue(buildingJson, Budynek.class);
            db.add(building);

            return ResponseEntity.ok("Building added successfully");
        } catch (IOException e) {
            logger.error("Error while processing JSON", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid JSON structure");
        }
    }
    @GetMapping(value = "/get_powierzchnia/{buildingId}", produces = "application/json")
    public ResponseEntity<String> getBuildingArea(@PathVariable int buildingId) {
        logger.debug("Get_powierzchnia, id: {}", buildingId);

        Lokacja lokacja = db.getObjectById(buildingId);
        if (lokacja != null) {
            JSONObject responseJson = new JSONObject();
            responseJson.put("powierzchnia", lokacja.getPowierzchnia());

            logger.debug(responseJson.toString());
            return ResponseEntity.ok(responseJson.toString());
        }

        logger.debug("Nie znaleziono podanego id");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono podanego id");
    }
    @GetMapping("/get_powierzchnia/{buildingId}/{floorId}")
    public ResponseEntity<String> getFloorArea(@PathVariable int buildingId, @PathVariable int floorId) {
        Budynek budynek = (Budynek) db.getObjectById(buildingId);

        if (budynek != null) {
            Poziom poziom = budynek.getPoziomById(floorId);

            if (poziom != null) {
                JSONObject responseJson = new JSONObject();
                responseJson.put("powierzchnia", poziom.getPowierzchnia());
                return ResponseEntity.ok(responseJson.toString());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono poziomu o id: " + floorId);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono budynku o id: " + buildingId);
        }
    }

    @GetMapping("/get_powierzchnia/{buildingId}/{floorId}/{roomId}")
    public ResponseEntity<String> getRoomArea(
            @PathVariable int buildingId,
            @PathVariable int floorId,
            @PathVariable int roomId) {
        Budynek budynek = (Budynek) db.getObjectById(buildingId);

        if (budynek != null) {
            Poziom poziom = budynek.getPoziomById(floorId);

            if (poziom != null) {
                Pomieszczenie pomieszczenie = poziom.getPomieszczenieById(roomId);

                if (pomieszczenie != null) {
                    JSONObject responseJson = new JSONObject();
                    responseJson.put("powierzchnia", pomieszczenie.getPowierzchnia());
                    return ResponseEntity.ok(responseJson.toString());
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono pomieszczenia o id: " + roomId);
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono poziomu o id: " + floorId);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono budynku o id: " + buildingId);
        }
    }



    @GetMapping(value = "/get_kubatura/{buildingId}", produces = "application/json")
    public ResponseEntity<String> getBuildingCube(@PathVariable int buildingId) {
        logger.debug("Get_kubatura, id: {}", buildingId);

        Lokacja lokacja = db.getObjectById(buildingId);
        if (lokacja != null) {
            JSONObject responseJson = new JSONObject();
            responseJson.put("kubatura", lokacja.getKubatura());

            logger.debug(responseJson.toString());
            return ResponseEntity.ok(responseJson.toString());
        }

        logger.debug("Nie znaleziono podanego id");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono podanego id");
    }

    @GetMapping("/get_kubatura/{buildingId}/{floorId}")
    public ResponseEntity<String> getFloorCube(@PathVariable int buildingId, @PathVariable int floorId) {
        Budynek budynek = (Budynek) db.getObjectById(buildingId);

        if (budynek != null) {
            Poziom poziom = budynek.getPoziomById(floorId);

            if (poziom != null) {
                JSONObject responseJson = new JSONObject();
                responseJson.put("kubatura", poziom.getKubatura());
                return ResponseEntity.ok(responseJson.toString());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono poziomu o id: " + floorId);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono budynku o id: " + buildingId);
        }
    }


    @GetMapping("/get_kubatura/{buildingId}/{floorId}/{roomId}")
    public ResponseEntity<String> getRoomCube(
            @PathVariable int buildingId,
            @PathVariable int floorId,
            @PathVariable int roomId) {
        Budynek budynek = (Budynek) db.getObjectById(buildingId);

        if (budynek != null) {
            Poziom poziom = budynek.getPoziomById(floorId);

            if (poziom != null) {
                Pomieszczenie pomieszczenie = poziom.getPomieszczenieById(roomId);

                if (pomieszczenie != null) {
                    JSONObject responseJson = new JSONObject();
                    responseJson.put("kubatura", pomieszczenie.getKubatura());
                    return ResponseEntity.ok(responseJson.toString());
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono pomieszczenia o id: " + roomId);
                }
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono poziomu o id: " + floorId);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nie znaleziono budynku o id: " + buildingId);
        }
    }


}


