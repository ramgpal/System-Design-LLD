# Parking Lot Design

A parking lot or car park is a dedicated cleared area that is intended for parking vehicles.

Use case

Here are the main Actors in our system:

- Admin: Mainly responsible for adding and modifying parking floors, parking spots, entrance, and exit panels, adding/removing parking attendants, etc.
- Customer: All customers can get a parking ticket and pay for it.
- Parking attendant: Parking attendants can do all the activities on the customer’s behalf, and can take cash for ticket payment.
- System: To display messages on different info panels, as well as assigning and removing a vehicle from a parking spot.

Here are the top use cases for Parking Lot:

- Add/Remove/Edit parking floor: To add, remove or modify a parking floor from the system. Each floor can have its own display board to show free parking spots.
- Add/Remove/Edit parking spot: To add, remove or modify a parking spot on a parking floor.
- Add/Remove a parking attendant: To add or remove a parking attendant from the system.
- Take ticket: To provide customers with a new parking ticket when entering the parking lot.
- Scan ticket: To scan a ticket to find out the total charge.
- Credit card payment: To pay the ticket fee with credit card.
- Cash payment: To pay the parking ticket through cash.
- Add/Modify parking rate: To allow admin to add or modify the hourly parking rate


System Requirements

We will focus on the following set of requirements while designing the parking lot:

1. The parking lot should have multiple floors where customers can park their cars.
2. The parking lot should have multiple entry and exit points.
3. Customers can collect a parking ticket from the entry points and can pay the parking fee at the exit points on their way out.
4. Customers can pay the tickets at the automated exit panel or to the parking attendant.
5. Customers can pay via both cash and credit cards.
6. Customers should also be able to pay the parking fee at the customer’s info portal on each floor. If the customer has paid at the info portal, they don’t have to pay at the exit.
7. The system should not allow more vehicles than the maximum capacity of the parking lot. If the parking is full, the system should be able to show a message at the entrance panel and on the parking display board on the ground floor.
8. Each parking floor will have many parking spots. The system should support multiple types of parking spots such as Compact, Large, Handicapped, Motorcycle, etc
9. The Parking lot should have some parking spots specified for electric cars. These spots should have an electric panel through which customers can pay and charge their vehicles.
10. The system should support parking for different types of vehicles like car, truck, van, motorcycle, etc.
11. Each parking floor should have a display board showing any free parking spot for each spot type.
12. The system should support a per-hour parking fee model. For example, customers have to pay $4 for the first hour, $3.5 for the second and third hours, and $2.5 for all the remaining hours.






import java.util.*;
import java.time.LocalDateTime;
 
// ===== model/Vehicle.java =====
abstract class Vehicle {
    private String licensePlate;
    private String type;
 
    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
 
    public String getLicensePlate() { return licensePlate; }
    public String getType() { return type; }
}
 
class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, "CAR");
    }
}
 
class Truck extends Vehicle {
    public Truck(String licensePlate) {
        super(licensePlate, "TRUCK");
    }
}
 
class Van extends Vehicle {
    public Van(String licensePlate) {
        super(licensePlate, "VAN");
    }
}
 
class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, "MOTORCYCLE");
    }
}
 
class ElectricCar extends Vehicle {
    public ElectricCar(String licensePlate) {
        super(licensePlate, "ELECTRIC_CAR");
    }
}
 
// ===== model/ParkingSpot.java =====
abstract class ParkingSpot {
    private String id;
    private boolean occupied;
    private String type;
 
    public ParkingSpot(String id, String type) {
        this.id = id;
        this.type = type;
        this.occupied = false;
    }
 
    public String getId() { return id; }
    public String getType() { return type; }
    public boolean isOccupied() { return occupied; }
 
    public void assignVehicle() { this.occupied = true; }
    public void removeVehicle() { this.occupied = false; }
}
 
class CompactSpot extends ParkingSpot {
    public CompactSpot(String id) {
        super(id, "COMPACT");
    }
}
 
class LargeSpot extends ParkingSpot {
    public LargeSpot(String id) {
        super(id, "LARGE");
    }
}
 
class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(String id) {
        super(id, "HANDICAPPED");
    }
}
 
class MotorcycleSpot extends ParkingSpot {
    public MotorcycleSpot(String id) {
        super(id, "MOTORCYCLE");
    }
}
 
class ElectricSpot extends ParkingSpot {
    public ElectricSpot(String id) {
        super(id, "ELECTRIC");
    }
}
 
// ===== model/ParkingFloor.java =====
class ParkingFloor {
    private String floorId;
    private List<ParkingSpot> spots = new ArrayList<>();
 
