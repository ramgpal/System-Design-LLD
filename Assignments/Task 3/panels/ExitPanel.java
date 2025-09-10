package panels;
import models.*;    

public class ExitPanel {
    private String id;

    // Constructor to initialize ExitPanel with an ID
    public ExitPanel(String id) { 
        this.id = id; 
    }

    // Method to scan a parking ticket and return fee information
    public String scanTicket(ParkingTicket ticket) {
        return "Ticket " + ticket.getTicketNo() + " scanned. Fee: " + ticket.getTotalFee();
    }
}