public interface PaymentMethod {
    void processPayment(double amount);
}
// UPIPayment.java
public class UPIPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment of ₹" + amount);
        System.out.println("Transaction Successful via UPI");
    }
}
// CreditCardPayment.java
public class CreditCardPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment of ₹" + amount);
        System.out.println("Transaction Successful via Credit Card");
    }
}
// NetBankingPayment.java
public class NetBankingPayment implements PaymentMethod {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Net Banking Payment of ₹" + amount);
        System.out.println("Transaction Successful via Net Banking");
    }
}
// PaymentFactory.java
public class PaymentFactory {

    public static PaymentMethod getPaymentMethod(String type) {

        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("UPI")) {
            return new UPIPayment();
        } else if (type.equalsIgnoreCase("CREDITCARD")) {
            return new CreditCardPayment();
        } else if (type.equalsIgnoreCase("NETBANKING")) {
            return new NetBankingPayment();
        }

        return null;
    }
}
// TransactionLogger.java
import java.time.LocalDateTime;

public class TransactionLogger {

    public static void log(String paymentType, double amount, String status) {
        System.out.println("---- Transaction Log ----");
        System.out.println("Time: " + LocalDateTime.now());
        System.out.println("Payment Type: " + paymentType);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }
}
// TransactionLogger.java
import java.time.LocalDateTime;

public class TransactionLogger {

    public static void log(String paymentType, double amount, String status) {
        System.out.println("---- Transaction Log ----");
        System.out.println("Time: " + LocalDateTime.now());
        System.out.println("Payment Type: " + paymentType);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Status: " + status);
        System.out.println("-------------------------");
    }
}
// PaymentGatewaySimulation.java
public class PaymentGatewaySimulation {

    public static void main(String[] args) {

        String paymentType = "UPI";   // Change to CREDITCARD / NETBANKING
        double amount = 5000.00;

        PaymentMethod payment = PaymentFactory.getPaymentMethod(paymentType);

        if (payment != null) {
            payment.processPayment(amount);
            TransactionLogger.log(paymentType, amount, "SUCCESS");
        } else {
            System.out.println("Invalid Payment Type!");
        }
    }
}
