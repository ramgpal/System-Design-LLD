package models;

import util.Battery;
import util.SolarPanel;

public class Regalia extends SolarInverter {

    // constructor
    public Regalia(double current, double operatingVoltage, SolarPanel solarPanel) {
        super(current, operatingVoltage, solarPanel, false, new Battery("Lead-Acid", 150));
    }

    @Override
    public void displayDetails() {
        System.out.println("Regalia Inverter");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Solar Panel Model: " + solarPanel.getModel());
        System.out.println("Battery: " + battery.getDetails());
        System.out.println("Grid On: " + gridOn);
    }
}
