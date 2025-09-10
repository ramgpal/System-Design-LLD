package factory;

import models.vehicle.*;

public class VehicleFactory {

    // Method to create vehicles based on type
    public static Vehicle createVehicle(String type, String licensePlate) {
        switch (type.toLowerCase()) {
            case "car": return new Car(licensePlate);
            case "truck": return new Truck(licensePlate);
            case "van": return new Van(licensePlate);
            case "motorcycle": return new Motorcycle(licensePlate);
            default: return null;
        }
    }
}