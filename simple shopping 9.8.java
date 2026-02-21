import java.util.ArrayList;

// Product Class
class Product {
    String name;
    double price;

    // Constructor
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Main Class
public class ShoppingCart {

    public static void main(String[] args) {

        // Create ArrayList to store multiple products
        ArrayList<Product> cart = new ArrayList<>();

        // Create Product objects
        Product p1 = new Product("Mobile", 20000);
        Product p2 = new Product("Headphones", 1500);
        Product p3 = new Product("Charger", 800);

        // Add products to ArrayList
        cart.add(p1);
        cart.add(p2);
        cart.add(p3);

        // Calculate total bill
        double total = 0;

        System.out.println("----- Shopping Cart -----");
        for (Product p : cart) {
            System.out.println("Product: " + p.name + " | Price: ₹" + p.price);
            total += p.price;
        }

        System.out.println("--------------------------");
        System.out.println("Total Bill: ₹" + total);
    }
}

