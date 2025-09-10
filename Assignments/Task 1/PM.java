public class PM extends MP {
    private Vehicle aircraft;

    public PM(String name, String constituency, Driver carDriver, Driver aircraftDriver) {
        super(name, constituency, carDriver);
        this.aircraft = new Vehicle("Aircraft", aircraftDriver);
    }

    public Vehicle getAircraft() {
        return aircraft;
    }

    @Override
    public boolean exceedsSpendingLimit() {
        return getSpending() > 10000000;
    }

    public static boolean allowArrest(Minister minister) {
        return true;
    }
}
