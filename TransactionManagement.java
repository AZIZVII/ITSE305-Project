import java.util.*;  // Importing necessary classes from the java.util package for collections like List and ArrayList

// Done by abdulaziz hisham hijris
public class TransactionManagement {

    // Data Layer: Represents the user's account and transaction history
    static class Account {
        private double balance;  // Variable to store the current balance of the account
        private List<String> transactionHistory;  // List to keep track of transaction history (e.g., deposits, withdrawals)

        // Constructor: Initializes an account with a balance of 0 and an empty transaction history
        public Account() {
            this.balance = 0.0;
            this.transactionHistory = new ArrayList<>();
        }

        // Getter method to retrieve the current balance of the account
        public double getBalance() {
            return balance;
        }

        // Method to deposit funds into the account
        public void deposit(double amount) {
            balance += amount;  // Add the deposit amount to the balance
            transactionHistory.add("Deposited: $" + amount);  // Record the deposit in the transaction history
        }

        // Method to withdraw funds from the account
        public boolean withdraw(double amount) {
            if (amount <= balance) {  // Check if there is enough balance to perform the withdrawal
                balance -= amount;  // Subtract the withdrawal amount from the balance
                transactionHistory.add("Withdrew: $" + amount);  // Record the withdrawal in the transaction history
                return true;  // Withdrawal successful
            }
            return false;  // Insufficient funds for withdrawal
        }

        // Method to transfer funds from this account to another account
        public boolean transfer(Account targetAccount, double amount) {
            if (amount <= balance) {  // Check if there is enough balance for the transfer
                balance -= amount;  // Subtract the transfer amount from the balance
                targetAccount.deposit(amount);  // Deposit the amount into the target account
                transactionHistory.add("Transferred: $" + amount);  // Record the transfer in the transaction history
                targetAccount.transactionHistory.add("Received: $" + amount);  // Record the receipt in the target account's history
                return true;  // Transfer successful
            }
            return false;  // Insufficient funds for transfer
        }

        // Method to view the transaction history of the account
        public void viewTransactionHistory() {
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");  // If no transactions, print a message
            } else {
                for (String transaction : transactionHistory) {
                    System.out.println(transaction);  // Print each transaction in the history
                }
            }
        }
    }

    // Business Layer: Handles transaction rules and business logic
    static class TransactionService {

        private static final double WITHDRAWAL_LIMIT = 1000.0;  // Maximum allowed withdrawal amount
        private static final double TRANSFER_LIMIT = 5000.0;  // Maximum allowed transfer amount
        private static final double TRANSACTION_FEE = 2.0;  // A fixed transaction fee applied to withdrawals and transfers

        // Method to check if the withdrawal amount is within the allowed limit
        public boolean checkWithdrawalLimit(double amount) {
            return amount <= WITHDRAWAL_LIMIT;
        }

        // Method to check if the transfer amount is within the allowed limit
        public boolean checkTransferLimit(double amount) {
            return amount <= TRANSFER_LIMIT;
        }

        // Method to apply the transaction fee to a given amount
        public double applyTransactionFee(double amount) {
            return amount + TRANSACTION_FEE;  // Add the fee to the transaction amount
        }

        // Method to process a withdrawal request, checking limits and applying the fee
        public boolean processWithdrawal(Account account, double amount) {
            if (!checkWithdrawalLimit(amount)) {  // Check if the withdrawal exceeds the limit
                System.out.println("Withdrawal amount exceeds the limit.");
                return false;
            }

            double finalAmount = applyTransactionFee(amount);  // Apply the transaction fee to the withdrawal amount
            if (account.withdraw(finalAmount)) {  // Attempt the withdrawal
                System.out.println("Withdrawal successful! Fee applied: $" + TRANSACTION_FEE);
                return true;
            } else {
                System.out.println("Insufficient funds for withdrawal.");  // Insufficient funds for the withdrawal
                return false;
            }
        }

        // Method to process a transfer request, checking limits and applying the fee
        public boolean processTransfer(Account fromAccount, Account toAccount, double amount) {
            if (!checkTransferLimit(amount)) {  // Check if the transfer exceeds the limit
                System.out.println("Transfer amount exceeds the limit.");
                return false;
            }

            double finalAmount = applyTransactionFee(amount);  // Apply the transaction fee to the transfer amount
            if (fromAccount.transfer(toAccount, finalAmount)) {  // Attempt the transfer
                System.out.println("Transfer successful! Fee applied: $" + TRANSACTION_FEE);
                return true;
            } else {
                System.out.println("Insufficient funds for transfer.");  // Insufficient funds for the transfer
                return false;
            }
        }
    }

    // Presentation Layer: Handles user interaction and displays results
    static class UserInterface {

        private static Scanner scanner = new Scanner(System.in);  // Scanner object to read user input
        private Account userAccount;  // The user's account object
        private TransactionService transactionService;  // The service for processing transactions

        // Constructor: Initializes the user account and transaction service
        public UserInterface() {
            this.userAccount = new Account();  // Create a new account for the user
            this.transactionService = new TransactionService();  // Create a new transaction service
        }

        // Method to display the menu and prompt the user for choices
        public void showMenu() {
            while (true) {
                System.out.println("\nTransaction Management System");
                System.out.println("1. Deposit Funds");
                System.out.println("2. Withdraw Funds");
                System.out.println("3. Transfer Funds");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();  // Read user input

                // Switch statement to handle the user's menu choice
                switch (choice) {
                    case 1:
                        depositFunds();
                        break;
                    case 2:
                        withdrawFunds();
                        break;
                    case 3:
                        transferFunds();
                        break;
                    case 4:
                        viewTransactionHistory();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        return;  // Exit the program
                    default:
                        System.out.println("Invalid option. Please try again.");  // Handle invalid choices
                }
            }
        }

        // Method to deposit funds into the user's account
        private void depositFunds() {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();  // Read the deposit amount
            userAccount.deposit(amount);  // Deposit the funds into the account
            System.out.println("Deposit successful!");  // Inform the user of success
        }

        // Method to withdraw funds from the user's account
        private void withdrawFunds() {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();  // Read the withdrawal amount
            transactionService.processWithdrawal(userAccount, amount);  // Process the withdrawal through the service
        }

        // Method to transfer funds from the user's account to another account
        private void transferFunds() {
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();  // Read the transfer amount

            Account targetAccount = new Account();  // Simulate an external account (the recipient)
            transactionService.processTransfer(userAccount, targetAccount, amount);  // Process the transfer
        }

        // Method to view the transaction history of the user's account
        private void viewTransactionHistory() {
            System.out.println("\nTransaction History:");
            userAccount.viewTransactionHistory();  // Display the transaction history
        }
    }

    // The main method: Entry point of the program
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();  // Create a new user interface object
        userInterface.showMenu();  // Show the menu and interact with the user
    }
}
