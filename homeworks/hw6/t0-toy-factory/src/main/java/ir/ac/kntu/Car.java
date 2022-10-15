package ir.ac.kntu;

public class Car extends Toy {
    public Car(double basePrice, ToySize size) {
        super(basePrice, size);
    }

    @Override
    public double getPrice() {
        switch (this.size) {
            case SMALL:
                return 2 * getBasePrice();
            case MEDIUM:
                return 2.5 * getBasePrice();
            case LARGE:
                return 3 * getBasePrice();
        }
        return getBasePrice();
    }
}
