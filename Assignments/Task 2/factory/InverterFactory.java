package factory;

import models.GTI;
import models.HomeInverter;
import models.Inverter;
import models.PCU;
import models.Regalia;
import util.Battery;
import util.SolarPanel;

public class InverterFactory {
    public static Inverter createInverter(String type, double current, double voltage) {
        SolarPanel panel = new SolarPanel("SP-300W");

        switch (type) {
            case "PCU":
                return new PCU(current, voltage, panel);
            case "GTI":
                return new GTI(current, voltage, panel);
            case "Regalia":
                return new Regalia(current, voltage, panel);
            case "Zelio":
            case "iCruze":
                return new HomeInverter(current, voltage, new Battery("Lithium-Ion", 180));
            default:
                throw new IllegalArgumentException("Unknown inverter type");
        }
    }
}
