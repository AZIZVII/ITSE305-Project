package com.bank;

import java.util.Scanner;

// Class responsible for managing account-related operations such as create, close, update, and view accounts.
public class AccountManagementApp {

    private AccountService accountService; // Instance of AccountService to perform account operations
    private Scanner scanner; // Scanner to take user input from the console

    // Constructor to initialize the AccountService and Scanner objects
    public AccountManagementApp() {
        this.accountService = new AccountService(); // Initialize AccountService
        this.scanner = new Scanner(System.in); // Initialize scanner for user input
    }

    // Main method to start the application
    public static void main(String[] args) {
        AccountManagementApp app = new AccountManagementApp(); // Create an instance of the app
        app.run(); // Run the app to start the account management system
    }

    // Method to continuously show the main menu and execute the selected option
    private void run() {
        while (true) {
            // Display menu to the user
            System.out.println("Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Update Account");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Read user choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Switch to handle user input based on the option chosen
            switch (choice) {
                case 1:
                    createAccount(); // Call createAccount method
                    break;
                case 2:
                    closeAccount(); // Call closeAccount method
                    break;
                case 3:
                    updateAccount(); // Call updateAccount method
                    break;
                case 4:
                    viewAccountDetails(); // Call viewAccountDetails method
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return; // Exit the program
                default:
                    System.out.println("Invalid option. Try again."); // Handle invalid choice
            }
        }
    }

    // Method to create a new account by taking user input for the account details
    private void createAccount() {
        System.out.print("Enter Account ID: ");
        String accountId = scanner.nextLine(); // Read account ID
        System.out.print("Enter Name: ");
        String name = scanner.nextLine(); // Read account holder's name
        System.out.print("Enter Address: ");
        String address = scanner.nextLine(); // Read account holder's address
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine(); // Read account holder's phone number

        // Call AccountService to create the account and provide feedback to the user
        if (accountService.createAccount(accountId, name, address, phone)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account creation failed. The Account ID may already exist.");
        }
    }

    // Method to close an account by taking the account ID
    private void closeAccount() {
        System.out.print("Enter Account ID to close: ");
        String accountId = scanner.nextLine(); // Read account ID

        // Call AccountService to close the account and provide feedback to the user
        if (accountService.closeAccount(accountId)) {
            System.out.println("Account closed successfully.");
        } else {
            System.out.println("Failed to close account. Account not found.");
        }
    }

    // Method to update account details by taking the account ID and new details (address and phone)
    private void updateAccount() {
        System.out.print("Enter Account ID to update: ");
        String accountId = scanner.nextLine(); // Read account ID
        System.out.print("Enter new Address: ");
        String address = scanner.nextLine(); // Read new address
        System.out.print("Enter new Phone: ");
        String phone = scanner.nextLine(); // Read new phone number

        // Call AccountService to update the account and provide feedback to the user
        if (accountService.updateAccount(accountId, address, phone)) {
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("Failed to update account. Account not found.");
        }
    }

    // Method to view account details by taking the account ID
    private void viewAccountDetails() {
        System.out.print("Enter Account ID to view details: ");
        String accountId = scanner.nextLine(); // Read account ID

        // Call AccountService to get account details and provide feedback to the user
        String accountDetails = accountService.viewAccountDetails(accountId);
        if (accountDetails != null) {
            System.out.println("Account Details: " + accountDetails); // Display account details
        } else {
            System.out.println("Account not found."); // Account does not exist
        }
    }
}
