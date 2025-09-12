package model;

import model.user.*;

public class Brick {
    private int brickId;
    public User dedicatedTo;
    public String message;
    public String caption;

    public Brick(int brickId, User user, String message, String caption) {
        this.brickId = brickId;
        this.dedicatedTo = user;
        this.message = message;
        this.caption = caption;
    }

    // getter for brick id
    public int getBrickId() {
        return this.brickId;
    }

    // setter for brick id
    public void setBrickId(int brickId) {
        this.brickId = brickId;
    }
}
