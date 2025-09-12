package singleton;

import java.util.*;
import models.parkingspot.ParkingSpot;
import parking.*;
import users.*;

public class FloorManager {
    private static FloorManager instance;

    private FloorManager() {
    }

    public static FloorManager getInstance() {
        if (instance == null) {
            instance = new FloorManager();
        }
        return instance;
    }

    // Add floor
    public void addFloor(ParkingLot lot, ParkingFloor floor, User user) {
        if(user instanceof Admin) {
            lot.getFloors().add(floor);
            System.out.println("Floor added successfully." + floor.getFloorNo());
        } else {
            System.out.println("Access Denied.");
        }
    }

    // remove floor 
    public void removeFloor(ParkingLot lot, ParkingFloor floor, User user) {
        if(user instanceof Admin) {
            lot.getFloors().remove(floor);
            System.out.println("Floor removed successfully." + floor.getFloorNo());
        } else {
            System.out.println("Access Denied.");
        }
    }

    // Method to update Floor
    public void updateFloor(ParkingLot lot, ParkingFloor floor,  ParkingSpot spot, User user) {
        if(user instanceof Admin) {
            List<ParkingFloor> floors = lot.getFloors();

            for(ParkingFloor f : floors) {
                if(f.getFloorNo() == floor.getFloorNo()) {
                    f.getSpots().add(spot);
                    break;
                }
            }

            System.out.println("Floor updated successfully.");
        } else {
            System.out.println("Access Denied.");
        }
    }

    // Method to get floor details
    public void getFloorDetailsByfloorNumber(ParkingLot lot, int floorNo, User user) {
        if(user instanceof Admin) {
            List<ParkingFloor> floors = lot.getFloors();
            for(ParkingFloor f : floors) {
                if(f.getFloorNo() == floorNo) {
                    System.out.println("Floor Number: " + f.getFloorNo());
                    System.out.println("Parking Spots: ");
                    for(ParkingSpot spot : f.getSpots()) {
                        System.out.println("Spot ID: " + spot.getId() + ", Type: " + spot.getType() + ", Is Free: " + spot.isFree());
                    }
                    break;
                }
            }
            
            System.out.println("Fetched floor details successfully.");
        } else {
            System.out.println("Access Denied.");
        }
    }
}
