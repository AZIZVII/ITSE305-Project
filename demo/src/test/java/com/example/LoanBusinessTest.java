package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoanBusinessTest {
    private LoanBusiness loanBusiness;

    @BeforeEach
    public void setUp() {
        loanBusiness = new LoanBusiness();
    }

    @Test
    public void testApplyForLoan() {
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);
        assertEquals("Pending", loanBusiness.getLoanStatus("Ali"));
    }

    @Test
    public void testGetLoanStatus() {
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);
        assertEquals("Pending", loanBusiness.getLoanStatus("Ali"));
    }

    @Test
    public void testRepayLoan() {
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);
        loanBusiness.repayLoan("Ali", 500.0);
        assertEquals("Pending", loanBusiness.getLoanStatus("Ali"));
    }

    @Test
    public void testApproveLoan() {
        loanBusiness.applyForLoan("Ali", "personal", 2000.0);
        loanBusiness.approveLoan("2020", "Ali", true);
        assertEquals("Approved", loanBusiness.getLoanStatus("Ali"));
    }
}