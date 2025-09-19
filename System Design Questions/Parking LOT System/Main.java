import factory.*;
import models.parkingspot.*;
import models.vehicle.*;
import parking.*;
import singleton.*;
import users.*;

public class Main {
    public static void main(String[] args) {
        // Factory creates a vehicle
        Vehicle car = VehicleFactory.createVehicle("Car", "DL-01-1234");

        // Factory creates a parking spot
        ParkingSpot spot = ParkingSpotFactory.createParkingSpot("Compact", "C2");

        // Assign vehicle to spot
        spot.assignVehicle(car);

        System.out.println("Vehicle " + car.getLicensePlate() + " assigned to spot " + spot.getId());


        // creating parking manager instance
        FloorManager manager = FloorManager.getInstance();
            
        // creating parking lot
        ParkingLot lot = new ParkingLot(100);

        // creating admin user
        // User newUser = 

        // adding floor to parking lot
        manager.addFloor(lot, new ParkingFloor(2), new Admin("Ram", "A1"));
        System.out.println();

        // updating floor with new parking spot
        manager.updateFloor(lot, new ParkingFloor(2), spot, new Admin("Ram", "A1"));
        System.out.println();

        // getting floor details
        manager.getFloorDetailsByfloorNumber(lot, 2, new Admin("Ram", "A1"));

    }
}