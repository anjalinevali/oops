class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        if (balance >= 0)
            this.balance = balance;
        else
            this.balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;
}
class SavingsAccount extends BankAccount {

    public SavingsAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance()) {
            throw new InsufficientBalanceException("Savings Account: Insufficient Balance!");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal Successful (Savings).");
    }
}
class CurrentAccount extends BankAccount {

    private double overdraftLimit = 5000;

    public CurrentAccount(String accNo, double balance) {
        super(accNo, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > getBalance() + overdraftLimit) {
            throw new InsufficientBalanceException("Current Account: Overdraft limit exceeded!");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal Successful (Current).");
    }
}
import java.util.*;

public class BankingApp {

    static HashMap<String, BankAccount> accounts = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount("Savings");
                    break;

                case 2:
                    createAccount("Current");
                    break;

                case 3:
                    depositAmount();
                    break;

                case 4:
                    withdrawAmount();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Option!");
            }
        }
    }

    static void createAccount(String type) {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account;

        if (type.equals("Savings"))
            account = new SavingsAccount(accNo, balance);
        else
            account = new CurrentAccount(accNo, balance);

        accounts.put(accNo, account);
        System.out.println(type + " Account Created Successfully!");
    }

    static void depositAmount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            account.deposit(amt);
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void withdrawAmount() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.print("Enter Amount: ");
            double amt = sc.nextDouble();
            try {
                account.withdraw(amt);
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Account Not Found!");
        }
    }

    static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accNo = sc.next();

        BankAccount account = accounts.get(accNo);
        if (account != null) {
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account Not Found!");
        }
    }
}
