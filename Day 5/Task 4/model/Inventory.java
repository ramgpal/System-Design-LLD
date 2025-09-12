package model;

import java.util.*;
import model.user.*;

public class Inventory {
    private Map<User, List<Brick>> bricks;

    public Inventory() {
        bricks = new HashMap<>();
    }

    // getter for map
    public Map<User, List<Brick>> getBrickIds() {
        return this.bricks;
    }
}