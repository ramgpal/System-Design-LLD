public class CarBuilder {
    private Car car;

    public CarBuilder() {
        car = new Car();
    }

    public CarBuilder setEngine(String engine) {
        car.setEngine(engine);
        return this;
    }

    public CarBuilder setWheels(int wheels) {
        car.setWheels(wheels);
        return this;
    }

    public CarBuilder setAirConditioning(boolean airConditioning) {
        car.setAirConditioning(airConditioning);
        return this;
    }

    public Car build() {
        return car;
    }
}
