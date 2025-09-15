package messageformat;

import java.util.*;
import model.*;

// message class
public abstract class Message {
    private User sender;
    private User receiver;
    private Date timestamp;

    // constructor
    public Message(User sender, User receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.timestamp = new Date();
    }

    // sender
    public User getSender() { 
        return sender; 
    }

    // receiver
    public User getReceiver() { 
        return receiver; 
    }

    // getter for sending time
    public Date getTimestamp() { 
        return timestamp; 
    }

    // Method for getting message content
    public abstract String getContent();
}

