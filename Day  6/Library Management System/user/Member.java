package user;

import model.*;

public class Member extends SystemUser {
    private int totalBooksCheckedOut;

    public Member(String name, String email, String phone, Account account) {
        super(name, email, phone, account);
        this.totalBooksCheckedOut = 0;
    }

    public int getTotalBooksCheckedOut() { 
        return totalBooksCheckedOut; 
    }


    public void incrementBooks() { 
        totalBooksCheckedOut++; 
    }

    
    public void decrementBooks() { 
        totalBooksCheckedOut--; 
    }
}
