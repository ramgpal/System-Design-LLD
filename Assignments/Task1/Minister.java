public class Minister extends MP {
    private boolean pmPermission;

    public Minister(String name, String constituency, Driver driver) {
        super(name, constituency, driver);
        this.pmPermission = false;
    }

    public void grantPmPermission() {
        this.pmPermission = true;
    }

    public boolean hasPmPermission() {
        return pmPermission;
    }

    @Override
    public boolean exceedsSpendingLimit() {
        return getSpending() > 1000000;
    }
}
