package users;
import models.*;
import panels.*;
import services.*;

public class Customer extends User {

    // Constructor
    public Customer(String name, String id) { 
        super(name, id); 
    }

    // Method to take a ticket from the entrance panel
    public String takeTicket(EntrancePanel entrance, ParkingTicket ticket) {
        return entrance.issueTicket(ticket);
    }

    // Method to pay for the parking ticket at the exit panel
    public String payTicket(ParkingTicket ticket, Payment payment) {
        ticket.markPaid();
        return payment.pay();
    }
}