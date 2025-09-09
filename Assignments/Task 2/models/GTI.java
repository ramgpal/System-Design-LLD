package models;

import util.SolarPanel;

public class GTI extends SolarInverter {

    public GTI(double current, double operatingVoltage, SolarPanel solarPanel) {
        super(current, operatingVoltage, solarPanel, true, null);
    }

    @Override
    public void displayDetails() {
        System.out.println("GTI Inverter");
        System.out.println("Power Rating: " + getPowerRating() + "W");
        System.out.println("Solar Panel Model: " + solarPanel.getModel());
        System.out.println("Battery: None");
        System.out.println("Grid On: " + gridOn);
    }
}
