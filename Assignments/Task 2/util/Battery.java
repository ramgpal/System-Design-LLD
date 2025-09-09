package util;

public class Battery {
    private String type;
    private int capacity;  

    public Battery(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getDetails() {
        return type + " - " + capacity + "Ah";
    }
}
