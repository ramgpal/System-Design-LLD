package model;

import java.util.*;
import statusformat.*;

// class contains user information
public class User {

    // class variables
    private String mobileNumber;
    private String name;
    private List<Contact> contacts; // list of all contacts 
    private List<Status> statuses; // list of all statuses visible to a user

    // constructor
    public User(String mobileNumber, String name) {
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.contacts = new ArrayList<>();
        this.statuses = new ArrayList<>();
    }

    // getter for mobileNumber
    public String getMobileNumber() {
        return this.mobileNumber;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

    // getter for contacts
    public List<Contact> getContacts() {
        return this.contacts;
    }

    // getter for Statuses
    public List<Status> getStatuses() {
        return statuses;
    }
}
