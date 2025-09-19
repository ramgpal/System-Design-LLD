package user;

import model.*;

public abstract class SystemUser extends Person {
    private String email;
    private String phoneNumber;
    private Account account;

    // constructor
    public SystemUser(String name, String email, String phoneNumber, Account account) {
        super(name);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    // getter for email
    public String getEmail() { 
        return email; 
    }

    // getter for phone number
    public String getPhoneNumber() { 
        return phoneNumber; 
    }

    // getter for Account
    public Account getAccount() { 
        return account; 
    }
}
