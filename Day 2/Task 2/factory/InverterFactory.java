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

        if(type.equals("PCU")) {
            return new PCU(current, voltage, panel);
        } else if(type.equals("GTI")) {
            return new GTI(current, voltage, panel);
        } else if(type.equals("Regalia")) {
            return new Regalia(current, voltage, panel);
        } else if(type.equals("Zelio") || type.equals("iCruze")) {
            return new HomeInverter(current, voltage, new Battery("Lithium-Ion", 180));
        }

        return  null;
    }
}
