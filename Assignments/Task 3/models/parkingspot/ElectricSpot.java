package models.parkingspot;

public class ElectricSpot extends ParkingSpot {
    private boolean hasCharger;

    // Constructor
    public ElectricSpot(String id) {
        super(id, "Electric");
        this.hasCharger = true;
    }

    // Method to charge the car
    public String chargeCar() {
        if (vehicle == null) return "No vehicle to charge";
        return "Charging " + vehicle.getLicensePlate();
    }
}