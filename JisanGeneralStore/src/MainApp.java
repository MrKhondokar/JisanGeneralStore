import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();
        InventoryManager inventoryManager = new InventoryManager(dbManager);

        try {
            dbManager.connect();

            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("--- Jisan General Store ---");
                System.out.println("1. Add Item");
                System.out.println("2. View Inventory");
                System.out.println("3. Update Item Quantity");
                System.out.println("4. Delete Item");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> inventoryManager.addItem();
                    case 2 -> inventoryManager.viewInventory();
                    case 3 -> inventoryManager.updateItemQuantity();
                    case 4 -> inventoryManager.deleteItem();
                    case 5 -> System.out.println("Exiting application...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Application encountered an error: " + e.getMessage());
        } finally {
            try {
                dbManager.disconnect();
            } catch (Exception e) {
                System.out.println("Failed to close database connection.");
            }
        }
    }
}