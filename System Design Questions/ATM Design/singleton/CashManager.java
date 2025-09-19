package singleton;

import java.util.*;
import model.*;
import model.notes.*;
import model.user.*;

public class CashManager {
    private static CashManager instance;

    private CashManager() {
    }

    public static CashManager getInstance() {
        if (instance == null) {
            instance = new CashManager();
        }
        return instance;
    }



    // total available cash in atm
    public String totalCash(Inventory atm, User user) {
        if(user instanceof CashOperator) {
            int total = 0;
            List<Notes> notes = atm.getNotes();
            for(Notes note : notes) {
                total += note.getCount() * note.getValue();
            }

            return "Total Available cash in ATM is: "+ total;
        }

        return "User is not authorised to check the cash";
    }


    // Withdraw cash -> Customer will do
    public void withdrawCash(Inventory atm, int amount, User user) {
        if (!(user instanceof Customer)) {
            System.out.println("Only bank customers are allowed to withdraw cash");
            return;
        } else {
            List<Notes> notes = atm.getNotes();
            int originalAmount = amount;
            Map<Notes, Integer> notesToDispense = new HashMap<>();

            for (Notes note : notes) {
                int val = note.getValue();
                int availableCounts = note.getCount();
                int needed = amount / val;
                int toDispense = Math.min(needed, availableCounts);

                if (toDispense > 0) {
                    notesToDispense.put(note, toDispense);
                    amount -= toDispense * val;
                }
            }

            if (amount > 0) {
                System.out.println("Balance is insufficient or denominations not available");
                return;
            }

            // Dispense notes and update ATM inventory
            for (Map.Entry<Notes, Integer> entry : notesToDispense.entrySet()) {
                Notes note = entry.getKey();
                int count = entry.getValue();
                note.setCount(note.getCount() - count);
            }

            System.out.println("Amount Withdrawn: " + originalAmount);
        }
    }


    // Top- up the atm
    public void topUp(Inventory atm, User user, List<Notes> notes) {
        if(user instanceof CashOperator) {
                for(Notes note : notes) {
                atm.getNotes().add(note);
            }
        }

    }

}
