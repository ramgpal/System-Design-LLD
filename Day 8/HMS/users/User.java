package users;

public class User {

    // class fields
    private String username;
    private String email;

    // constructor
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // getter for userName
    public String getUsername() { 
        return username; 
    }

    // getter for mail
    public String getEmail() { 
        return email; 
    }
}

