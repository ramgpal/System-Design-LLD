package model;

import java.util.*;
import model.notes.*;

public class Inventory {
    private List<Notes> notes;

    // constructor
    public Inventory() {
        this.notes = new ArrayList<>();
    }

    
    // getter
    public List<Notes> getNotes() {
        return notes;
    }
}
