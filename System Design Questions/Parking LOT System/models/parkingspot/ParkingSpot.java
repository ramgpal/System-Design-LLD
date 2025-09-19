package models.parkingspot;

import models.vehicle.*;

public abstract class ParkingSpot {
    protected String id;
    protected String type;
    protected boolean isFree;
    protected Vehicle vehicle;

    // Constructor
    public ParkingSpot(String id, String type) {
        this.id = id;
        this.type = type;
        this.isFree = true;
    }

    // Method to assign a vehicle to the spot - Assuming a DB interaction here
    public void assignVehicle(Vehicle v) {
        if (!isFree) {
            System.out.println("Spot already occupied");
            return;
        }

        this.vehicle = v;
        this.isFree = false;
    }

    // Method to remove a vehicle from the spot
    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }

    // getter for type
    public String getType() { 
        return type; 
    }

    // getter for isFree
    public boolean isFree() { 
        return isFree; 
    }

    // getter for id
    public String getId() { 
        return id; 
    }
}
