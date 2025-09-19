package singleton;

import java.util.*;
import model.*;
import model.user.*;

public class BricksManager {
    private static BricksManager instance;

    private BricksManager() {};

    public static BricksManager getInstance() {
        if(instance == null) {
            instance = new BricksManager();
        }

        return instance;
    }

    // Method to write content on  brick and dedicate to someone
    public void AssignBrick(Inventory it, User by, Brick brick) {
        if(by instanceof User) {
            Map<User, List<Brick>> bricks = it.getBrickIds();
            User dedicatedTo = brick.dedicatedTo;
            int userId = dedicatedTo.getId();

            if(bricks.containsKey(dedicatedTo)) {
                List<Brick> curr = bricks.get(brick.dedicatedTo);
                curr.add(brick);
            } else {
                List<Brick> toAdd = new ArrayList<>();
                toAdd.add(brick);
                bricks.put(dedicatedTo, toAdd);
            }

            System.out.println("Bricks dedicated successfully...");
        } else {
            System.out.println("Not permitted...");
        }
    }

    // Method to find Most dedicated guy
    public String mostDedicatedGuy(Inventory it) {
        Map<User, List<Brick>> bricks = it.getBrickIds();
        int max = -1;
        String ans = "";
        for(User key : bricks.keySet()) {
            if(max < bricks.get(key).size()) {
                max = bricks.get(key).size();
                ans = key.getName();
            }
        }

        return max == -1 ? "No Data Present" : "Most dedicated guy is: " + ans;
    }


    // Method to find least dedicated guy
    public String mostUglyGuy(Inventory it) {
        Map<User, List<Brick>> bricks = it.getBrickIds();
        int min = Integer.MAX_VALUE;
        String ans = "";

        for(User key : bricks.keySet()) {
            if(min > bricks.get(key).size()) {
                min = bricks.get(key).size();
                ans = key.getName();
                System.out.println(ans);
            }
        }

        return min == Integer.MAX_VALUE ? "No Data Present" : "Least dedicated guy is: " + ans;
    }


    // Method to edit data on Brick
    public void editBrick(Inventory it, User user, Brick brick) {
        if(user instanceof Admin || user instanceof Owner) {
            User dedicatedTo = brick.dedicatedTo;
            List<Brick> bricks = it.getBrickIds().get(dedicatedTo);

            for(Brick br : bricks) {
                if(br.getBrickId() == brick.getBrickId()) {
                    br.setBrickId(brick.getBrickId());
                    br.dedicatedTo = brick.dedicatedTo;
                    br.message = brick.message;
                    br.caption = brick.caption;
                }
            }
        }
    }
}
