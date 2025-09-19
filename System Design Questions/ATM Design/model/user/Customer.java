package model.user;

public class Customer extends User{
    private String userId;

    public Customer(String name, String userId) {
        super(name);
        this.userId = userId;
    }
}