package edu.ukd.oopclass;

import java.util.ArrayList;

/**
 * The Bank class manages a collection of bank accounts.
 */
public class Bank {
    private ArrayList<BankAccount> allAccounts = new ArrayList<>();

    /**
     * Adds a new bank account to the bank.
     * @param account the account to be added
     */
    public void addAccount(BankAccount account) {
        allAccounts.add(account);
    }

    /**
     * Removes a bank account from the bank.
     * @param account the BankAccount to be removed
     */
    public void removeAccount(BankAccount account) {
        allAccounts.remove(account);
    }

    /**
     * Finds an account by account number.
     * @param accountNumber the account number to search for
     * @return the BankAccount if found, otherwise null
     */
    public BankAccount findAccountByNumber(String accountNumber) {
        for (BankAccount account : allAccounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }
}
