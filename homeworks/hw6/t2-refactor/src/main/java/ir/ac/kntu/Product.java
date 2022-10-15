package ir.ac.kntu;

public class Product {

    private double price;

    private int serialNumber;

    public Product(double price, int serialNumber) {
        setPrice(price);
        setSerialNumber(serialNumber);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return this.serialNumber + " by " + this.price;
    }
}
