package edu.ukd.oopclass;

import java.util.Scanner;

/**
 * The BankMenu class provides an interactive menu for users to manage bank accounts.
 */
public class BankMenu {
    private final Bank bank = new Bank();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Starts the banking system menu and handles user input.
     */
    public void start() {
        while (true) {
            System.out.println("\nSUPER-PUPER BANK");
            System.out.println("1. Create account");
            System.out.println("2. Delete account");
            System.out.println("3. Find account by number");
            System.out.println("4. Change owner's name");
            System.out.println("5. Deposit to account");
            System.out.println("6. Withdraw from account");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice  = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> removeAccount();
                case 3 -> searchAccount();
                case 4 -> changeOwnerName();
                case 5 -> depositToAccount();
                case 6 -> withdrawFromAccount();
                case 7 -> {
                    System.out.println("Thank you for using SUPER-PUPER banking system!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter owner's name: ");
        String ownerName = getValidOwnerName();
        System.out.print("Enter initial balance: ");
        double balance = getValidDouble();
        BankAccount account = new BankAccount(ownerName, balance);
        bank.addAccount(account);
        System.out.println("✅ Account created successfully.\n"+account);
    }

    private String getValidOwnerName() {
        while (true) {
            String input = scanner.nextLine();
            if (input.length() >= 3) {
                return input;
            } else {
                System.out.print("Owner name must be at least 3 characters long. Please enter a valid name: ");
            }
        }
    }

    private double getValidDouble() {
        while (true) {
            String input = scanner.nextLine().trim();
            // regular expression check - only allows positive numbers
            if (input.matches("\\d+(\\.\\d{1,2})?")) {
                double amount = Double.parseDouble(input);
                if (amount >= 0.01) {
                    return amount;
                } else {
                    System.out.print("Invalid input! Please input minimum $0.01: ");
                }
            } else {
                System.out.print("Invalid input! Please enter a valid number in format $0.00: ");
            }
        }
    }

    private BankAccount getAccountByNumber() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        BankAccount account = bank.findAccountByNumber(accountNumber);
        if (account==null) {
            System.out.println("⛔️ Account not found.");  // Replaces repeated logic
        }
        return account;  // Returns account or null if not found
    }

    private void removeAccount() {
        BankAccount account = getAccountByNumber();

        if (account != null) {
            bank.removeAccount(account);
            System.out.println("✅ Account removed successfully!");
        }
    }

    private void searchAccount() {
        BankAccount foundAccount = getAccountByNumber();
        if (foundAccount != null) {
            System.out.println("✅ Account found\n" + foundAccount);
        }
    }

    private void changeOwnerName() {
        BankAccount account = getAccountByNumber();

        if (account != null) {
            System.out.print("Enter new owner's name: ");
            String newOwnerName = getValidOwnerName();
            account.setOwnerName(newOwnerName);
            System.out.println("✅ Owner's name updated successfully.");
        }
    }

    private void depositToAccount() {
        BankAccount account = getAccountByNumber();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = getValidDouble();

            account.deposit(amount);
            System.out.println("✅ Deposit successful!\n" + account);
        }
    }

    private void withdrawFromAccount() {
        BankAccount account = getAccountByNumber();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = getValidDouble();
            try {
                account.withdraw(amount);
                System.out.println("✅ Withdrawal successful!\n" + account);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
