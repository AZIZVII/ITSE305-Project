package data;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    // A static map to store Account objects using the accountId as the key
    private static Map<String, Account> accounts = new HashMap<>();

    // Method to save a new account in the accounts map , It accepts accountId, name, address, and phone to create a new account
    public boolean saveAccount(String accountId, String name, String address, String phone) {
        // Check if the account ID already exists
        if (accounts.containsKey(accountId)) {
            return false;  // Return false if the ID is already taken
        }

        // Create a new Account object with the provided accountId and user details
        Account account = new Account(accountId, name, address, phone);

        // Store the new account in the map with the accountId as the key
        accounts.put(accountId, account);

        // Return true to indicate successful saving of the account
        return true;
    }

    // Method to delete an existing account from the accounts map, It accepts accountId and returns true if the account is found and deleted
    public boolean deleteAccount(String accountId) {
        // Check if the account exists in the map
        if (accounts.containsKey(accountId)) {
            // Remove the account from the map using the accountId
            accounts.remove(accountId);
            // Return true to indicate successful deletion
            return true;
        }
        // Return false if the account does not exist
        return false;
    }

    // Method to update an existing account's address and phone number, It accepts the accountId, new address, and new phone number
    public boolean updateAccount(String accountId, String address, String phone) {
        // Retrieve the account from the map using the accountId
        Account account = accounts.get(accountId);

        // If the account exists, update the address and phone number
        if (account != null) {
            account.setAddress(address);
            account.setPhone(phone);
            // Return true to indicate successful update
            return true;
        }
        // Return false if the account does not exist
        return false;
    }

    // Method to get the details of a specific account, It accepts accountId and returns the account details as a string (via toString method)
    public String getAccountDetails(String accountId) {
        // Retrieve the account from the map using the accountId
        Account account = accounts.get(accountId);

        // If the account exists, return its details using the toString method
        if (account != null) {
            return account.toString();
        }
        // Return null if the account does not exist
        return null;
    }
}
