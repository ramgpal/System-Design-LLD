package repository;

import java.util.*;
import model.*;

// Data Layer to contain data which will processed and modified in managers
public class HotelCatalog {
    private List<Hotel> hotels;

    // constructor
    public HotelCatalog() {
        this.hotels = new ArrayList<>();
    }

    // getter for hotels
    public List<Hotel> getHotel() {
        return this.hotels;
    }
}

