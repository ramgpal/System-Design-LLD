public class Car {
    private String engine;
    private int wheels;
    private boolean airConditioning;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public void showCar() {
        System.out.println("Engine: " + engine);
        System.out.println("Wheels: " + wheels);
        System.out.println("AC: " + airConditioning);
    }
}
