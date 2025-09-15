package singleton;

import java.time.*;
import java.util.*;
import model.*;
import statusformat.*;

public class StatusManager {
    private static StatusManager instance;

    private StatusManager() {
    }

    // singleton
    public static StatusManager getInstance() {
        if (instance == null) {
            instance = new StatusManager();
        }
        
        return instance;
    }

    // Method to put a status
    public void postStatus(User user, Status status) {
        if(status instanceof TextStatus) {
            user.getStatuses().add(status);
            System.out.println("Text status addedd successfully: "+ status);
        } else if(status instanceof ImageStatus) {
            user.getStatuses().add(status);
            System.out.println("Image status addedd successfully: "+ status);
        } else {
            System.out.println("Invalid status format");
        }
    }

    // View all statuses of a specific user
    public void viewStatuses(User user) {
        List<Status> statuses = user.getStatuses();

        if(statuses.isEmpty()) {
            System.out.println("No status available.");
        } else {

            // iterating the all statuses available
            for(Status st : statuses) {
                st.showStatus();
            }
        }


    }

    // View statuses of all contacts of a user
    public void viewContactsStatuses(User user) {
        List<Contact> contacts = user.getContacts();

        if(contacts.isEmpty()) {
            System.out.println("No contacts available.");
        }

        for(Contact curr : contacts) {
            User currUser = curr.getUser();
            viewStatuses(currUser);
        }

    }

    // Method to remove a status after 24hrs
    public void removeStatus(User user) {
        List<Status> statuses = user.getStatuses();
        
        if (statuses.size() == 0) {
            System.out.println("No status available.");
            return;
        }

        LocalDateTime now = LocalDateTime.now();

        // Using iterator to iterate list
        Iterator<Status> iterator = statuses.iterator();
        while (iterator.hasNext()) {
            Status st = iterator.next();

            // Convert Date to LocalDateTime
            LocalDateTime statusTime = st.getTimestamp().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            // Remove if older than 24 hours
            if (Duration.between(statusTime, now).toHours() >= 24) {
                iterator.remove();
            }
        }

        System.out.println("All statuses removed successfully, having for more than 24hrs time.");
    }
}

