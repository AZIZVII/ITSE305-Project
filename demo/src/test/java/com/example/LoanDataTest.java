package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanDataTest {
    private LoanData loanData;

    @BeforeEach
    public void setUp() {
        loanData = new LoanData();
    }

    @Test
    public void testAddLoanApplication() {
        loanData.addLoanApplication("Ali", "personal", 2000);
        String status = loanData.getLoanStatus("Ali");
        assertEquals("Pending", status);
    }

    @Test
    public void testGetLoanStatusNotFound() {
        String status = loanData.getLoanStatus("NotExist");
        assertEquals("Not Found", status);
    }

    @Test
    public void testAddRepayment() {
        loanData.addRepayment("Ali", 1000);
        loanData.addRepayment("Ali", 500);
        assertEquals(1500.0, loanData.repaymentsMap.get("Ali"));
    }

    @Test
    public void testUpdateLoanStatus() {
        loanData.addLoanApplication("Ali", "personal", 2000);
        loanData.updateLoanStatus("Ali", "Approved");
        String status = loanData.getLoanStatus("Ali");
        assertEquals("Approved", status);
    }
}