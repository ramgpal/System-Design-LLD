package user;

import model.*;

public class Member extends SystemUser {
    private int totalBooksCheckedOut;

    // constructor
    public Member(String name, String email, String phone, Account account) {
        super(name, email, phone, account);
        this.totalBooksCheckedOut = 0;
    }

    // getter for total checkout
    public int getTotalBooksCheckedOut() { 
        return totalBooksCheckedOut; 
    }
}
