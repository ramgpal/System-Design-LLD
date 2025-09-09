public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .setEngine("V8")
                .setWheels(4)
                .setAirConditioning(true)
                .build();
                
        car.showCar();
    }
}
