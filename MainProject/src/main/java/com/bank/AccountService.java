package com.bank;

public class AccountService {

    // An instance of AccountRepository to interact with the data layer for saving, deleting, updating, and retrieving account details
    private AccountRepository repository = new AccountRepository();

    // Method to create a new account using the AccountRepository's saveAccount method
    // Returns true if the account was created successfully, false if the account ID already exists
    public boolean createAccount(String accountId, String name, String address, String phone) {
        return repository.saveAccount(accountId, name, address, phone);
    }

    // Method to close an existing account by its accountId using the AccountRepository's deleteAccount method
    // Returns true if the account was successfully closed, false if the account doesn't exist
    public boolean closeAccount(String accountId) {
        return repository.deleteAccount(accountId);
    }

    // Method to update an account's address and phone details using the AccountRepository's updateAccount method
    // Returns true if the account was updated successfully, false if the account doesn't exist
    public boolean updateAccount(String accountId, String address, String phone) {
        return repository.updateAccount(accountId, address, phone);
    }

    // Method to retrieve the details of an account by its accountId using the AccountRepository's getAccountDetails method
    // Returns a string containing the account details if the account exists, null if the account doesn't exist
    public String viewAccountDetails(String accountId) {
        return repository.getAccountDetails(accountId);
    }
}