    public ParkingFloor(String floorId) {
        this.floorId = floorId;
    }
 
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }
 
    public List<ParkingSpot> getAvailableSpots(String type) {
        List<ParkingSpot> available = new ArrayList<>();
        for (ParkingSpot spot : spots) {
            if (spot.getType().equals(type) && !spot.isOccupied()) {
                available.add(spot);
            }
        }
        return available;
    }
}
 
// ===== model/ParkingTicket.java =====
class ParkingTicket {
    private String ticketId;
    private String vehicleLicense;
    private LocalDateTime entryTime;
    private boolean paid;
 
    public ParkingTicket(String ticketId, String vehicleLicense) {
        this.ticketId = ticketId;
        this.vehicleLicense = vehicleLicense;
        this.entryTime = LocalDateTime.now();
        this.paid = false;
    }
 
    public long calculateParkingHours() {
        return java.time.Duration.between(entryTime, LocalDateTime.now()).toHours() + 1;
    }
 
    public void markPaid() { this.paid = true; }
    public boolean isPaid() { return paid; }
    public String getTicketId() { return ticketId; }
    public String getVehicleLicense() { return vehicleLicense; }
}
 
// ===== model/ParkingLot.java =====
import util.PaymentStrategy;
 
class ParkingLot {
    private List<ParkingFloor> floors = new ArrayList<>();
    private Map<String, ParkingTicket> activeTickets = new HashMap<>();
    private double[] hourlyRates = {4.0, 3.5, 3.5, 2.5};
 
    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }
 
    public ParkingTicket issueTicket(Vehicle vehicle) {
        String ticketId = UUID.randomUUID().toString();
        ParkingTicket ticket = new ParkingTicket(ticketId, vehicle.getLicensePlate());
        activeTickets.put(ticketId, ticket);
        System.out.println("Ticket issued: " + ticketId);
        return ticket;
    }
 
    public void payTicket(String ticketId, PaymentStrategy strategy) {
        ParkingTicket ticket = activeTickets.get(ticketId);
        if (ticket == null) throw new IllegalArgumentException("Invalid ticket");
 
        if (ticket.isPaid()) {
            System.out.println("Ticket already paid.");
            return;
        }
 
        long hours = ticket.calculateParkingHours();
        double total = 0;
 
        for (int i = 0; i < hours; i++) {
            total += (i < hourlyRates.length) ? hourlyRates[i] : hourlyRates[hourlyRates.length - 1];
        }
 
        strategy.pay(total);
        ticket.markPaid();
    }
}
 
// ===== factory/ParkingSpotFactory.java =====
class ParkingSpotFactory {
    public static ParkingSpot createSpot(String type, String id) {
        switch (type) {
            case "COMPACT": return new CompactSpot(id);
            case "LARGE": return new LargeSpot(id);
            case "HANDICAPPED": return new HandicappedSpot(id);
            case "MOTORCYCLE": return new MotorcycleSpot(id);
            case "ELECTRIC": return new ElectricSpot(id);
            default: return new ParkingSpot(id, type) {};
        }
    }
}
 
// ===== util/PaymentStrategy.java =====
interface PaymentStrategy {
    void pay(double amount);
}
 
// ===== util/CashPayment.java =====
class CashPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " in cash");
    }
}
 
// ===== util/CreditCardPayment.java =====
class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using credit card");
    }
}
 
// ===== Main.java =====
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot = new ParkingLot();
        ParkingFloor floor1 = new ParkingFloor("Floor1");
 
        // Add all types of spots
        floor1.addSpot(ParkingSpotFactory.createSpot("COMPACT", "C1"));
        floor1.addSpot(ParkingSpotFactory.createSpot("LARGE", "L1"));
        floor1.addSpot(ParkingSpotFactory.createSpot("HANDICAPPED", "H1"));
        floor1.addSpot(ParkingSpotFactory.createSpot("MOTORCYCLE", "M1"));
        floor1.addSpot(ParkingSpotFactory.createSpot("ELECTRIC", "E1"));
 
        lot.addFloor(floor1);
 
        // Simulate vehicle entry
        Vehicle car = new Car("CAR-001");
        Vehicle truck = new Truck("TRUCK-001");
        Vehicle van = new Van("VAN-001");
        Vehicle motorcycle = new Motorcycle("MOTO-001");
        Vehicle electricCar = new ElectricCar("ELEC-001");
 
        // Issue tickets
        ParkingTicket ticket1 = lot.issueTicket(car);
        ParkingTicket ticket2 = lot.issueTicket(truck);
        ParkingTicket ticket3 = lot.issueTicket(electricCar);
 
        // Simulate delay (1 hour for demo purposes)
        Thread.sleep(1000);
 
        // Payment
        lot.payTicket(ticket1.getTicketId(), new CashPayment());
        lot.payTicket(ticket2.getTicketId(), new CreditCardPayment());
        lot.payTicket(ticket3.getTicketId(), new CashPayment());
    }
}
 


