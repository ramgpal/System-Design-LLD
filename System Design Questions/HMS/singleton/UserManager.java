package singleton;

import repository.UserCatalog;
import users.*;

// user manager class
public class UserManager {

    // class fields
    private UserCatalog userCatalog;
    private static UserManager instance; // singleton

    // constructor
    private UserManager() {
        this.userCatalog = new UserCatalog();
    }

    // 1. Method to get only single instance
    public static UserManager getInstance() {
        if(instance == null) {
            instance = new UserManager();
        }

        return instance;
    }

    // 2. Method to register user
    public void registerUser(User user) {
        if(userCatalog.getUsers().containsKey(user)) {
            System.out.println("User already exist");
        } else {
            userCatalog.getUsers().put(user, null);
        }
    }

    // 3. deleting user from hotel
    public void deleteUser(User toDelete, User user) {
        if(user instanceof Administrator) {
            if(userCatalog.getUsers().containsKey(toDelete)) {
                userCatalog.getUsers().remove(user);
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("Intended user not found");
            }
        } else {
            System.out.println("user is not authorise to delete user from the system.");
        }
    }

    // 6. Method to update user profie -> i am updating email here
    public void updateProfile(User user, String email) {
        if(user instanceof User || user instanceof HotelAgent) {
            user.setEmail(email);
            System.out.println("Email updated successfully: " + email);
        } else {
            System.out.println("User isn't recognised");
        }
    }
}

