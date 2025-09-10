package models;

import java.time.LocalDateTime;
import models.parkingspot.*;
import models.vehicle.*;

public class ParkingTicket {
    private int ticketNo;

    // total hours will be -> paidAt - issuedAt
    private LocalDateTime issuedAt;
    private LocalDateTime paidAt;
    private double totalFee;
    private Vehicle vehicle;
    private ParkingSpot spot;

    // Constructor
    public ParkingTicket(int ticketNo, Vehicle v, ParkingSpot spot) {
        this.ticketNo = ticketNo;
        this.vehicle = v;
        this.spot = spot;
        this.issuedAt = LocalDateTime.now();
    }

    // Method to calculate fee based on rate and duration
    public double calculateFee(int hours) {
        double fee = 0;
        if(hours > 0) {
            fee += 4;
            hours--;
        }

        if(hours > 0) {
            fee += 3.5;
            hours--;
        }

        if(hours > 0) {
            fee += 3.5;
            hours--;

            if(hours > 0) {
                fee += 3.5;
                hours--;
            }
        }

        if(hours > 0) {
            fee += hours * 2.5;
        }

        this.totalFee = fee;

        return this.totalFee;
    }

    // setter fir paidAt
    public void markPaid() {
        this.paidAt = LocalDateTime.now();
    }

    // getter for totalFee
    public double getTotalFee() { 
        return totalFee; 
    }

    // getter for ticketNo
    public int getTicketNo() { 
        return ticketNo; 
    }

    // getter for Vehicle 
    public Vehicle getVehicle() { 
        return vehicle; 
    }
}