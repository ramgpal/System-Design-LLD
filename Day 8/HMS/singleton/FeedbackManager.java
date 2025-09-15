package singleton;

import model.*;
import users.*;

public class FeedbackManager{
    private static FeedbackManager instance; // single instance

    // constructor
    private FeedbackManager() {
    }

    // 1. function that will create or get single instance of hotel manager
    public static FeedbackManager getInstance() {
        // if not created
        if(instance == null) {
            instance = new FeedbackManager();
        }

        return instance;
    }

    // 2. Method to rate the hotel -> I have rated based on count of start
    public void giveFeedback(Hotel hotel, Rating rating) {
        if(rating.getUser() instanceof User) {
            hotel.getRatings().add(rating); // adding rating
            System.out.println(rating.getUser().getUsername() + " has rated "+ hotel.getHotelName() + " "+rating.getStarCount() + "*");
        } else {
            System.out.println("User isn't authorise to rate the hotel");
        }
    }
}