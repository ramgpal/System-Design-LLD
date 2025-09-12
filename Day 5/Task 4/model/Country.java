package model;

import java.util.*;

public  class Country {
    private String name;
    private List<City> cities;

    // constructor
    public Country(String name) {
        this.name = name;
        cities = new ArrayList<>();
    }
}