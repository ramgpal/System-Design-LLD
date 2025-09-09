import factory.InverterFactory;
import models.Inverter;
import util.InverterManager;

public class Main {
    public static void main(String[] args) {
        InverterManager manager = InverterManager.getInstance();

        Inverter pcu = InverterFactory.createInverter("PCU", 10, 230);
        Inverter gti = InverterFactory.createInverter("GTI", 15, 220);
        Inverter regalia = InverterFactory.createInverter("Regalia", 12, 240);
        Inverter zelio = InverterFactory.createInverter("Zelio", 8, 230);

        manager.showInverterDetails(pcu);
        System.out.println();

        manager.showInverterDetails(gti);
        System.out.println();

        manager.showInverterDetails(regalia);
        System.out.println();
        
        manager.showInverterDetails(zelio);
    }
}
