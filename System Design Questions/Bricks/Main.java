import model.*;
import model.user.*;
import singleton.*;

public class Main {
    public static void main(String[] args) {
        BricksManager manager = BricksManager.getInstance();
        Inventory it = new Inventory(); 
        User user = new User("Geeta", 3);


        manager.AssignBrick(it , new Owner("abc", 0, "India", "Noida"), new Brick(4, user, "Hii", "You are superb"));
        manager.AssignBrick(it , new Owner("cde", 1, "India", "Noida"), new Brick(7, user, "Hii", "You are special"));
        manager.AssignBrick(it , new Owner("Ram", 0, "India", "Noida"), new Brick(5, new User("Vivek", 4), "Hii", "You are nice"));
        
        System.out.println(manager.mostDedicatedGuy(it));
        System.out.println(manager.mostUglyGuy(it));
    }
}
