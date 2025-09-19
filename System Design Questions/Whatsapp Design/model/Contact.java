package model;

import java.time.LocalDate;

// contact class
public class Contact {
    private User user;
    private boolean isBlocked;
    private LocalDate addedOn;

    // constructor
    public Contact(User user, boolean isBlocked, LocalDate addedOn) {
        this.user = user;
        this.isBlocked = isBlocked;
        this.addedOn = addedOn;
    }

    // getter for user
    public User getUser() { 
        return user; 
    }

    // getter for block status
    public boolean  getIsBlocked() { 
        return this.isBlocked; 
    }

    // getter for addedOn
    public LocalDate getAddOn() {
        return this.addedOn;
    }
}
