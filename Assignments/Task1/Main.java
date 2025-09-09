public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Driver1");
        Driver driver2 = new Driver("Driver2");
        Driver aircraftDriver = new Driver("AircraftDriver");

        MP mp = new MP("Ram", "Delhi", driver1);
        mp.addSpending(120000);  // exceeds limit

        Minister minister = new Minister("Shyam", "Mumbai", driver2);
        minister.addSpending(1500000); 
        minister.grantPmPermission();

        PM pm = new PM("Narendra Modi", "Pan India", driver1, aircraftDriver);
        pm.addSpending(8000000);

        Commissioner commissioner = new Commissioner();

        System.out.println("\nChecking MP:");
        commissioner.canArrest(mp);

        System.out.println("\nChecking Minister:");
        commissioner.canArrest(minister);

        System.out.println("\nChecking PM:");
        commissioner.canArrest(pm);
    }
}
