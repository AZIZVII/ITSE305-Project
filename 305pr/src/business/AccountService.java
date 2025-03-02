package business;

import data.AccountRepository;

public class AccountService {

    // An instance of AccountRepository to interact with the database/storage layer
    private static AccountRepository accountRepository = new AccountRepository();

    // Method to create a new account with a custom account ID
    public boolean createAccount(String accountId, String name, String address, String phone) {
        // Calling saveAccount from AccountRepository to save the account details
        return accountRepository.saveAccount(accountId, name, address, phone);
    }

    // Method to close an existing account using its account ID
    public boolean closeAccount(String accountId) {
        // Calling deleteAccount from AccountRepository to remove the account
        return accountRepository.deleteAccount(accountId);
    }

    // Method to update an existing account's details such as address and phone
    public boolean updateAccount(String accountId, String address, String phone) {
        // Calling updateAccount from AccountRepository to update account details
        return accountRepository.updateAccount(accountId, address, phone);
    }

    // Method to view the details of an account
    public String viewAccountDetails(String accountId) {
        // Calling getAccountDetails from AccountRepository to retrieve the account details
        return accountRepository.getAccountDetails(accountId);
    }
}
