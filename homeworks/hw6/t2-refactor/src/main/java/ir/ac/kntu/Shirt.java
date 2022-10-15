package ir.ac.kntu;

/*
Program Description: Online Store
The Shirt class is a subclass to Product, practicing the concept of inheritance.
*/
public class Shirt extends Product {

    private String type;

    private String size;

    private String color;


    /*
     * Shirt constructor class that creates an instance of shirt.
     * Because this class extends Product, the code must use the super keyword to
     * call the
     * Product constructor to initialize price and serialNumber,
     * since these instance variables are shared amongst all products.
     */

    public Shirt(double price, int serialNumber, String type, String size, String color) {
        super(price, serialNumber);
        this.type = type;
        this.size = size;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Returns a description of the specific book when invoked in a specific format
    @Override
    public String getDescription() {
        return this.color + " " + this.type + " - " + getSerialNumber();
    }
}
