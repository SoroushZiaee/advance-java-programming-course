package ir.ac.kntu;

/*
Program Description: Online Store
This class, when an instance is created, represents a specific item in the inventory and also includes its quantity
Interacts with the Inventory class to provide that instance with the proper details
*/
public class InventoryItem {

    private int quantity;

    private Product product;

    /*
     * This InventoryItem constructor is to create an instance of InventoryItem
     * which
     * specifies the type and quantity of the item, initializing these two variables
     */

    public InventoryItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    /*
     * Creates a sentence containing with the product's specific details, including
     * the
     * serial number, description, and quantity of the product.
     * Used to display the inventory
     */
    public String getListing() {
        return this.product.getSerialNumber() + "\t" + this.product.getDescription() + "\t" + getQuantity();
    }


    /*
     * Product already has an initialized serial number
     * This method is able to return the serial number of the product by using the
     * this.product keyword
     * It allows the program to go into the Product class and fetch the serial
     * number of the product from the
     * getSerialNumber() method.
     */
    // Delete the function

    /*
     * Invoked following the successful transaction of a product
     * Just decreases the quantity(qyt) of specific instance.
     */
    public void removeFromQuantity(int reduction) {
        if (reduction < getQuantity()) {
            setQuantity(getQuantity() - reduction);
        } else {
            System.out.println("We Don't have enough product in inventory");
            setQuantity(0);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
