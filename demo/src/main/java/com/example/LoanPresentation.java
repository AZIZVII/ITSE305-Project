package com.example;
import java.util.Scanner;

public class LoanPresentation {
    public LoanBusiness loanBusiness; // business layer object to handle loan services
    public Scanner scanner;

    // Constructor that initializes the loanBusiness and scanner for the userinput
    public LoanPresentation() {
        this.loanBusiness = new LoanBusiness();
        this.scanner = new Scanner(System.in);
    }

    // Constructor for testing (allows dependency injection)
    public LoanPresentation(LoanBusiness loanBusiness, Scanner scanner) {
        this.loanBusiness = loanBusiness;
        this.scanner = scanner;
    }

    //this method display a menu where user can input their choice and the system will process it 
    public void start() {
        while (true) {
            System.out.println("\nChoose Your Loan Service");
            System.out.println("1. Apply for Loan");
            System.out.println("2. View Loan Status");
            System.out.println("3. Repay Loan");
            System.out.println("4. Approve Loan (Staff Only)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
    
            // Ensure valid input is entered (an integer between 1 and 5)
            int choice = -1;
            while (choice < 1 || choice > 5) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (choice < 1 || choice > 5) {
                        System.out.println("Invalid input. Please choose a number between 1 and 5.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // consume invalid input
                }
            }
    
            switch (choice) {
                case 1:
                    applyForLoan();
                    break;
                case 2:
                    viewLoanStatus();
                    break;
                case 3:
                    repayLoan();
                    break;
                case 4:
                    approveLoan();
                    break;
                case 5:
                    System.out.println("Thank you for using Loan Services.");
                    System.exit(0);
                default:
                    // This block is unreachable due to the validation above
                    break;
            }
        }
    }

    // apply for loan method collects user input ( name , loan type and amount ) and submit the loan application
    public void applyForLoan() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter loan type (Personal/Home): ");
        String loanType = scanner.nextLine();
        System.out.print("Enter loan amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        loanBusiness.applyForLoan(name, loanType, amount);
        System.out.println("The Loan application is submitted!");
    }

    // view loan status method collects the user name and displays the status of their loan applicatio
    public void viewLoanStatus() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String status = loanBusiness.getLoanStatus(name);
        System.out.println("Loan Status: " + status);
    }

    //repay loan method Collects the user name and repayment amount, and Confirm the repayment
    public void repayLoan() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter repayment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        loanBusiness.repayLoan(name, amount);
        System.out.println("Repayment successful!");
    }

    //approve loan method collects the staff ID, applicant name, and chose to approve or reject the application, then updates the loan approval.
    public void approveLoan() {
        System.out.print("Enter applicant name: ");
        String name = scanner.nextLine();
    
        boolean isApproved = false;
        while (true) {
            System.out.print("Approve? (true/false): ");
            if (scanner.hasNextBoolean()) {
                isApproved = scanner.nextBoolean();
                scanner.nextLine();  // consume newline character
                break;  // exit the loop if input is valid
            } else {
                System.out.println("Invalid input. Please enter 'true' or 'false'.");
                scanner.nextLine();  // consume invalid input
            }
        }
    
        loanBusiness.approveLoan(name, isApproved);
        System.out.println("Loan approval updated!");
    }
}
