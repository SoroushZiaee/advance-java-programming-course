package ir.ac.kntu;

/*
Program Description: Online Store
This class creates an object that represents the specific details of a customers order when
its constructor is invoked. The variables serialNumber will be crucial throughout the program in
order to find the specific product customer wishes to buy. 
*/
public class Order {

    private String customer;

    private int serialNumber;

    private int quantity;

    /*
     * Order Constructor
     * Creates an instance of Order when invoked upon
     */

    public Order(String customer, int serialNumber, int quantity) {
        this.customer = customer;
        this.serialNumber = serialNumber;
        this.quantity = quantity;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
