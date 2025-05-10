import java.util.*;

// Presentation Layer: Provides an interface to interact with staff management
public class AdminPanel {
    public static void main(String[] args) {
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

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Staff ID: ");
                        String id = scanner.nextLine().trim();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter Role: ");
                        String role = scanner.nextLine().trim();

                        if (id.isEmpty() || name.isEmpty() || role.isEmpty()) {
                            System.out.println("Error: ID, Name, and Role must not be empty.");
                        } else {
                            manager.addStaff(id, name, role);
                            System.out.println("Staff added successfully.");
                        }

                        break;
                    case 2:
                        System.out.print("Enter Staff ID to Remove: ");
                        id = scanner.nextLine().trim();
                        if (!manager.removeStaff(id)) {
                            System.out.println("Staff ID not found.");
                        } else {
                            System.out.println("Staff removed successfully.");
                        }

                        break;
                    case 3:
                        System.out.print("Enter Staff ID: ");
                        id = scanner.nextLine().trim();
                        System.out.print("Enter New Role: ");
                        role = scanner.nextLine().trim();

                        if (!manager.assignRole(id, role)) {
                            System.out.println("Staff ID not found.");
                        } else {
                            System.out.println("Role assigned successfully.");
                        }

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
                        System.out.println("Invalid choice, please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number from 1 to 6.");
                scanner.nextLine(); // clear invalid input
            }

        }
    }
}