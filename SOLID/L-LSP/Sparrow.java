public class Sparrow extends Bird implements  FlyingBird {
    public Sparrow(String name) {
        super(name);
    }

    public void fly() {
        System.out.println("Spparrow can fly");
    }
}
