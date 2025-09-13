import java.util.*;

class Library {
    String name;
    String address;
    List<BookItem> books;
}

class Book {
    String uniqueIdNumber;
    String title;
    List<Author> authors;
}

class BookItem extends Book {
    String barcode;
    Date publicationDate;
    Rack rackLocation;
    BookStatus bookStatus;
    Date issueDate;
}

enum BookStatus {
    ISSUED, AVAILABLE, RESERVED, LOST;
}

// to find out exact location of BookItem
class Rack {
    int number;
    String locationId;
}

class Person {
    String name;
}

class Author extends Person{
    List<Book> booksPublished;
}

class SystemUser extends Person {
    String email;
    String phoneNumber;
    Account account;
}

class Member extends SystemUser {
    int totalBookedCheckout;

    // Methods in it
    Search searchService;
    BookIssueService issueService;
}

class Librarian extends SystemUser {
    Search searchService;
    BookIssueService issueService;

    // Methods
    public void addBookItem(BookItem bookItem);
    public BookItem deleteBookItem(String barcode);
    public BookItem editBookItem(BookItem bookItem);
}

class Account{
    String userName;
    String Password;
    int accountId;
}

class Search {
    public List<BookItem> getBookByTitle(String title);
    public List<BookItem> getBookByAuthor(Author author);
    public List<BookItem> getBookByType(BookType bookType);
    public List<BookItem> getBookByPublicationDate(Date date);
}

class BookIssueService {
    FineService fineService;


    // for reservation
    public BookReservationDetail getReservationDetail(BookItem book);
    public void updateReservationDetail(BookItem book);
    public BookReservationDetail reserveBook(BookItem book, SystemUser user);

    // for booking ops
    public BookIssueDetail issueBook(BookItem book, SystemUser user);
    public BookIssueDetail renewBook(BookItem book, SystemUser user);
    public void returnBook(BookItem book, SystemUser user);
}

class BookLending {
    BookItem book;
    Date StartDate;
    SystemUser user;
}

class BookIssueDetail extends BookLending {
    Date dueDate;
}

class BookReservationDetail extends BookLending {
    ReservationStatus reservationStatus;
}

class FineService {
    public Fine calculateFine(BookItem item, SystemUser user, int days);
}

class Fine {
    Date fineDate;
    BookItem book;
    SystemUser user;
    Double fineValue;
}
public class Main {
    public static void main(String[] args) {
        
    }
}