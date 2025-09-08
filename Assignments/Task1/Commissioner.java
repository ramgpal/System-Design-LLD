public class Commissioner {

    private static Commissioner instance;
    private PM pm; 

    private Commissioner(PM pm) {
        this.pm = pm;
    }

    // Dependency Injection via getInstance()
    public static Commissioner getInstance(PM pm) {
        if (instance == null) {
            instance = new Commissioner(pm);
        }
        return instance;
    }

    // logic to determine if an MP can be arrested
    public boolean canArrest(MP mp) {
        if (mp instanceof Minister) {
            Minister minister = (Minister) mp;
            if (minister.exceedsSpendingLimit() && pm.canArrestMinister(minister)) {
                return true;
            }
            return false;
        }

        if (mp.exceedsSpendingLimit()) {
            return true;
        }

        return false;
    }
}
