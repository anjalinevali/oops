import java.util.ArrayList;

abstract class BankAccount {

    private String accountNumber;
    protected double balance;
    protected ArrayList<String> transactionHistory = new ArrayList<>();

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactionHistory.add("Account created with balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract method (Polymorphism)
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public void showTransactions() {
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}
