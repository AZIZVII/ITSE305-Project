package com.bank;

// Class representing an Account in the banking system
public class Account {
    
    // Instance variables to store account information
    private String accountId; // The unique identifier for the account
    private String name; // The name of the account holder
    private String address; // The address of the account holder
    private String phone; // The phone number of the account holder

    // Constructor to initialize the account object with required details
    public Account(String accountId, String name, String address, String phone) {
        this.accountId = accountId; // Set the account ID
        this.name = name; // Set the account holder's name
        this.address = address; // Set the account holder's address
        this.phone = phone; // Set the account holder's phone number
    }

    // Getter method for account ID
    public String getAccountId() {
        return accountId; // Return the account ID
    }

    // Getter method for account holder's name
    public String getName() {
        return name; // Return the account holder's name
    }

    // Getter method for account holder's address
    public String getAddress() {
        return address; // Return the account holder's address
    }

    // Getter method for account holder's phone number
    public String getPhone() {
        return phone; // Return the account holder's phone number
    }

    // Overridden toString method to represent the account object as a string
    @Override
    public String toString() {
        // Return a string representation of the account, including ID, name, address, and phone
        return "Account ID: " + accountId + ", Name: " + name + ", Address: " + address + ", Phone: " + phone;
    }
}
