package model;

public class Minister extends MP {


    public Minister(String name, String constituency, Driver driver) {
        super(name, constituency, driver);
    }

    @Override
    public boolean exceedsSpendingLimit() {
        return getSpending() > 1000000;
    }
}
