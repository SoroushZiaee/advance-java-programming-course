package ir.ac.kntu;

public class Main {

    public static void main(String[] args) {
	    Complex a = new Complex(1, 1);
	    Complex b = new Complex(1, -1);

	    // Print Number
        System.out.println(a.toString());
        System.out.println(b.toString());

        // Abs Numbers
        System.out.println(a.abs());
        System.out.println(b.abs());

        // phase numbers
        System.out.println(a.phase());
        System.out.println(b.phase());

        // Plus
        System.out.println(a.plus(b));

        // Minus
        System.out.println(a.minus(b));

        // Times
        System.out.println(a.times(b));

        // Divides
        System.out.println(a.divides(b));

        // Conjugate
        System.out.println(a.conjugate());

        // Scale
        System.out.println(a.scale(0.5));

        // Calculate Root

        QuadraticEquation eq = new QuadraticEquation(1, 1, 1);
        System.out.println(eq.getRoot1());
        System.out.println(eq.getRoot2());
    }
}
