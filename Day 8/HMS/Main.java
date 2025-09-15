import enums.BookStatus;
import java.util.*;
import model.*;
import singleton.*;
import users.*;

public class Main {
    public static void main(String[] args) {
        // Creating single object of hotel manager
        HotelManager hotelManager = HotelManager.getInstance();

        // Adding a new Hotel in the site
        hotelManager.addHotel(new Hotel("Royal Galaxy", "Noida"), new HotelAgent("abc", "xyz"), new Administrator("ad", "yz"));
        System.out.println();
        
        Hotel hotel = new Hotel("Sunshine Residency", "Delhi");
        hotelManager.addHotel(hotel, new HotelAgent("abc", "xyz"), new Administrator("ad", "yz"));
        System.out.println();

        // removing a hotel from the site
        hotelManager.deleteHotel(hotel, new Administrator("ad", "yz"));
        System.out.println();

        // adding rooms in the hotel
        hotel = new Hotel("Sunshine Residency", "Delhi");
        List<Room> rooms = hotel.getRooms();
        rooms.add(new Room(100, BookStatus.AVAILABLE));
        rooms.add(new Room(101, BookStatus.AVAILABLE));
        Room roomToAdd = new Room(102, BookStatus.AVAILABLE);
        rooms.add(roomToAdd);

        // Creating single instance of user Manager that perform actions of users
        UserManager userManager = UserManager.getInstance();
        
        // Booking a room 102
        userManager.bookRoom(hotel, roomToAdd, new User("Ram", "email.com"));
        System.out.println();

        // giving feedback to a hotel
        userManager.giveFeedback(hotel, new Rating(new User("cva", "xyz"), 4));
    }
}
