package parking;

import java.util.*;
import panels.*;

public class ParkingLot {
    private int capacity;
    private List<ParkingFloor> floors = new ArrayList<>();
    private List<EntrancePanel> entrances = new ArrayList<>();
    private List<ExitPanel> exits = new ArrayList<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    // getters and setters
    public int getCapacity() { 
        return capacity; 
    }

    // getter for list of floors
    public List<ParkingFloor> getFloors() { 
        return floors; 
    }

    // getters for entrances and exits
    public List<EntrancePanel> getEntrances() { 
        return entrances; 
    }

    // getter for exits
    public List<ExitPanel> getExits() { 
        return exits; 
    }
}