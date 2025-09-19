package model.user;

// class that has a power to changer or replace the notes
public class Government extends User{
    private int governmentId;
    public Government(String name, int governmentId) {
        super(name);
        this.governmentId = governmentId;
    }
}
