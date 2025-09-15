package repository;

import java.util.*;
import model.*;
import users.*;

public class UserCatalog {
    private Map<User, Room> users;

    // constructor
    public UserCatalog() {
        this.users = new HashMap<>();
    }

    // getter for users
    public Map<User, Room> getUsers() {
        return users;
    }
}

