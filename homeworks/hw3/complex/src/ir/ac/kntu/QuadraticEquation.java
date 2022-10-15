package ir.ac.kntu;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;

    public QuadraticEquation(double ACoefficient, double BCoefficient, double CCoefficient) {
        a = ACoefficient;
        b = BCoefficient;
        c = CCoefficient;
    }


    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public Complex getRoot1() {
        if (this.getDiscriminant() >= 0) {
            return new Complex((-this.b + Math.sqrt(this.getDiscriminant())) / (2 * this.a), 0);
        } else {
            return new Complex(-1 * this.b, 1 * Math.sqrt(Math.abs(this.getDiscriminant()))).scale(1 / (2 * this.a));
        }
    }

    public Complex getRoot2() {
        double delta = this.getDiscriminant();
        if (this.getDiscriminant() >= 0) {
            return new Complex((-this.b - Math.sqrt(this.getDiscriminant())) / (2 * this.a), 0);
        } else {
            return new Complex(-1 * this.b, -1 * Math.sqrt(Math.abs(this.getDiscriminant()))).scale(1 / (2 * this.a));
        }
    }

}
