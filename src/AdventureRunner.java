import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureRunner {
    //HashMap of loc Obj = maps to int key
    private static xMap map;
    private static User user = new User();
    private static Scanner userIn = new Scanner(System.in);

    private static final String[] directions = {"n", "s", "e", "w",
            "north", "south", "east", "west"};
    private static final String[] endAttemptsDialogue = {
            "This is a very normal wall.",
            "This is a very very normal wall.",
            "Stop, you are going to get a concussion",
            "The world around you dims.",
            "A good samaritan found you passed out on the floor, and brought you to the castle for treatment."};
    private static Map<String , Integer> exits;


    public static void main(String[] args) {
        boolean run = true;
        while(run){
            map = new xMap();
            run = game();
        }
    }
    private static boolean game(){
        boolean run = true;
        while(run){
            exits = map.get(user.loc).getExits();
            System.out.println("Time: " + time());
            System.out.println(map.get(user.loc).getLocDescription());
            System.out.println(stringExit());
            System.out.println("0: Move");
            System.out.println("1: Open Inventory");
            int next;
            int choice;
            switch (user.loc) {
                case 1:
                    while(getUserInt() == 1){
                        System.out.println(user.items);
                    }
                    user.loc = nextLoc();
                    break;
                case 2:
                    System.out.println("2: Quest");
                    choice = getUserInt();
                    while(choice != 0){
                        if(choice == 1) {
                            System.out.println(user.items);
                        }else if(choice == 2 && user.items[0]){
                            System.out.println();
                        }
                    }
                    user.loc = nextLoc();

                    break;
                case 11:
                    while(getUserInt() == 0){
                        System.out.println(user.items);
                    }
                    next = nextLoc();
                    if(next == 9){
                        System.out.println(endAttemptsDialogue[user.endAttempts]);
                        if(user.endAttempts == 4){
                            user.loc = 9;
                        }
                        user.endAttempts++;
                    }else{
                        user.loc = next;
                    }

                    break;
                default:
                    System.out.println("Looking forward to the Weekend");
            }
            if(user.step>21 || user.loc == 10){
                run = false;
            }
        }
        System.out.println("Play Again?");
        return (userInput());
    }

    private static String time(){
        int x = (user.step*15) + 600;
        return (x/60) + ": " + (x%60);
    }
    private static String stringExit(){
        String ret = "[ ";
        if(exits.containsKey("N")){
            ret += "N";
        }
        if(exits.containsKey("E")){
            if(ret.length() > 2){
                ret += ", ";
            }
            ret+= "E";
        }
        if(exits.containsKey("S")){
            if(ret.length() > 2){
                ret += ", ";
            }
            ret+= "S";
        }
        if(exits.containsKey("W")){
            if(ret.length() > 2){
                ret += ", ";
            }
            ret+= "W";
        }
        return ret;
    }

    private static int nextLoc(){
        System.out.print("> ");
        String[] x = userIn.nextLine().split(" ");
        for (String s : x) {
            for (String direction : directions) {

                if (s.equalsIgnoreCase(direction)){
                    String d = s.substring(0,1).toUpperCase();
                    if(exits.containsKey(d)){
                        return exits.get(d);
                    }
                }
                if(s.equalsIgnoreCase("p") || s.equalsIgnoreCase("Quit") || s.equalsIgnoreCase("exit")){
                    return (0);
                }
            }
        }
        System.out.println("Forbidden Location!");
        return nextLoc();
    }
    private static boolean userInput(){
        System.out.print("> ");
        String x = userIn.nextLine();
        if(x.equalsIgnoreCase("yes") || x.equalsIgnoreCase("y")){
            return true;
        }else if(x.equalsIgnoreCase("no") || x.equalsIgnoreCase("n")){
            return false;
        }
        return userInput();
    }
    private static int getUserInt(){
        System.out.print("> ");
        String x = userIn.nextLine();
        try{
            return Integer.parseInt(x);
        }catch(NumberFormatException e){
            return getUserInt();
        }
    }

}
