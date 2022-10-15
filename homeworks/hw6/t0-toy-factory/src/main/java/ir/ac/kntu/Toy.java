package ir.ac.kntu;

public class Toy {
    private final double basePrice;
    protected ToySize size;


    public Toy(double basePrice, ToySize size) {
        this.basePrice = basePrice;
        this.size = size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getPrice() {
        switch (this.size) {
            case SMALL:
                return basePrice;
            case MEDIUM:
                return 1.5 * basePrice;
            case LARGE:
                return 2 * basePrice;
        }
        return basePrice;
    }

    public double getPrice(double discount) {
        return getPrice() - getPrice() * (discount / 100);
    }

    public String getType() {
        if (this instanceof Helicopter) {
            return "Helicopter";
        } else if (this instanceof Car) {
            return "Car";
        } else {
            return "Toy";
        }

    }

}
