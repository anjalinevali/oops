interface Employee {
    double calculateSalary();
    String getDetails();
}
class FullTimeEmployee implements Employee {

    private String name;
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public String getDetails() {
        return "Full Time Employee: " + name;
    }
}
class PartTimeEmployee implements Employee {

    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getDetails() {
        return "Part Time Employee: " + name;
    }
}
class PartTimeEmployee implements Employee {

    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String getDetails() {
        return "Part Time Employee: " + name;
    }
}
public class PayrollSystem {

    public static void main(String[] args) {

        Employee emp1 = new FullTimeEmployee("Anjali", 50000);
        Employee emp2 = new PartTimeEmployee("Ravi", 500, 40);

        Employee[] employees = {emp1, emp2};

        for (Employee emp : employees) {
            System.out.println(emp.getDetails());
            System.out.println("Salary: " + emp.calculateSalary());
            System.out.println("----------------------");
        }
    }
}



