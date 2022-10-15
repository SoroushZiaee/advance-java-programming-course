package ir.ac.kntu;

/*
Program Description: Online Store
The Inventory class represents the entire inventory of the store that consists of inventory_items organized in an arraylist.
Contains all information of the inventory and will execute specific tasks in each method when invoked upon.
*/

import java.util.ArrayList;

public class Inventory {
    private ArrayList<InventoryItem> items;

    // Automatically initializes the arraylist to be null
    public Inventory() {
        this.items = new ArrayList<InventoryItem>();
    }

    // Adds object to the items arraylist
    public void addItem(Product product, int quantity) {
        this.items.add(new InventoryItem(quantity, product));
    }

    /*
     * This method will first find which product has the same serial number as the
     * one being passed in the argument
     * Then it will check to see if they have a large enough quantity to satisfy the
     * customers request using an if statement.
     * Returns true if there is enough, false if there is a shortage.
     * Try catch is implemented in the case there is no such product in the
     * inventory that is being requested by customer.
     */
    public boolean checkInventory(int serialNumber, int quantity) {
        InventoryItem inventory = lookUpItem(serialNumber); // Created item variable to store the inventoryItem that
        // contained the specific serialNumber
        if (inventory != null) {
            return inventory.getQuantity() >= quantity;
        }else{
            System.out.println("Product with " + serialNumber + "isn't found");
            return false;
        }
    }

    public void decreaseStock(int serialNumber, int reduction) {
        for (InventoryItem inventory : this.items) {
            if (inventory.getProduct().getSerialNumber() == serialNumber) {
                inventory.removeFromQuantity(reduction);
            }
        }
    }

    /*
     * Method creates a list of the products in the inventory
     * Outputs the serial number, description, and quantity of product in specific
     * format
     * Calls the Product class's getListing method to obtain product details
     */
    public void list() {
        for (InventoryItem inventory : this.items) {
            System.out.println(inventory.getListing());
        }
    }

    /*
     * Method is invoked in situation when program only has serial number and needs
     * the specific inventory_item,
     * especially if it needs to interact with methods in the inventory_item class.
     * Returns the inventory_item with same serial number
     */
    public InventoryItem lookUpItem(int serialNumber) {
        for (InventoryItem inventory : this.items) {
            if (inventory.getProduct().getSerialNumber() == serialNumber) {
                return inventory;
            }
        }
        return null;
    }
}
