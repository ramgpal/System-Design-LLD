package model;

public class Rack {
    private int number;
    private String locationId;

    // constructor
    public Rack(int number, String locationId) {
        this.number = number;
        this.locationId = locationId;
    }

    // getter for number
    public int getNumber() { 
        return number; 
    }

    // getter for location
    public String getLocationId() { 
        return locationId; 
    }
}
