
// Business Layer: Handles logic for managing staff
import java.util.ArrayList;
import java.util.List;

public class StaffManagement {
    private List<Staff> staffList = new ArrayList<>();
    private List<String> auditLogs = new ArrayList<>();

    public void addStaff(String id, String name, String role) {
        staffList.add(new Staff(id, name, role));
        auditLogs.add("Added staff: " + name + " (" + id + ") as " + role);
    }

    public boolean removeStaff(String id) {
        boolean removed = staffList.removeIf(staff -> staff.getId().equals(id));
        if (removed)
            auditLogs.add("Removed staff with ID: " + id);
        return removed;
    }

    public boolean assignRole(String id, String newRole) {
        for (Staff staff : staffList) {
            if (staff.getId().equals(id)) {
                staff.setRole(newRole);
                auditLogs.add("Assigned new role to " + staff.getName() + ": " + newRole);
                return true;
            }
        }
        return false;
    }

    public void viewPerformance() {
        System.out.println("Staff Performance Report:");
        for (Staff staff : staffList) {
            System.out.println(
                    staff.getName() + " (" + staff.getRole() + ") - Performance Score: " + staff.getPerformanceScore());
        }
    }

    public void viewAuditLogs() {
        System.out.println("Audit Logs:");
        for (String log : auditLogs) {
            System.out.println(log);
        }
    }
}
