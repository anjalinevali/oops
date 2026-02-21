// Parent Class
class Employee {
    String name;
    double salary;

    // Constructor
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

// Child Class 1
class Developer extends Employee {

    Developer(String name, double salary) {
        super(name, salary);   // Call parent constructor
    }
}

// Child Class 2
class Manager extends Employee {

    Manager(String name, double salary) {
        super(name, salary);   // Call parent constructor
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        // Create Developer object
        Developer dev = new Developer("Anjali", 50000);
        dev.displayDetails();   // Calling parent method

        System.out.println("----------------");

        // Create Manager object
        Manager mgr = new Manager("Rahul", 80000);
        mgr.displayDetails();   // Calling parent method
    }
}

