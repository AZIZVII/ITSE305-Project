package com.example;
public class LoanBusiness {
    public LoanData loanData; // data layer object to manage loan data

    // a constructor that initialze the loan data object  
    public LoanBusiness() {
        this.loanData = new LoanData();
        
    }

    // it manages the storing of data that comes from presentation layer to the data layer
    public void applyForLoan(String name, String loanType, double amount) {
        loanData.addLoanApplication(name, loanType, amount);
    }

    // it manages retriving the data from the data layer 
    public String getLoanStatus(String name) {
        return loanData.getLoanStatus(name);
    }

    // it manages updating the repeyment details to the data layer
    public void repayLoan(String name, double amount) {
        loanData.addRepayment(name, amount);
    }

    // it manages updating loan status to the data layer
    public void approveLoan(String staffId, String name, boolean isApproved) {
        loanData.updateLoanStatus(name, isApproved ? "Approved" : "Rejected");
    }
}