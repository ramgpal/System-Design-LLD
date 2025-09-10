package panels;

import java.util.*;

public class DisplayBoard {
    private Map<String, Integer> freeSpots = new HashMap<>(); 

    public void update(String spotType, int count) {
        freeSpots.put(spotType, count);
    }

    public Map<String, Integer> showAvailability() {
        return freeSpots;
    }
}