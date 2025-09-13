package model;

public class Account {
    private String userName;
    private String password;
    private int accountId;

    public Account(String userName, String password, int accountId) {
        this.userName = userName;
        this.password = password;
        this.accountId = accountId;
    }

    public String getUserName() { 
        return userName; 
    }

    public String getPassword() { 
        return password; 
    }

    public int getAccountId() { 
        return accountId; 
    }
}
