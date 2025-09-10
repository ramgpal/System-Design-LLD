package util;

import models.Inverter;

public class InverterManager {
    private static InverterManager instance;

    private InverterManager() {}

    public static InverterManager getInstance() {
        if (instance == null) {
            instance = new InverterManager();
        }
        
        return instance;
    }

    public void showInverterDetails(Inverter inverter) {
        inverter.displayDetails();
    }
}
