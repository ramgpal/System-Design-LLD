package statusformat;

import java.util.*;
import model.*;

public abstract class Status {

    // class variables
    private User user;
    private Date timestamp;

    // constructor
    public Status(User user) {
        this.user = user;
        this.timestamp = new Date();
    }

    // getter for user
    public User getUser() {
        return user;
    }

    // getter for status post time
    public Date getTimestamp() {
        return timestamp;
    }

    // abstract Method to show status
    public abstract String showStatus();
}
