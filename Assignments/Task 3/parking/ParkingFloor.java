package parking;

import java.util.*;
import models.parkingspot.*;
import panels.*;

public class ParkingFloor {
    private int floorNo;
    private List<ParkingSpot> spots = new ArrayList<>();
    private DisplayBoard displayBoard = new DisplayBoard();

    // Constructor
    public ParkingFloor(int floorNo) {
        this.floorNo = floorNo;
    }

    // Methods to add parking spots
    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
        updateDisplay();
    }

    public void removeSpot(String spotId) {
        spots.removeIf(s -> s.getId().equals(spotId));
        updateDisplay();
    }

    public void updateDisplay() {
        Map<String, Integer> counts = new HashMap<>();
        for (ParkingSpot spot : spots) {
            if (spot.isFree()) {
                counts.put(spot.getType(), counts.getOrDefault(spot.getType(), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            displayBoard.update(entry.getKey(), entry.getValue());
        }
    }

    public DisplayBoard getDisplayBoard() { 
        return displayBoard; 
    }
}
