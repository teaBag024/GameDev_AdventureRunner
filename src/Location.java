/**
* represents basic parts of a location
* in an adventure game
*
* coded defensively
* anything that is not exposed is not
* fields = final
* creates location that cannot be changed
* */
import java.util.HashMap;
import java.util.Map;

public class Location {
    private final String locID;
    private final String locDescription;

    //will be possible directions we can exit game from
    //key = String
    //value = Int
    //SString = cardinal direction
    private final Map<String , Integer> exit;

    public Location(String locID, String locDescription){
        this.locDescription = locDescription;
        this.locID = locID;
        this.exit = new HashMap<>();
    }
    public void addExit(String direction, int location){
        exit.put(direction, location);
    }
    public String getLocID(){
        return locID;
    }
    public String getLocDescription(){
        return locDescription;
    }

    /**
     * create new from exits map
     * return copy of exits
     *
     * nothing outside class can change exits
     * if wants to modify
     * exits map is not impacted
     * step to make immutable class.
     * */
    public Map<String , Integer> getExits(){
        return new HashMap<String , Integer>(exit);
    }
}
