package ir.ac.kntu;

public class Helicopter extends Toy {
    public Helicopter(double basePrice, ToySize size) {
        super(basePrice, size);
    }

    @Override
    public double getPrice() {
        switch (this.size) {
            case SMALL:
                return getBasePrice();
            case MEDIUM:
                return 1.5 * getBasePrice();
            case LARGE:
                return 4 * getBasePrice();
        }
        return getBasePrice();
    }
}
