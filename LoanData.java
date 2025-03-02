import java.util.HashMap;
import java.util.Map;

public class LoanData {
    private Map<String, String> loanStatusMap; // map to store loan statues
    private Map<String, Double> repaymentsMap; // map to store repayment amount

    // constructor for initializing the storing of hashMaps for loan status and repayment
    public LoanData() {
        this.loanStatusMap = new HashMap<>();
        this.repaymentsMap = new HashMap<>();
    }

    // stores the name , loan type and the amount
    public void addLoanApplication(String name, String loanType, double amount) {
        loanStatusMap.put(name, "Pending");// it set the status to pending
    }


    //return the loan status for the given applicant name
    public String getLoanStatus(String name) {
        return loanStatusMap.getOrDefault(name, "Not Found");// if the name is not stored in the system it output(not found)
    }

    //update the repayment for the given applicant name
    public void addRepayment(String name, double amount) {
        repaymentsMap.put(name, repaymentsMap.getOrDefault(name, 0.0) + amount);
    }

    //sets the loan status for the given applicant name
    public void updateLoanStatus(String name, String status) {
        loanStatusMap.put(name, status);
    }
}