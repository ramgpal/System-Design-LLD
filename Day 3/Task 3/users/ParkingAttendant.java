package users;
import models.*;
import services.*;

public class ParkingAttendant extends Customer {

    // Constructor
    public ParkingAttendant(String name, String id) { 
        super(name, id); 
    }

    // assisting customer in paying
    public String assistCustomer(ParkingTicket ticket, Payment payment) {
        ticket.markPaid();
        return "Attendant " + this.name + " processed: " + payment.pay();
    }
}