import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {
}
public interface Service {
    void execute();
}
public class OrderService implements Service {

    @LogExecutionTime
    public void placeOrder() {
        try {
            Thread.sleep(500); // simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Order placed successfully.");
    }

    public void cancelOrder() {
        System.out.println("Order cancelled.");
    }

    @Override
    public void execute() {
        placeOrder();
    }
}
public class UserService implements Service {

    @LogExecutionTime
    public void registerUser() {
        try {
            Thread.sleep(300); // simulate processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("User registered successfully.");
    }

    public void deleteUser() {
        System.out.println("User deleted.");
    }

    @Override
    public void execute() {
        registerUser();
    }
}
import java.lang.reflect.Method;

public class MiniFramework {

    public static void process(Object obj) {

        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                try {
                    long startTime = System.currentTimeMillis();

                    method.invoke(obj);

                    long endTime = System.currentTimeMillis();

                    System.out.println("Execution Time of "
                            + method.getName() + " : "
                            + (endTime - startTime) + " ms");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {

        OrderService orderService = new OrderService();
        UserService userService = new UserService();

        System.out.println("Processing OrderService...");
        MiniFramework.process(orderService);

        System.out.println("\nProcessing UserService...");
        MiniFramework.process(userService);
    }
}

