package model;

import java.util.*;
import user.*;

public class Book {
    private String uniqueIdNumber;
    private String title;
    private List<Author> authors;

    // constructor
    public Book(String uniqueIdNumber, String title, List<Author> authors) {
        this.uniqueIdNumber = uniqueIdNumber;
        this.title = title;
        this.authors = authors;
    }

    // getter for getUniqueIdNumber
    public String getUniqueIdNumber() { 
        return uniqueIdNumber; 
    }

    // getter for title
    public String getTitle() { 
        return title; 
    }

    // getter for authors
    public List<Author> getAuthors() { 
        return authors; 
    }
}
