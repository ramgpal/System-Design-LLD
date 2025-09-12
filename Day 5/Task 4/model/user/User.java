package model.user;

public class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

    //  getter for userId
    public int getId() {
        return this.userId;
    }
    
    // setter
    public void setName(String name) {
        this.name = name;
    }
}
