class Student {

    // Private variables
    private int id;
    private String name;
    private int marks;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Method to calculate grade
    public char calculateGrade() {
        if (marks >= 90) {
            return 'a';
        } else if (marks >= 75) {
            return 'b';
        } else {
            return 'c';
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {

        // Object creation
        Student student = new Student();

        // Setting values
        student.setId(1);
        student.setName("Rahul");
        student.setMarks(85);

        // Output
        System.out.println("Student: " + student.getName());
        System.out.println("Marks: " + student.getMarks());
        System.out.println("Grade: " + student.calculateGrade());
    }
}
