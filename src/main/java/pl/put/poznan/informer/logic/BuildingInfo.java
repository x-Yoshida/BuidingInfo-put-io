package pl.put.poznan.informer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
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
