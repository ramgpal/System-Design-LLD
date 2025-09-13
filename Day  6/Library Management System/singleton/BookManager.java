package singleton;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import model.*;
import model.enums.BookStatus;
import user.*;

// class responsible for managing all operations related to books
public class BookManager {
    private static BookManager instance;

    private BookManager() {

    }

    public static BookManager getInstance() {
        if(instance == null) {
            instance = new BookManager();
        }

        return instance;
    }
    // Method to issue book
    public void issueBook(Library lib, BookItem book, Person user) {
        if(user instanceof SystemUser && lib.getBooks().contains(book)) {
            
            BookLending obj = new BookLending(book, (SystemUser)user, new Date());
            obj.bookStatus = BookStatus.ISSUED;

            lib.getBooks().remove(book); // removing the current item from library
            lib.getLendedOrReservedBooks().add(obj);

            System.out.println("Book is successfully issued to: "+ user.getName());
        } else {
            System.out.println("Not able to issue.");
        }
    }

    // Method to reserve book that is not currently available in the library
    public void reserveBook(Library lib, BookItem book, Person user) {
        if(user instanceof SystemUser) {
            BookLending obj = new BookLending(book, (SystemUser)user, new Date());
            obj.bookStatus = BookStatus.RESERVED;
            lib.getLendedOrReservedBooks().add(obj);

            System.out.println("Book is successfully issued to: "+ user.getName());
        } else {
            System.out.println("User is not authorised");
        }
    }

    // Method to return the book
    public String returnBook(Library lib, BookItem book, Person user) {
        double fineValue = 0;
        if(user instanceof SystemUser) {
        // Fine calculation
        LocalDate issueDate = book.getIssueDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
        long delayInDays = ChronoUnit.DAYS.between(issueDate, LocalDate.now());
        delayInDays -= 10; // allowed delay of max 10 days
        fineValue = delayInDays * 2.0;

        // adding book again in the library
        lib.getBooks().add(book);

        // removing the book from lended list
        for(BookLending bl : lib.getLendedOrReservedBooks()) {
            if(bl.getBookItem().getUniqueIdNumber() == book.getUniqueIdNumber()) {
                lib.getLendedOrReservedBooks().remove(book);
            }
        }
        }

        return fineValue > 0 ? "Book is returned successfully returned, with a fine of Rs "+ fineValue + "." : "Book is returned on time, with no fine.";
    }


    // Method to add a new book in library
    
}