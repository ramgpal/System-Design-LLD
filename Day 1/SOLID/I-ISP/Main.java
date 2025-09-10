class Main {
    public static void main(String[] args) {
        Flyable obj = new Sparrow();
        obj.canFly();

        NotFlyable obj1 = new Penguin();
        obj1.cannotFly();
    }
}