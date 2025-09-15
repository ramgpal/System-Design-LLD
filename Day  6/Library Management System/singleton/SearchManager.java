package singleton;

import java.util.*;
import model.*;
import user.*;

public class SearchManager {
    private static SearchManager instance;

    private SearchManager() {

    }

     // Method that will create single instance
    public static SearchManager getInstance() {
        if(instance == null) {
            instance = new SearchManager();
        }

        return instance;
    }
    
    // search the book by title
    public List<BookItem> getBookByTitle(Library lib, String title) {
        List<BookItem> ans = new ArrayList<>();
        List<BookItem> books = lib.getBooks();

        for (BookItem book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                ans.add(book);
            }
        }

        return ans;
    }

     // search the book by author name
    public List<BookItem> getBookByAuthor(Library lib, Author author) {
        List<BookItem> result = new ArrayList<>();
        List<BookItem> books = lib.getBooks();

        for (BookItem book : books) {
            if (book.getAuthors().contains(author)) {
                result.add(book);
            }
        }

        return result;
    }

     // search the book by PublicationDate
    public List<BookItem> getBookByPublicationDate(Library lib, Date date) {
        List<BookItem> result = new ArrayList<>();
        List<BookItem> books = lib.getBooks();

        for (BookItem book : books) {
            if (book.getPublicationDate().equals(date)) {
                result.add(book);
            }
        }
        
        return result;
    }
}
