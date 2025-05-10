package com.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    // Create an instance of AccountService to be used for testing
    AccountService accountService = new AccountService();

    // Test for successfully creating an account
    @Test
    void testCreateAccount() {
        // Try creating an account with valid details
        boolean result = accountService.createAccount("123", "John Doe", "123 Main St", "123-456-7890");
        
        // Assert that the account is created successfully
        assertTrue(result, "Account should be created successfully.");
    }

    // Test for creating an account with a duplicate account ID (edge case)
    @Test
    void testCreateAccountDuplicate() {
        // First account creation
        accountService.createAccount("123", "John Doe", "123 Main St", "123-456-7890");

        // Attempt to create another account with the same account ID
        boolean result = accountService.createAccount("123", "Jane Smith", "456 Oak St", "987-654-3210");

        // Assert that account creation should fail due to the duplicate ID
        assertFalse(result, "Account creation should fail for duplicate account ID.");
    }

    // Test for successfully closing an account
    @Test
    void testCloseAccount() {
        // Create an account first
        accountService.createAccount("123", "John Doe", "123 Main St", "123-456-7890");
        
        // Try closing the created account
        boolean result = accountService.closeAccount("123");
        
        // Assert that the account is closed successfully
        assertTrue(result, "Account should be closed successfully.");
    }

    // Test for successfully updating an account
    @Test
    void testUpdateAccount() {
        // Create an account first
        accountService.createAccount("123", "John Doe", "123 Main St", "123-456-7890");

        // Attempt to update the account's address and phone number
        boolean result = accountService.updateAccount("123", "456 Elm St", "987-654-3210");
        
        // Assert that the account is updated successfully
        assertTrue(result, "Account should be updated successfully.");
    }

    // Test for successfully viewing account details
    @Test
    void testViewAccountDetails() {
        // Create an account first
        accountService.createAccount("123", "John Doe", "123 Main St", "123-456-7890");

        // Retrieve account details
        String accountDetails = accountService.viewAccountDetails("123");

        // Assert that account details are not null and contain the account holder's name
        assertNotNull(accountDetails, "Account details should not be null.");
        assertTrue(accountDetails.contains("John Doe"), "Account details should contain the account holder's name.");
    }
}
