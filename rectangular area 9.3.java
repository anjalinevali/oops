class Rectangle {

    // Variables
    double length;
    double width;

    // Constructor to initialize length and width
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Method to calculate the area
    double calculateArea() {
        return length * width;
    }

    public static void main(String[] args) {

        // Creating object of Rectangle
        Rectangle r1 = new Rectangle(8, 4);

        // Calling method
        double area = r1.calculateArea();

        // Display result
        System.out.println("Area of Rectangle: " + area);
    }
}
