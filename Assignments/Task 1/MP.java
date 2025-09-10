public class MP extends Person {
    private String constituency;

    public MP(String name, String constituency, Driver driver) {
        super(name, new Vehicle("Car", driver));
        this.constituency = constituency;
    }

    public String getConstituency() {
        return constituency;
    }

    @Override
    public boolean exceedsSpendingLimit() {
        return getSpending() > 100000;
    }
}
