package models;

public abstract class Inverter {
    protected double current;
    protected double operatingVoltage;

    public Inverter(double current, double operatingVoltage) {
        this.current = current;
        this.operatingVoltage = operatingVoltage;
    }

    public double getPowerRating() {
        return current * operatingVoltage;
    }

    public abstract void displayDetails();
}
