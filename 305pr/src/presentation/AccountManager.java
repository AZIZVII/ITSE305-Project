package presentation;

import business.AccountService;
import java.util.Scanner;

public class AccountManager {

    // Create an instance of AccountService to handle account-related operations
    private static AccountService accountService = new AccountService();

    public static void main(String[] args) {
        // Scanner to read user input from the console
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Infinite loop to keep showing the menu until the user chooses to exit
        while (true) {
            // Display the menu options to the user
            System.out.println("Welcome to Account Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Close Account");
            System.out.println("3. Update Account Info");
            System.out.println("4. View Account Details");
            System.out.println("5. Exit");

            // Get the user's choice
            choice = scanner.nextInt();

            // Switch statement to perform the action based on the user's choice
            switch (choice) {
                case 1:
                    createAccount(scanner); // Call method to create an account
                    break;
                case 2:
                    closeAccount(scanner); // Call method to close an account
                    break;
                case 3:
                    updateAccount(scanner); // Call method to update account info
                    break;
                case 4:
                    viewAccountDetails(scanner); // Call method to view account details
                    break;
                case 5:
                    System.out.println("Exiting..."); // Exit message
                    scanner.close(); // Close the scanner before exiting
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }

    // Method to handle account creation
    private static void createAccount(Scanner scanner) {
        System.out.println("Enter desired Account ID:");
        String accountId = scanner.next();  // Get user-provided account ID
        System.out.println("Enter Account Name:");
        String name = scanner.next();
        System.out.println("Enter Address:");
        String address = scanner.next();
        System.out.println("Enter Phone Number:");
        String phone = scanner.next();

        // Call the AccountService to create the account
        boolean success = accountService.createAccount(accountId, name, address, phone);
        if (success) {
            System.out.println("Account created successfully!"); // Success message
        } else {
            System.out.println("Account creation failed. The Account ID may already exist."); // Failure message
        }
    }

    // Method to handle account closure
    private static void closeAccount(Scanner scanner) {
        System.out.println("Enter Account ID to close:");
        String accountId = scanner.next();

        // Call the AccountService to close the account
        boolean success = accountService.closeAccount(accountId);
        if (success) {
            System.out.println("Account closed successfully."); // Success message
        } else {
            System.out.println("Failed to close account."); // Failure message
        }
    }

    // Method to handle updating account details
    private static void updateAccount(Scanner scanner) {
        System.out.println("Enter Account ID to update:");
        String accountId = scanner.next();
        System.out.println("Enter new Address:");
        String address = scanner.next();
        System.out.println("Enter new Phone Number:");
        String phone = scanner.next();

        // Call the AccountService to update the account details
        boolean success = accountService.updateAccount(accountId, address, phone);
        if (success) {
            System.out.println("Account updated successfully!"); // Success message
        } else {
            System.out.println("Failed to update account."); // Failure message
        }
    }

    // Method to handle viewing account details
    private static void viewAccountDetails(Scanner scanner) {
        System.out.println("Enter Account ID to view details:");
        String accountId = scanner.next();

        // Call the AccountService to get account details
        String accountDetails = accountService.viewAccountDetails(accountId);
        if (accountDetails != null) {
            // Display the account details
            System.out.println("Account Details: " + accountDetails);
        } else {
            System.out.println("Account not found."); // Failure message if account is not found
            System.out.println("");
        }
    }
}
