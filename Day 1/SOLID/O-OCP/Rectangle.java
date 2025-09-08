public class Rectangle {
    private double length;
    private double breadth;

     Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }       
    
    void calculateArea() {
        System.out.println(length * breadth);
    }
}
