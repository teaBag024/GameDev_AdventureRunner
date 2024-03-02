public class User {
    public int loc;
    public Boolean[] items = {false, false, false, false, false};
    //water, badge, ticket, bag of air, key
    public int endAttempts;
    public int step;

    public User (){
        loc = 1;
        endAttempts = 0;
        step = 0;
    }
}
