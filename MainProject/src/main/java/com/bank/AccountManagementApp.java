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

  // Method to display a prompt and get input from the user
private String getInput(String prompt) {
    System.out.print(prompt); // Display the prompt
    return scanner.nextLine(); // Read and return user input
}
    // Method to create a new account by taking user input for the account details
    private void createAccount() {
        String accountId = getInput("Enter Account ID: ");
        String name = getInput("Enter Name: ");
        String address = getInput("Enter Address: ");
        String phone = getInput("Enter Phone: ");
    
        if (accountService.createAccount(accountId, name, address, phone)) {
            System.out.println("Account created successfully.");
        } else {
            System.out.println("Account creation failed. The Account ID may already exist.");
        }
    }

    // Method to close an account by taking the account ID
    private void closeAccount() {
        String accountId = getInput("Enter Account ID to close: ");
    
        if (accountService.closeAccount(accountId)) {
            System.out.println("Account closed successfully.");
        } else {
            System.out.println("Failed to close account. Account not found.");
        }
    }

    // Method to update account details by taking the account ID and new details (address and phone)
    private void updateAccount() {
        String accountId = getInput("Enter Account ID to update: ");
        String address = getInput("Enter new Address: ");
        String phone = getInput("Enter new Phone: ");
    
        if (accountService.updateAccount(accountId, address, phone)) {
            System.out.println("Account updated successfully.");
        } else {
            System.out.println("Failed to update account. Account not found.");
        }
    }

    // Method to view account details by taking the account ID
    private void viewAccountDetails() {
        String accountId = getInput("Enter Account ID to view details: ");
    
        String accountDetails = accountService.viewAccountDetails(accountId);
        if (accountDetails != null) {
            System.out.println("Account Details: " + accountDetails);
        } else {
            System.out.println("Account not found.");
        }
    }
}
