public class InventoryItem {
    private int itemId;
    private String itemName;
    private int quantity;
    private double pricePerUnit;
    private String expiryDate;

    public InventoryItem(String itemName, int quantity, double pricePerUnit, String expiryDate) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.expiryDate = expiryDate;
    }

    public InventoryItem(int itemId, String itemName, int quantity, double pricePerUnit, String expiryDate) {
        this(itemName, quantity, pricePerUnit, expiryDate);
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "ID: " + itemId + ", Name: " + itemName + ", Quantity: " + quantity + ", Price: " + pricePerUnit + ", Expiry: " + expiryDate;
    }
}