package loan;
import java.util.Scanner;

public class LoanPresentation {
    private LoanBusiness loanBusiness; // business layer object to handle loan services
    private Scanner scanner;

    // Constructor that initializes the loanBusiness and scanner for the userinput
    public LoanPresentation() {
        this.loanBusiness = new LoanBusiness();
        this.scanner = new Scanner(System.in);
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
            int choice = scanner.nextInt();
            scanner.nextLine(); 

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
                    System.exit(0);;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }

    // apply for loan method collects user input ( name , loan type and amount ) and submit the loan application
    private void applyForLoan() {
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
    private void viewLoanStatus() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        String status = loanBusiness.getLoanStatus(name);
        System.out.println("Loan Status: " + status);
    }

    //repay loan method Collects the user name and repayment amount, and Confirm the repayment
    private void repayLoan() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter repayment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); 

        loanBusiness.repayLoan(name, amount);
        System.out.println("Repayment successful!");
    }

    //approve loan method collects the staff ID, applicant name, and chose to approve or reject the application, then updates the loan approval.
    private void approveLoan() {
        System.out.print("Enter staff ID: ");
        String staffId = scanner.nextLine();
        System.out.print("Enter applicant name: ");
        String name = scanner.nextLine();
        System.out.print("Approve? (true/false): ");
        boolean isApproved = scanner.nextBoolean();
        scanner.nextLine(); 

        loanBusiness.approveLoan(staffId, name, isApproved);
        System.out.println("Loan approval updated!");
    }
}