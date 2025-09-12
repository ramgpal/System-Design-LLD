package models;

import util.Battery;
import util.SolarPanel;

public abstract class SolarInverter extends Inverter {
    protected SolarPanel solarPanel;
    protected boolean gridOn;
    protected Battery battery;

    public SolarInverter(double current, double operatingVoltage, SolarPanel solarPanel, boolean gridOn, Battery battery) {
        super(current, operatingVoltage);
        this.solarPanel = solarPanel;
        this.gridOn = gridOn;
        this.battery = battery;
    }

    public abstract void displayDetails();
}