+------------------+
|    ParkingLot    |
+------------------+
| - name           |
| - address        |
| - capacity       |
| - floors: List   |
| - entrances: List|
| - exits: List    |
+------------------+
| + addFloor()     |
| + removeFloor()  |
| + getCapacity()  |
+------------------+
         |
         | 1..*  
         v
+------------------+
|  ParkingFloor    |
+------------------+
| - floorNo        |
| - spots: List    |
| - displayBoard   |
+------------------+
| + addSpot()      |
| + removeSpot()   |
| + showAvailability() |
+------------------+
         |
         | 1..*
         v
+------------------+
|  ParkingSpot     |<<abstract>>
+------------------+
| - id             |
| - type           |
| - isFree         |
| - vehicle        |
+------------------+
| + assignVehicle()|
| + removeVehicle()|
+------------------+
   ^      ^       ^         ^
   |      |       |         |
   |      |       |         |
+------+ +----------+ +----------+ +-----------+
|Compact| |Large     | |Handicapped| |Motorcycle|
+------+ +----------+ +----------+ +-----------+
                                   |
                                   |
                            +--------------+
                            | ElectricSpot |
                            +--------------+
                            | - hasCharger |
                            +--------------+
                            | + chargeCar()|
                            +--------------+

+------------------+
|    Vehicle       |<<abstract>>
+------------------+
| - licensePlate   |
| - type           |
+------------------+
        ^
  +------+------+-------+
  |      |      |       |
 Car   Truck   Van   Motorcycle


+-------------------+
|    ParkingTicket  |
+-------------------+
| - ticketNo        |
| - issuedAt        |
| - paidAt          |
| - totalFee        |
| - vehicle         |
| - spot            |
+-------------------+
| + calculateFee()  |
| + markPaid()      |
+-------------------+

+-------------------+
|   Payment         |<<abstract>>
+-------------------+
| - amount          |
| - time            |
+-------------------+
| + pay()           |
+-------------------+
     ^            ^
     |            |
+----------+  +----------+
| Cash     |  | Credit   |
+----------+  +----------+

+-------------------+
|    Rate           |
+-------------------+
| - firstHour       |
| - secondHourRate  |
| - remainingRate   |
+-------------------+
| + getCharge(hours)|
+-------------------+


+------------------+
| EntrancePanel    |
+------------------+
| - id             |
| - location       |
+------------------+
| + issueTicket()  |
| + showMessage()  |
+------------------+

+------------------+
| ExitPanel        |
+------------------+
| - id             |
| - location       |
+------------------+
| + scanTicket()   |
| + processPayment()|
+------------------+

+------------------+
| DisplayBoard     |
+------------------+
| - freeCompact    |
| - freeLarge      |
| - freeHandicapped|
| - freeMotorcycle |
+------------------+
| + showAvailability() |
+------------------+


+------------------+
|   User           |<<abstract>>
+------------------+
| - name           |
| - id             |
+------------------+
        ^
   +-----------+      +-----------------+
   |  Admin    |      | Customer        |
   +-----------+      +-----------------+
   | + addFloor()     | + takeTicket()  |
   | + addSpot()      | + payTicket()   |
   | + addAttendant() |
   | + setRate()      |
   +-----------+      +-----------------+
                          ^
                          |
                   +-----------------+
                   | ParkingAttendant|
                   +-----------------+
                   | +assistCustomer()|
                   +-----------------+

import java.time.LocalDateTime;
import java.util.*;

// -----------------------------
// Abstract Vehicle
// -----------------------------
abstract class Vehicle {
    protected String licensePlate;
    protected String type;

    public Vehicle(String licensePlate, String type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() { return licensePlate; }
    public String getType() { return type; }
}



}

}



// -----------------------------
// Abstract Parking Spot
// -----------------------------











// -----------------------------
// Parking Ticket
// -----------------------------


// -----------------------------
// Abstract Payment
// -----------------------------






// -----------------------------
// Rate
// -----------------------------


// -----------------------------
// Panels
// -----------------------------




// -----------------------------
// Display Board
// -----------------------------


// -----------------------------
// Parking Floor
// -----------------------------

// -----------------------------
// Parking Lot
// -----------------------------


// -----------------------------
// Abstract User
// -----------------------------






