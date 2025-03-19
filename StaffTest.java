import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffTest {
    private Staff staff;

    @BeforeEach
    void setUp() {
        staff = new Staff("123", "John Doe", "Teller");
    }

    @Test
    void testStaffCreation() {
        assertEquals("123", staff.getId());
        assertEquals("John Doe", staff.getName());
        assertEquals("Teller", staff.getRole());
    }

    @Test
    void testRoleAssignment() {
        staff.setRole("Manager");
        assertEquals("Manager", staff.getRole());
    }
    
    @Test
    void testPerformanceScore() {
        staff.setPerformanceScore(4.5);
        assertEquals(4.5, staff.getPerformanceScore());
    }
}


