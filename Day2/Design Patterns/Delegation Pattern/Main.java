class Main {
    public static void main(String[] args) {
        Printer obj = new PrinterDelegator();
        obj.print("Hi, This is Ram!");
    }
}