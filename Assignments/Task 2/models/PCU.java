package models;

import util.Battery;
import util.SolarPanel;

public class PCU extends SolarInverter {

    public PCU(double current, double operatingVoltage, SolarPanel solarPanel) {
        super(current, operatingVoltage, solarPanel, false, new Battery("Lithium-Ion", 200));
    }

    @Override
    public void displayDetails() {
        System.out.println("PCU Inverter");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Solar Panel Model: " + solarPanel.getModel());
        System.out.println("Battery: " + battery.getDetails());
        System.out.println("Grid On: " + gridOn);
    }
}
