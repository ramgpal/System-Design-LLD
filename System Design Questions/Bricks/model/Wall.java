package model;

import java.util.*;

public class Wall {
    private String name;
    List<Brick> bricks;

    // constructor
    public Wall(String name) {
        this.name = name;
        bricks = new ArrayList<>();
    }
}
