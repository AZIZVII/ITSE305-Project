package data;

public class Account {

    // Private instance variables representing account details
    private String accountId;  // Unique identifier for the account
    private String name;       // Name of the account holder
    private String address;    // Address of the account holder
    private String phone;      // Phone number of the account holder

    // Constructor to initialize the Account object with provided details
    public Account(String accountId, String name, String address, String phone) {
        this.accountId = accountId;  // Set the account ID
        this.name = name;            // Set the account holder's name
        this.address = address;      // Set the address
        this.phone = phone;          // Set the phone number
    }

    // Getter method to retrieve the account ID
    public String getAccountId() {
        return accountId;  // Return the account ID
    }

    // Setter method to update the address of the account holder
    public void setAddress(String address) {
        this.address = address;  // Set the new address
    }

    // Setter method to update the phone number of the account holder
    public void setPhone(String phone) {
        this.phone = phone;  // Set the new phone number
    }

    // Override the toString method to return a formatted string with account details
    @Override
    public String toString() {
        return "Account ID: " + accountId + ", Name: " + name + ", Address: " + address + ", Phone: " + phone;
        // Format and return the account's details as a string
    }
}
