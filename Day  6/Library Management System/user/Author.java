package user;

import java.util.*;
import model.*;

public class Author extends Person {
    private List<Book> booksPublished;

    // constructor
    public Author(String name) {
        super(name);
        this.booksPublished = booksPublished;
    }

    // getter for books
    public List<Book> getBooksPublished() { 
        return booksPublished; 
    }
}
