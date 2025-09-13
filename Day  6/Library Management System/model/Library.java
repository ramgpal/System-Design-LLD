package model;

import java.util.*;
import user.*;

public class Library {

    // fields
    private String name;
    private String address;
    private List<BookItem> books;
    private List<Member> members;
    private List<Librarian> librarians;
    private List<BookLending> lendedOrReservedBooks;

    // constructor
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.lendedOrReservedBooks = new ArrayList<>();
    }

    // getter for books
    public List<BookItem> getBooks() { 
        return books; 
    }

    // getter for members
    public List<Member> getMembers() { 
        return members; 
    }

    // // getter for Librarians
    public List<Librarian> getLibrarians() { 
        return librarians; 
    }

    // getter for name
    public String getName() { 
        return name; 
    }

    // getter for address
    public String getAddress() { 
        return address; 
    }

    // getter for lendedOrReservedBooks
    public List<BookLending> getLendedOrReservedBooks() {
        return this.lendedOrReservedBooks;
    }
}
