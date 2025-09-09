public class Main {
    public static void main(String[] args) {
        Employee emp = EmployeeFactory.getEmployee("FullTime");
        System.out.println("Full Time Employee Salary: " + emp.calculateSalary());
    }
}