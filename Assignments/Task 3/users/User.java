package users;

abstract class User {
    protected String name;
    protected String id;

    // Constructor
    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
}