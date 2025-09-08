public class Circle {
    private double radius;

     Circle(double radius) {
        this.radius = radius;
    }

    void calculateArea() {
        System.out.println(Math.PI * radius * radius);
    }
}
