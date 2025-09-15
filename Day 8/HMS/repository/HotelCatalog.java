package repository;

import java.util.*;
import model.*;

public class HotelCatalog {
    private List<Hotel> hotels;

    public HotelCatalog() {
        this.hotels = new ArrayList<>();
    }

    // getter for hotels
    public List<Hotel> getHotel() {
        return this.hotels;
    }
}

