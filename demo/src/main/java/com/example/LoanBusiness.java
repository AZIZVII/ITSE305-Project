package com.example;
public class LoanBusiness {
    LoanData loanData;

    public LoanBusiness() {
        this.loanData = new LoanData();
    }

    public void applyForLoan(String name, String loanType, double amount) {
        loanData.addLoanApplication(name, loanType, amount);
    }

    public String getLoanStatus(String name) {
        return loanData.getLoanStatus(name);
    }
//comment
    public void repayLoan(String name, double amount) {
        loanData.addRepayment(name, amount);
    }

    public void approveLoan(String staffId, String name, boolean isApproved) {
        loanData.updateLoanStatus(name, isApproved ? "Approved" : "Rejected");
    }
}