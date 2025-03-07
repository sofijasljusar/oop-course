package edu.ukd.oopclass;

/**
 * Represents a bank account with an account number, owner name, and balance.
 */
public class BankAccount {
    private final String accountNumber;
    private String ownerName;
    private double balance;

    private static int uniqueNumber = 10000000;

    /**
     * Creates a new bank account with the given owner name and balance.
     * @param ownerName the name of the account owner
     * @param balance the initial balance
     */
    BankAccount(String ownerName, double balance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
    }

    /**
     * Generates a unique account number.
     * @return a unique account number
     */
    private String generateAccountNumber() {
        return "SUPER-PUPER" + uniqueNumber++;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * Deposits a specified amount into the account.
     * @param amount the amount to be deposited
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Withdraws a specified amount from the account if sufficient funds exist.
     * @param amount the amount to be withdrawn
     * @throws IllegalArgumentException if there are insufficient funds
     */
    public void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds. Money not withdrawn.");
        }
        this.balance -= amount;
    }

    /**
     * Returns a string representation of the bank account details.
     */
    public String toString() {
        return String.format("Bank account:\nAccount number - %s\nOwner - %s\nBalance - $%.2f",
                this.accountNumber, this.ownerName, this.balance);
    }
}
