import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StaffManagementTest {
 
    private StaffManagement manager;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        manager = new StaffManagement();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAddStaff() {
        manager.addStaff("123", "John Doe", "Teller");
        manager.addStaff("456", "Jane Smith", "Manager");

        manager.viewAuditLogs();
        String output = outContent.toString();

        assertTrue(output.contains("Added staff: John Doe (123) as Teller"));
        assertTrue(output.contains("Added staff: Jane Smith (456) as Manager"));
    }

    @Test
    void testRemoveStaff() {
        manager.addStaff("123", "John Doe", "Teller");
        manager.removeStaff("123");

        manager.viewAuditLogs();
        String output = outContent.toString();

        assertTrue(output.contains("Removed staff with ID: 123"));
    }

    @Test
    void testAssignRole() {
        manager.addStaff("123", "John Doe", "Teller");
        manager.assignRole("123", "Manager");

        manager.viewAuditLogs();
        String output = outContent.toString();

        assertTrue(output.contains("Assigned new role to John Doe: Manager"));
    }
}


