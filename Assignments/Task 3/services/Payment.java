package services;

import java.time.LocalDateTime;

public abstract class Payment {
    protected double amount;
    protected LocalDateTime time;

    public Payment(double amount) {
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public abstract String pay();
}