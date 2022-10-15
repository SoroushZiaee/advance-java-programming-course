package ir.ac.kntu;

import java.lang.Math;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double A, double B, double C) {
        this.a = A;
        this.b = B;
        this.c = C;
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

    public double getRoot1() {
        return (-this.b + Math.sqrt(getDiscriminant())) / (2 * this.a);
    }

    public double getRoot2() {
        return (-this.b - Math.sqrt(getDiscriminant())) / (2 * this.a);
    }
}
