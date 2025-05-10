package com.example;

import java.util.HashMap;
import java.util.Map;

public class LoanData {
    public Map<String, String> loanStatusMap;   // Map to store loan statuses
    public Map<String, Double> repaymentsMap;  // Map to store repayment amounts
    public Map<String, LoanDetails> loanDetailsMap; // Map to store loan details (type and amount)

    public Map<String, Double> getRepaymentsMap() {
        return repaymentsMap;
    }
    // Constructor for initializing the Maps
    public LoanData() {
        this.loanStatusMap = new HashMap<>();
        this.repaymentsMap = new HashMap<>();
        this.loanDetailsMap = new HashMap<>();
    }

    // Stores the name, loan type, and the amount
    public void addLoanApplication(String name, String loanType, double amount) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (loanType == null || loanType.isEmpty()) {
            throw new IllegalArgumentException("Loan type cannot be null or empty");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }

        // Add to loan details and set initial status
        loanDetailsMap.put(name, new LoanDetails(loanType, amount));
        loanStatusMap.put(name, "Pending");
    }

    // Returns the loan status for the given applicant name
    public String getLoanStatus(String name) {
        return loanStatusMap.getOrDefault(name, "Not Found");
    }

    // Updates the repayment for the given applicant name
    public void addRepayment(String name, double amount) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Repayment amount must be greater than zero");
        }

        repaymentsMap.put(name, repaymentsMap.getOrDefault(name, 0.0) + amount);
    }

    // Sets the loan status for the given applicant name
    public void updateLoanStatus(String name, String status) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }

        loanStatusMap.put(name, status);
    }

    // Returns the loan details (type and amount) for the given applicant name
    public LoanDetails getLoanDetails(String name) {
        return loanDetailsMap.getOrDefault(name, null);
    }

    // Inner class to represent loan details
    public static class LoanDetails {
        private String loanType;
        private double amount;

        public LoanDetails(String loanType, double amount) {
            this.loanType = loanType;
            this.amount = amount;
        }

        public String getLoanType() {
            return loanType;
        }

        public double getAmount() {
            return amount;
        }

        @Override
        public String toString() {
            return "LoanDetails{" +
                    "loanType='" + loanType + '\'' +
                    ", amount=" + amount +
                    '}';
        }
    }
}