package model;

import java.util.*;
import model.enums.*;
import user.*;

public class BookItem extends Book {

    // class variables
    private String barcode;
    private Date publicationDate;
    private Rack rackLocation;
    private BookStatus bookStatus;
    private Date issueDate;

    // constructor
    public BookItem(String uniqueIdNumber, String title, List<Author> authors, String barcode, Date publicationDate, Rack rackLocation) {
        super(uniqueIdNumber, title, authors);
        this.barcode = barcode;
        this.publicationDate = publicationDate;
        this.rackLocation = rackLocation;
        this.bookStatus = BookStatus.AVAILABLE;
    }

    // getter for barCode
    public String getBarcode() { 
        return barcode; 
    }

    // getter for publicationDate
    public Date getPublicationDate() { 
        return publicationDate; 
    }

    // getter for Rack location
    public Rack getRackLocation() { 
        return rackLocation; 
    }

    // getter for book status
    public BookStatus getBookStatus() { 
        return bookStatus; 
    }

    // setter for book status 
    public void setBookStatus(BookStatus status) { 
        this.bookStatus = status; 
    }

    // getter for issue date
    public Date getIssueDate() { 
        return issueDate; 
    }

}
