package model;

import users.*;

public class Rating {
    private User user;
    private int startCount;

    // constructor
    public Rating(User user, int startCount) {
        this.user = user;
        this.startCount = startCount;
    }

    // getter for user
    public User getUser() {
        return this.user;
    }

    // getter for startcount
    public int getStarCount() {
        return this.startCount;
    }
}
