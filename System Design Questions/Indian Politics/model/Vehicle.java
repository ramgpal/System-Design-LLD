package model;

public class Vehicle {
    private String type;  
    private Driver driver;

    public Vehicle(String type, Driver driver) {
        this.type = type;
        this.driver = driver;
    }

    public String getType() {
        return type;
    }

    public Driver getDriver() {
        return driver;
    }
}
