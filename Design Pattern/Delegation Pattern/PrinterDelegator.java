public class PrinterDelegator implements Printer{
    private RealPrinter realPrinter;

    public void print(String message) {
        if(realPrinter == null) {
            realPrinter = new RealPrinter();
        }
        
        realPrinter.print(message);
    }
}
