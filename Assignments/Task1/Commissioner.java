public class Commissioner {

    public void canArrest(Person person) {
        if (person instanceof Minister) {
            Minister minister = (Minister) person;
            if (PM.allowArrest(minister) && minister.exceedsSpendingLimit()) {
                System.out.println("Arrested");
            } else {
                System.out.println("Commissioner doesn't have PM's permission to arrest the minister.");
            }
        } else if (person instanceof MP) {
            MP mp = (MP) person;
            if (mp.exceedsSpendingLimit()) {
                System.out.println("Arrested by Commissioner.");
            } else {
                System.out.println("is within spending limit.");
            }
        }
    }
}
