package pl.put.poznan.informer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Glowna klasa projektu, odpowiedzialna za uruchamianie programu
 * @version 0.1
 * @author Gamma
*/

@SpringBootApplication(scanBasePackages = {"pl.put.poznan.informer.rest"})
public class BuildingInfoApplication {
    /**
     * @hidden
     */
    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }
}
