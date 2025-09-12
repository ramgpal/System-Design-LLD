
import java.util.*;
import model.Inventory;
import model.notes.*;
import model.user.*;
import singleton.*;

public class Main {
    public static void main(String[] args) {
        CashManager manager = CashManager.getInstance();
        Inventory atm = new Inventory();

        List<Notes> topUpValue = new ArrayList<>();
        topUpValue.add(new TwoThousands(2000, 10, false));
        topUpValue.add(new FiveHundreads(500, 7, false));
        topUpValue.add(new TwoHundreads(200, 6, false));
        topUpValue.add(new OneHundreads(100, 20, false));

        System.out.println("---------Topping up the atm-----");
        manager.topUp(atm, new CashOperator("Ram"), topUpValue);
        System.out.println(manager.totalCash(atm, new CashOperator("Ram")));

        System.out.println("---------Withdrawing the money-----");
        manager.withdrawCash(atm, 2000, new Customer("Shyam", "A12"));
        System.out.println(manager.totalCash(atm, new CashOperator("Ram")));
    }
}