import factory.*;
import models.parkingspot.*;
import models.vehicle.*;

public class Main {
    public static void main(String[] args) {
        // Factory creates a vehicle
        Vehicle car = VehicleFactory.createVehicle("Car", "DL-01-1234");

        // Factory creates a parking spot
        ParkingSpot spot = ParkingSpotFactory.createParkingSpot("Compact", "C2");

        // Assign vehicle to spot
        spot.assignVehicle(car);

        // Simulate ticketing process...
        System.out.println("Vehicle " + car.getLicensePlate() + " assigned to spot " + spot.getId());
    }
}