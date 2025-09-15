package singleton;

import enums.BookStatus;
import java.util.*;
import model.Hotel;
import model.Rating;
import model.Room;
import repository.UserCatalog;
import users.*;

public class UserManager {

    // class fields
    private UserCatalog userCatalog;
    private static UserManager instance; // singleton

    // constructor
    private UserManager() {
        this.userCatalog = new UserCatalog();
    }

    // Method to create single instance
    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    // Method to register user
    public void registerUser(User user) {
        if(userCatalog.getUsers().containsKey(user)) {
            System.out.println("User already exist");
        } else {
            userCatalog.getUsers().put(user, null);
        }
    }

    // deleting user from hotel
    public void deleteUser(User toDelete, User user) {
        if(user instanceof Administrator) {
            if(userCatalog.getUsers().containsKey(toDelete)) {
                userCatalog.getUsers().remove(user);
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Intended user not found");
            }
        } else {
            System.out.println("user is not authorise to delete user from the system.");
        }
    }

    // Method to book rooms
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

    // Method to check either a room reserved or not
    public void viewReservationStatus(Hotel hotel, Room room, User user) {
        if(user instanceof User) {
            List<Room> rooms = hotel.getRooms();

            for(Room curr : rooms) {
                if(curr.getRoomNumber() == room.getRoomNumber()) {
                    if(curr.getBookStatus().equals("RESERVED")) {
                        System.out.println("Room is already reserved for someone else.");
                        return;
                    } else {
                        System.out.println("Not reserved.");
                    }
                }
            }

        } else {
            System.out.println("user is not authorised to see reservation status of a room");
        }
    }

        // Method to rate the hotel
    public void giveFeedback(Hotel hotel, Rating rating) {
        if(rating.getUser() instanceof User) {
            hotel.getRatings().add(rating); // adding rating
            System.out.println(rating.getUser().getUsername() + " has rated "+ hotel.getHotelName() + " "+rating.getStarCount() + "*");
        } else {
            System.out.println("User isn't authorise to rate the hotel");
        }
    }

}

