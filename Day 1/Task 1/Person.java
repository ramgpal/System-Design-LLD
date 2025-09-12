public abstract class Person {
    private String name;
    private double spending;
    private Vehicle vehicle;

    public Person(String name, Vehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public double getSpending() {
        return spending;
    }

    public void addSpending(double amount) {
        this.spending += amount;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public abstract boolean exceedsSpendingLimit();
}
