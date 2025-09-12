package panels;
import models.*;
import models.vehicle.*;

public class EntrancePanel {
    private String id;

    public EntrancePanel(String id) { 
        this.id = id; 
    }

    public String issueTicket(ParkingTicket ticket) {
        return ("Ticket is issued for " + ticket.getVehicle().getLicensePlate());
    }
}