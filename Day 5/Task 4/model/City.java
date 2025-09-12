package model;

import java.util.*;

public class City {
    private String name;
    List<Wall> walls;

    public City(String name) {
        this.name = name;
        walls = new ArrayList<>();
    }
}
