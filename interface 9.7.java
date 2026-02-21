// Interface
interface Shape {
    void calculateArea();
}

// Circle class implementing Shape
class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

// Square class implementing Shape
class Square implements Shape {
    double side;

    Square(double side) {
        this.side = side;
    }

    public void calculateArea() {
        double area = side * side;
        System.out.println("Area of Square: " + area);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Square(4);

        s1.calculateArea();
        s2.calculateArea();
    }
}


