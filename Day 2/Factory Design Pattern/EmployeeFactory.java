public class EmployeeFactory {

    public static Employee getEmployee(String type) {
        if (type.equals("FullTime")) {
            return new FullTimeEmployee();
        } else if (type.equals("PartTime")) {
            return new PartTimeEmployee();
        }
        
        return null;
    }
}
