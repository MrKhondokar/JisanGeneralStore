import java.sql.*;
import java.util.Scanner;

public class InventoryManager {
    private final DatabaseManager dbManager;

    public InventoryManager(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public void addItem() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter item name: ");
            String name = scanner.nextLine();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter price per unit: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter expiry date (YYYY-MM-DD): ");
            String expiryDate = scanner.nextLine();

            String query = "INSERT INTO Inventory (item_name, quantity, price_per_unit, expiry_date) VALUES ('"
                    + name + "', " + quantity + ", " + price + ", '" + expiryDate + "')";
            dbManager.executeUpdate(query);
            System.out.println("Item added successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to add item: " + e.getMessage());
        }
    }

    public void viewInventory() {
        try {
            ResultSet resultSet = dbManager.executeQuery("SELECT * FROM Inventory");
            System.out.println("--- Inventory List ---");
            while (resultSet.next()) {
                System.out.println(new InventoryItem(
                        resultSet.getInt("item_id"),
                        resultSet.getString("item_name"),
                        resultSet.getInt("quantity"),
                        resultSet.getDouble("price_per_unit"),
                        resultSet.getString("expiry_date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch inventory: " + e.getMessage());
        }
    }

    public void updateItemQuantity() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter item ID to update: ");
            int id = scanner.nextInt();
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();

            String query = "UPDATE Inventory SET quantity = " + quantity + " WHERE item_id = " + id;
            dbManager.executeUpdate(query);
            System.out.println("Item quantity updated successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to update item: " + e.getMessage());
        }
    }

    public void deleteItem() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter item ID to delete: ");
            int id = scanner.nextInt();

            String query = "DELETE FROM Inventory WHERE item_id = " + id;
            dbManager.executeUpdate(query);
            System.out.println("Item deleted successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to delete item: " + e.getMessage());
        }
    }
}