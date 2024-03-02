import java.util.HashMap;
import java.util.Map;

public class xMap {

    private Map<Integer, Location> locs = new HashMap<>();

    public xMap(){
        locs.put(0,new Location("Quit", "You were in front of a computer playing a game"));
        locs.put(1,new Location("START",""));
        locs.put(2,new Location("Village",""));
        locs.put(3,new Location("Bank",""));
        locs.put(4,new Location("Market",""));
        locs.put(5,new Location("Mt.XXX",""));
        locs.put(6,new Location("Park",""));
        locs.put(7,new Location("Gardens",""));
        locs.put(8,new Location("Pit",""));
        locs.put(9,new Location("Sunrise Castle",""));
        locs.put(10,new Location("Dungeon"," You shouldn't be here :("));
        locs.put(11,new Location("End",""));

        //location exits
        locs.get(1).addExit("N", 5);
        locs.get(1).addExit("E", 2);
        locs.get(1).addExit("S", 4);
        locs.get(1).addExit("W", 3);
        locs.get(1).addExit("P", 0);

        locs.get(2).addExit("W", 1);
        locs.get(2).addExit("P", 0);

        locs.get(3).addExit("E", 1);
        locs.get(3).addExit("S", 10);
        locs.get(3).addExit("P", 0);

        locs.get(4).addExit("N", 1);
        locs.get(4).addExit("E", 11);
        locs.get(4).addExit("W", 10);
        locs.get(4).addExit("P", 0);


        locs.get(5).addExit("E", 7);
        locs.get(5).addExit("S", 1);
        locs.get(5).addExit("W", 6);
        locs.get(5).addExit("P", 0);

        locs.get(6).addExit("E", 5);
        locs.get(6).addExit("W", 8);
        locs.get(6).addExit("P", 0);

        locs.get(7).addExit("W", 5);
        locs.get(7).addExit("P", 0);

        locs.get(8).addExit("P", 0);

        locs.get(11).addExit("W", 4);
        locs.get(11).addExit("E", 9);
        locs.get(11).addExit("P", 0);
    }

    public Location get(int i){
        return locs.get(i);
    }


}
