package main.java.ir.ac.kntu;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        QuadraticEquation eq = new QuadraticEquation(1, 2, 1);
        System.out.println(eq.getDiscriminant());
        System.out.println(eq.getRoot1());
        System.out.println(eq.getRoot2());
    }
}
