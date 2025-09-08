public class Main {
    public static void main(String[] args) {
        Driver driver1 = new Driver("Driver1");
        Driver driver2 = new Driver("Driver2");
        Driver aircraftDriver = new Driver("AircraftDriver");

        MP mp = new MP("Ram", "Delhi", driver1);
        mp.addSpending(150000);

        Minister minister = new Minister("Shyam", "Mumbai", driver2);
        minister.addSpending(2000000);

        PM pm = new PM("Narendra Modi", "Pan India", driver1, aircraftDriver);


        // Injecting PM dependency into Commissioner (DI in action)
        Commissioner commissioner = Commissioner.getInstance(pm);

        System.out.println(commissioner.canArrest(mp));  
        System.out.println(commissioner.canArrest(minister));  
        System.out.println(commissioner.canArrest(pm)); 
    }
}
