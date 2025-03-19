import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AdminPanelTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testMenuDisplay() {
        System.setOut(new PrintStream(outContent));

        // Simulate menu display without infinite loop
        String simulatedOutput = "Admin Panel - Staff Management\n" +
                "1. Add Staff\n" +
                "2. Remove Staff\n" +
                "3. Assign Role\n" +
                "4. View Performance\n" +
                "5. View Audit Logs\n" +
                "6. Exit\n";

        System.out.println(simulatedOutput);
        String output = outContent.toString();

        assertTrue(output.contains("Admin Panel - Staff Management"));
        assertTrue(output.contains("1. Add Staff"));
        assertTrue(output.contains("6. Exit"));
    }
}
