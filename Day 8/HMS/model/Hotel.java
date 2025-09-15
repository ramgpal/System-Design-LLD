package model;

import java.util.*;

public class Hotel {

    // Hotel class fields
    private String hotelName;
    private String address;
    private List<Room> rooms;

    // constructor
    public Hotel(String hotelName, String address) {
        this.hotelName = hotelName;
        this.address = address;
        this.rooms = new ArrayList<>();
    }

    // getter for hotelName
    public String getHotelName() {
        return this.hotelName;
    }

    // setter for hotel name
    public void setHotelName(String name) {
        this.hotelName = name;
    }

    // getter for address
    public String getAddress() {
        return this.address;
    }

    // getter for rooms
    public List<Room> getRooms() {
        return this.rooms;
    }
}
