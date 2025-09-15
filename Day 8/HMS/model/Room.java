package model;

import enums.*;
import model.*;
import users.*;

// Room class -> contains details of room
public class Room {
    private int roomNumber;
    private BookStatus bookStatus;

    // constructor
    public Room(int roomNumber, BookStatus bookStatus) {
        this.roomNumber = roomNumber;
        this.bookStatus = bookStatus;
    }

    // getter for room number
    public int getRoomNumber() {
        return this.roomNumber;
    }

    // getter for bookStatus
    public BookStatus getBookStatus() {
        return this.bookStatus;
    }

    // setter for book status
    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }
}
