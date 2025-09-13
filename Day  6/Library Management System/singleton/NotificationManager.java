package singleton;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;

import model.*;
import user.*;

public class NotificationManager {
    private static NotificationManager instance;

    private NotificationManager() {
        // private constructor
    }

    public static NotificationManager getInstance() {
        if (instance == null) {
            instance = new NotificationManager();
        }
        return instance;
    }

    // Sending notification for overdue books
    public void sendNotificationOnDue(Library lib, Person user) {
        if (user instanceof Librarian) {
            List<BookLending> bookLendings = lib.getLendedOrReservedBooks(); 
            Date today = new Date();
            
            for (BookLending bl : bookLendings) {
                Date issueDate = bl.getBookItem().getIssueDate();
                long diffInMillis = today.getTime() - issueDate.getTime();
                long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis);

                if (diffInDays > 10) {
                    System.out.println("Notification sent to: " + bl.getUser().getName() 
                        + " for overdue book: " + bl.getBookItem().getTitle());
                }
            }
        } else {
            System.out.println("User is not authorized to send notifications.");
        }
    }
}
