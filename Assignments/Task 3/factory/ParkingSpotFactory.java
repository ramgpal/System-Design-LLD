package factory;

import models.parkingspot.*;

public class ParkingSpotFactory {

    // Method to create parking spots based on type
    public static ParkingSpot createParkingSpot(String type, String id) {
        switch (type.toLowerCase()) {
            case "compact": return new CompactSpot(id);
            case "large": return new LargeSpot(id);
            case "handicapped": return new HandicappedSpot(id);
            case "motorcycle": return new MotorcycleSpot(id);
            case "electric": return new ElectricSpot(id);
            default: return null;
        }
    }
}