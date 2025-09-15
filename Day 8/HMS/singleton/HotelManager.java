package singleton;

import repository.*;
import users.*;
import model.*;
import java.util.*;

// This class is responsible for all kind of hotel related functions
public class HotelManager {
    private HotelCatalog hotelCatalog;
    private static HotelManager instance; // single instance

    // constructor
    public HotelManager() {
        this.hotelCatalog = new HotelCatalog();
    }

    // function that will create single instance of hotel manager
    public static HotelManager getInstance() {
        if(instance == null) {
            instance = new HotelManager();
        }

        return instance;
    }

    // Method to add hotel in the site
    public void addHotel(Hotel hotel, User user, User action) {
        if(user instanceof HotelAgent) {
            if(approveRequest(hotel, "ADD", action)) {  // if got approval from administrator
                hotelCatalog.getHotel().add(hotel);
                System.out.println(hotel.getHotelName() + " Hotel Added in the catalog.");
            } else {
                System.out.println("Waiting for administrator approval to add hotel in catalog.");
            }
        }
    }


    // Method to delete hotel from site
    public void deleteHotel(Hotel hotel, User user) {
        if(user instanceof Administrator) {
            if(hotelCatalog.getHotel().contains(hotel)) {
                hotelCatalog.getHotel().remove(hotel);
                System.out.println(hotel.getHotelName() +" Hotel deleted from the catalog.");
            } else {
                System.out.println("Not able to find intended hotel to delete");
            }
        }
    }

    // Method to approve request to add hotel in site
    public boolean approveRequest(Hotel hotel, String requestType, User user) {
        if(requestType.equals("ADD") && user instanceof Administrator) {
            System.out.println("Request approved");
            return true;
        } else if(requestType.equals("UPDATE") && user instanceof Administrator){
            System.out.println("Approved update request");
            return true;
        }

        return false;
    }

    // Method to search for hotels in the site by name
    public void getHotelByName(Hotel hotel, User user) {
        if(user instanceof User) {
            if(hotelCatalog.getHotel().contains(hotel)) {
                List<Hotel> hotels = hotelCatalog.getHotel();
                for(Hotel curr : hotels) {
                    if(curr.getHotelName().equals(hotel.getHotelName())) {
                        System.out.println(curr.getHotelName()+ " Hotel is found.");
                        return;
                    }
                }

                System.out.println("No details found with "+ hotel.getHotelName() + "name");
            }
        } else {
            System.out.println("User is not authorised to perform search.");
        }
    }

    // Method to update Hotel details -> in this i am updating hotel name
    public void updateDetails(Hotel hotel, User user, String name, User action) {
        if(user instanceof HotelAgent) {
           List<Hotel> hotels = hotelCatalog.getHotel();

           // checking for all
           for(Hotel curr : hotels) {
            if(curr.getHotelName().equals(hotel.getHotelName())) {
                if(approveRequest(hotel, "UPDATE", action)) {
                    curr.setHotelName(name);
                    System.out.println("Hotel information updated.");
                    return;
                } else {
                    System.out.println("Waiting for administrator approval");
                }
            }
           }
        } else {
            System.out.println("User is not authorised to update information.");
        }
    }
}
