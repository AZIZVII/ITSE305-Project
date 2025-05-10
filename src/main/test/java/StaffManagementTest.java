import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class StaffManagementTest {
    private StaffManagement manager;

    @BeforeEach
    void setUp() {
        manager = new StaffManagement();
    }

    @Test
    void testAddStaff() {
        manager.addStaff("101", "Alice", "Manager");
        List<String> logs = manager.getAuditLogs();
        assertTrue(logs.contains("Added staff: Alice (101) as Manager"));
    }

    @Test
    void testRemoveStaff() {
        manager.addStaff("101", "Alice", "Manager");
        manager.removeStaff("101");
        List<String> logs = manager.getAuditLogs();
        assertTrue(logs.contains("Removed staff with ID: 101"));
    }

    @Test
    void testAssignRole() {
        manager.addStaff("101", "Alice", "Manager");
        manager.assignRole("101", "Director");
        List<String> logs = manager.getAuditLogs();
        assertTrue(logs.contains("Assigned new role to Alice: Director"));
    }
}
