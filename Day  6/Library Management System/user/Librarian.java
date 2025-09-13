package user;

import model.*;

public class Librarian extends SystemUser {
    public Librarian(String name, String email, String phone, Account account) {
        super(name, email, phone, account);
    }
}