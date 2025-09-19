package singleton;

import enums.*;
import java.util.*;
import model.*;
import repository.*;
import users.*;

// Class responsible for managing CRUD operations related to room
public class RoomManager {

    // class fields
    private UserCatalog userCatalog;
    private static RoomManager instance;

    // constructor
    private RoomManager() {
        this.userCatalog = new UserCatalog();
    }

    // 1. function that will create or get single instance of hotel manager
    public static RoomManager getInstance() {
        if(instance == null) {
            instance = new RoomManager();
        }

        return instance;
    }

    // 2. Method to book rooms
    public void bookRoom(Hotel hotel, Room room, User user) {
        
        // only normal user can book the room
        if(user instanceof User) {
            List<Room> rooms = hotel.getRooms();

            for(Room curr : rooms) {
                if(curr.getRoomNumber() == room.getRoomNumber()) {
                    // checking availability of room
                    if(curr.getBookStatus().equals(BookStatus.AVAILABLE)) {
                        curr.setBookStatus(BookStatus.BOOKED); // room is booked
                        userCatalog.getUsers().put(user, room);

                        System.out.println("Room number " +room.getRoomNumber() +" is booked in "+ hotel.getHotelName());
                        return;
                    } else {
                        System.out.println("Selected room is not available");
                        return;
                    }
                }
            }
        } else {
            System.out.println("User is not authorised to book the room");
        }
    }


    // 3. Method to check either a room reserved or not
    public void viewReservationStatus(Hotel hotel, Room room, User user) {
        if(user instanceof User) {
            List<Room> rooms = hotel.getRooms();

            // 1. finding room and checking
            for(Room curr : rooms) {
                if(curr.getRoomNumber() == room.getRoomNumber()) {
                    if(curr.getBookStatus().equals(BookStatus.RESERVED)) {
                        System.out.println("Room is already reserved for someone else.");
                    } else if(curr.getBookStatus().equals(BookStatus.BOOKED)){
                        System.out.println("Room is already occupied.");
                    } else {
                        System.out.println("Room is available.");
                    }

                    return;
                }
            }

        } else {
            System.out.println("user is not authorised to see reservation status of a room");
        }
    }
}