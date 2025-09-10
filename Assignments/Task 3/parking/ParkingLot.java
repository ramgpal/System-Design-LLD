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

    public void addFloor(ParkingFloor floor) { 
        floors.add(floor); 
    }

    public void removeFloor(ParkingFloor floor) { 
        floors.remove(floor); 
    }

    public int getCapacity() { 
        return capacity; 
    }
}