class Calculator {

    // Method 1: Add two integers
    int add(int a, int b) {
        return a + b;
    }

    // Method 2: Add two double values
    double add(double a, double b) {
        return a + b;
    }

    // Method 3: Add three integers
    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Add two integers: " + calc.add(10, 20));
        System.out.println("Add two doubles: " + calc.add(5.5, 2.3));
        System.out.println("Add three integers: " + calc.add(1, 2, 3));
    }
}


