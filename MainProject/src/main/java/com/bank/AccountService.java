package com.bank;

public class AccountService {

    private AccountRepository repository = new AccountRepository();

    public boolean createAccount(String accountId, String name, String address, String phone) {
        boolean result = repository.saveAccount(accountId, name, address, phone);
        if (result) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account creation failed: account ID already exists.");
        }
        return result;
    }

    public boolean closeAccount(String accountId) {
        boolean result = repository.deleteAccount(accountId);
        if (result) {
            System.out.println("Account closed successfully.");
        } else {
            System.out.println("Account closure failed: account not found.");
        }
        return result;
    }

    public boolean updateAccount(String accountId, String address, String phone) {
        boolean result = repository.updateAccount(accountId, address, phone);
        if (result) {
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("Account update failed: account not found.");
        }
        return result;
    }

    public String viewAccountDetails(String accountId) {
        return repository.getAccountDetails(accountId);
    }
}
