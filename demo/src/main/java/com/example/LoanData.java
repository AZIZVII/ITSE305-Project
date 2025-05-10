package com.example;
import java.util.HashMap;
import java.util.Map;

public class LoanData {
    Map<String, String> loanStatusMap; 
    Map<String, Double> repaymentsMap;

    public LoanData() {
        this.loanStatusMap = new HashMap<>();
        this.repaymentsMap = new HashMap<>();
    }

    public void addLoanApplication(String name, String loanType, double amount) {
        loanStatusMap.put(name, "Pending");
    }

    public String getLoanStatus(String name) {
        return loanStatusMap.getOrDefault(name, "Not Found");
    }

    public void addRepayment(String name, double amount) {
        repaymentsMap.put(name, repaymentsMap.getOrDefault(name, 0.0) + amount);
    }

    public void updateLoanStatus(String name, String status) {
        loanStatusMap.put(name, status);
    }
}