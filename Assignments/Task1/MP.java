public class MP {
    private String name;
    private String constituency;
    private Vehicle vehicle;
    private double spending;

    // constructor
    public MP(String name, String constituency, Driver driver) {
        this.name = name;
        this.constituency = constituency;
        this.vehicle = new Vehicle("Car", driver);
        this.spending = 0;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getConstituency() {
        return constituency;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void addSpending(double amount) {
        this.spending += amount;
    }

    public double getSpending() {
        return spending;
    }

    // method to check if spending cross allowed limit or not
    public boolean exceedsSpendingLimit() {
        return spending > 100000;
    }
}
