package services;

public class CreditPayment extends Payment {
    public CreditPayment(double amount) { 
        super(amount); 
    }

    public String pay() { 
        return "Paid " + amount + " by credit card"; 
    }
}