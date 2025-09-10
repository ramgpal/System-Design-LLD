package users;

import parking.*;

public class Admin extends User {

    // Constructor
    public Admin(String name, String id) { 
        super(name, id); 
    }

    // Method to add a parking floor to a parking lot
    public void addFloor(ParkingLot lot, ParkingFloor floor) {
        lot.addFloor(floor);
    }

    // Method to update rate
    public void setRate(double first, double second, double remaining) {
    
    }
}