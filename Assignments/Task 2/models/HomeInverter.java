package models;

import util.Battery;

public class HomeInverter extends Inverter {
    private Battery battery;

    // constructor
    public HomeInverter(double current, double operatingVoltage, Battery battery) {
        super(current, operatingVoltage);
        this.battery = battery;
    }

    @Override
    public void displayDetails() {
        System.out.println("Home Inverter");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Battery: " + battery.getDetails());
    }
}
