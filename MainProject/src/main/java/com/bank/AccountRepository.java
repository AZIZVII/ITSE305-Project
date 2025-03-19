package com.bank;
import com.bank.Account;

import java.util.HashMap;
import java.util.Map;

// Repository class responsible for interacting with the data storage (in this case, an in-memory map of accounts)
public class AccountRepository {
    
    // A map to store accounts with accountId as the key and Account as the value
    private Map<String, Account> accounts = new HashMap<>();

    // Method to save a new account to the repository
    // Returns false if the account ID already exists, true otherwise
    public boolean saveAccount(String accountId, String name, String address, String phone) {
        if (accounts.containsKey(accountId)) {
            return false; // Account already exists
        }
        // Create a new Account object and store it in the map
        Account account = new Account(accountId, name, address, phone);
        accounts.put(accountId, account);
        return true; // Account created successfully
    }

    // Method to delete an account from the repository
    // Returns true if the account was successfully deleted, false if the account does not exist
    public boolean deleteAccount(String accountId) {
        if (accounts.containsKey(accountId)) {
            // Remove the account from the map
            accounts.remove(accountId);
            return true;
        }
        return false; // Account not found
    }

    // Method to update an existing account's details (address and phone)
    // Returns true if the account was updated successfully, false if the account does not exist
    public boolean updateAccount(String accountId, String address, String phone) {
        // Retrieve the account by its ID
        Account account = accounts.get(accountId);
        if (account != null) {
            // Create a new Account object with updated details and store it again
            account = new Account(accountId, account.getName(), address, phone);
            accounts.put(accountId, account);
            return true; // Account updated successfully
        }
        return false; // Account not found
    }

    // Method to retrieve account details as a string representation of the account
    // Returns the account details if found, or null if the account does not exist
    public String getAccountDetails(String accountId) {
        // Retrieve the account by its ID
        Account account = accounts.get(accountId);
        // Return the account details as a string if the account exists, otherwise return null
        return (account != null) ? account.toString() : null;
    }
}
