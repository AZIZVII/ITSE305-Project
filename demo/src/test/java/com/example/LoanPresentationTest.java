package com.example;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanPresentationTest {
    private LoanPresentation loanPresentation;
    private LoanBusiness loanBusiness;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        loanBusiness = new LoanBusiness();
    }

    @Test
    public void testApplyForLoan() {
        // Mock user input for applyForLoan
        scanner = new Scanner("Ali\npersonal\n2000.0\n");
        loanPresentation = new LoanPresentation(loanBusiness, scanner);

        loanPresentation.applyForLoan();
        assertEquals("Pending", loanBusiness.getLoanStatus("Ali"));
    }

    @Test
    public void testViewLoanStatus() {
        // Add a loan application first
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);

        // Mock user input for viewLoanStatus
        scanner = new Scanner("Ali\n");
        loanPresentation = new LoanPresentation(loanBusiness, scanner);

        loanPresentation.viewLoanStatus();
    }

    @Test
    public void testRepayLoan() {
        // Add a loan application first
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);

        // Mock user input for repayLoan
        scanner = new Scanner("Ali\n500.0\n");
        loanPresentation = new LoanPresentation(loanBusiness, scanner);

        loanPresentation.repayLoan();
    }

    @Test
    public void testApproveLoan() {
        // Add a loan application first
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);

        // Mock user input for approveLoan
        scanner = new Scanner("2020\nAli\ntrue\n");
        loanPresentation = new LoanPresentation(loanBusiness, scanner);

        loanPresentation.approveLoan();
        assertEquals("Approved", loanBusiness.getLoanStatus("Ali"));
    }
}