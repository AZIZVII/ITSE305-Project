package src.main.java;
import java.util.*;

// Data Layer: Manages staff data storage
class Staff {
    private String id;
    private String name;
    private String role;
    private double performanceScore;

    public Staff(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.performanceScore = 0.0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPerformanceScore(double score) {
        this.performanceScore = score;
    }
}

// Business Layer: Handles logic for managing staff
class StaffManagement {
    private List<Staff> staffList = new ArrayList<>();
    private List<String> auditLogs = new ArrayList<>();

    public void addStaff(String id, String name, String role) {
        staffList.add(new Staff(id, name, role));
        auditLogs.add("Added staff: " + name + " (" + id + ") as " + role);
    }

    public void removeStaff(String id) {
        staffList.removeIf(staff -> staff.getId().equals(id));
        auditLogs.add("Removed staff with ID: " + id);
    }

    public void assignRole(String id, String newRole) {
        for (Staff staff : staffList) {
            if (staff.getId().equals(id)) {
                staff.setRole(newRole);
                auditLogs.add("Assigned new role to " + staff.getName() + ": " + newRole);
                return;
            }
        }
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


public void removeStaff(String id) {
    staffList.removeIf(staff -> staff.getId().equals(id));
    auditLogs.add("Removed staff with ID: " + id);

    // Inform the user that the staff was removed
    System.out.println("[INFO] Staff with ID " + id + " was removed.");
}


// Presentation Layer: Provides an interface to interact with staff management
public class AdminPanel {
    public static void main(String[] args) { // Change "AdminPanel" to "main"
        Scanner scanner = new Scanner(System.in);
        StaffManagement manager = new StaffManagement();


        while (true) {
            System.out.println("\nAdmin Panel - Staff Management");
            System.out.println("1. Add Staff");
            System.out.println("2. Remove Staff");
            System.out.println("3. Assign Role");
            System.out.println("4. View Performance");
            System.out.println("5. View Audit Logs");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Staff ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    manager.addStaff(id, name, role);
                    break;
                case 2:
                    System.out.print("Enter Staff ID to Remove: ");
                    id = scanner.nextLine();
                    manager.removeStaff(id);
                    break;
                case 3:
                    System.out.print("Enter Staff ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter New Role: ");
                    role = scanner.nextLine();
                    manager.assignRole(id, role);
                    break;
                case 4:
                    manager.viewPerformance();
                    break;
                case 5:
                    manager.viewAuditLogs();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
