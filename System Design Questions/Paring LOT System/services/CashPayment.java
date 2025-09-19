package services;

public class CashPayment extends Payment {
    public CashPayment(double amount) { 
        super(amount); 
    }

    public String pay() { 
        return "Paid " + amount + " in cash"; 
    }
}