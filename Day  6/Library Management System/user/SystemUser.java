package user;

import model.*;

public abstract class SystemUser extends Person {
    private String email;
    private String phoneNumber;
    private Account account;

    public SystemUser(String name, String email, String phoneNumber, Account account) {
        super(name);
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public String getEmail() { 
        return email; 
    }

    public String getPhoneNumber() { 
        return phoneNumber; 
    }

    public Account getAccount() { 
        return account; 
    }
}
