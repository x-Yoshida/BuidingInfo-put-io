package pl.put.poznan.informer.logic;

/**
 * Implementacja klasy BuildingInfo
 */
public class BuildingInfo {

    private final String[] info;

    public BuildingInfo(String[] info){
        this.info = info;
    }

    public String showInfo(String text){
        // of course, normally it would do something based on the transforms
        return text.toUpperCase();
    }
}
