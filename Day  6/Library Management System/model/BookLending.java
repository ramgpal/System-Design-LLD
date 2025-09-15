package model;

import java.util.*;
import model.enums.*;
import user.*;

public class BookLending {
    protected BookItem book;
    protected SystemUser user;
    protected Date startDate;
    public BookStatus bookStatus;

    // constructor
    public BookLending(BookItem book, SystemUser user, Date startDate) {
        this.book = book;
        this.user = user;
        this.startDate = startDate;
    }

    // getter for book
    public BookItem getBookItem() {
        return book;
    }

    // getter for user
    public SystemUser getUser() {
        return this.user;
    }
}
