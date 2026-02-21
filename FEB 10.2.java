public interface Product {
    String getName();
    double getPrice();
    String getCategory();
}
public class Electronics implements Product {

    private String name;
    private double price;
    private String brand;

    public Electronics(String name, double price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }

    public String getBrand() {
        return brand;
    }
}
public class Clothing implements Product {

    private String name;
    private double price;
    private String size;

    public Clothing(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }
}
public class Clothing implements Product {

    private String name;
    private double price;
    private String size;

    public Clothing(String name, double price, String size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    public String getSize() {
        return size;
    }
}
public interface DiscountStrategy {
    double applyDiscount(double totalAmount);
}
public class PercentageDiscount implements DiscountStrategy {

    private double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percentage / 100);
    }
}
public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}
import java.util.*;
import java.util.stream.Collectors;

public class Cart {

    private List<Product> products = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public Cart(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    // Calculate total using Streams
    public double calculateTotal() {
        double total = products.stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        return discountStrategy.applyDiscount(total);
    }

    // Bonus: Sort products by price
    public void sortByPrice() {
        products.sort(Comparator.comparing(Product::getPrice));
    }

    public void displayProducts() {
        products.forEach(p ->
                System.out.println(p.getName() + " - " + p.getPrice())
        );
    }
}
public class Main {
    public static void main(String[] args) {

        DiscountStrategy discount = new PercentageDiscount(10);
        Cart cart = new Cart(discount);

        cart.addProduct(new Electronics("Laptop", 60000, "Dell"));
        cart.addProduct(new Clothing("T-Shirt", 1000, "M"));
        cart.addProduct(new Electronics("Mobile", 20000, "Samsung"));

        System.out.println("Products Before Sorting:");
        cart.displayProducts();

        cart.sortByPrice();

        System.out.println("\nProducts After Sorting:");
        cart.displayProducts();

        double total = cart.calculateTotal();
        System.out.println("\nFinal Total after Discount: " + total);
    }
}
