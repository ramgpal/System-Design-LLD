package user;

import java.util.*;
import model.*;

public class Author extends Person {
    private List<Book> booksPublished;

    public Author(String name) {
        super(name);
        this.booksPublished = booksPublished;
    }

    public List<Book> getBooksPublished() { 
        return booksPublished; 
    }
}
