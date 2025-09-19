package repository;

import java.util.*;
import model.*;
import users.*;

// Data Layer to contain data which will processed and modified in managers
public class UserCatalog {
    private Map<User, Room> users;  // list of users and corresponding book room if any

    // constructor
    public UserCatalog() {
        this.users = new HashMap<>();
    }

    // getter for users
    public Map<User, Room> getUsers() {
        return users;
    }
}

