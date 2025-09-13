package model;

import java.util.*;
import model.enums.*;
import user.*;

public class BookItem extends Book {
    private String barcode;
    private Date publicationDate;
    private Rack rackLocation;
    private BookStatus bookStatus;
    private Date issueDate;

    public BookItem(String uniqueIdNumber, String title, List<Author> authors, String barcode, Date publicationDate, Rack rackLocation) {
        super(uniqueIdNumber, title, authors);
        this.barcode = barcode;
        this.publicationDate = publicationDate;
        this.rackLocation = rackLocation;
        this.bookStatus = BookStatus.AVAILABLE;
    }

    public String getBarcode() { 
        return barcode; 
    }
    public Date getPublicationDate() { 
        return publicationDate; 
    }
    public Rack getRackLocation() { 
        return rackLocation; 
    }
    public BookStatus getBookStatus() { 
        return bookStatus; 
    }
    public void setBookStatus(BookStatus status) { 
        this.bookStatus = status; 
    }

    public Date getIssueDate() { 
        return issueDate; 
    }

}
