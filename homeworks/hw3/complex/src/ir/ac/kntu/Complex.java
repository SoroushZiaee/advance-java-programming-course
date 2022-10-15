package ir.ac.kntu;

//use alt+shift+f to clean this code!
public class Complex {
    private double re;   // the real part
    private double im;   // the imaginary part

    // create a new object with the given real and imaginary parts
    public Complex(double real, double imag) {
        re = real;
        im = imag;
    }

    // a static version of plus
    public static Complex plus(Complex a, Complex b) {
        return new Complex(a.getRealPart() + b.getRealPart(), a.getImaginaryPart() + b.getImaginaryPart());
    }

    // return a string representation of the invoking Complex object
    public String toString() {
        if (im == 0) {
            return re + "";
        }
        if (re == 0) {
            return im + "i";
        }
        if (im < 0) {
            return re + " - " + (-im) + "i";
        }
        return re + " + " + im + "i";
    }

    // return abs/modulus/magnitude
    public double abs() {
        return Math.sqrt(Math.pow(re, 2) + Math.pow(im, 2));

    }

    // return angle/phase/argument, normalized to be between -pi and pi
    public double phase() {
        return Math.atan(im / re);
    }

    // return a new Complex object whose value is (this + b)
    public Complex plus(Complex b) {
        return new Complex(re + b.getRealPart(), im + b.getImaginaryPart());
    }

    // return a new Complex object whose value is (this - b)
    public Complex minus(Complex b) {
        return new Complex(re - b.getRealPart(), im - b.getImaginaryPart());
    }

    // return a new Complex object whose value is (this * b)
    public Complex times(Complex b) {
        return new Complex((re * b.getRealPart()) - (im * b.getImaginaryPart()),
                (re * b.getImaginaryPart()) + (im * b.getRealPart()));
    }

    // return a new object whose value is (this * alpha)
    public Complex scale(double alpha) {
        return new Complex(re * alpha, im * alpha);
    }

    // return a new Complex object
    //whose value is the conjugate of this
    public Complex conjugate() {
        return new Complex(re, -1 * im);
    }

    // return a new Complex object
    //whose value is the reciprocal of this
    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    // return the real part
    public double getRealPart() {
        return re;
    }

    // return the imaginary part
    public double getImaginaryPart() {
        return im;
    }

    // return a / b
    public Complex divides(Complex b) {
        return this.times(b.conjugate()).scale(1 / (Math.pow(b.getRealPart(), 2) + Math.pow(b.getImaginaryPart(), 2)));
    }

    // return a new Complex object
    //whose value is the complex exponential of this
    public Complex exp() {
        return new Complex(Math.exp(re) * Math.cos(im), Math.exp(re) * Math.sin(im));
    }

    // return a new Complex object
    //whose value is the complex sine of this
    public Complex sin() {
        return new Complex(Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
    }

    // return a new Complex object
    //whose value is the complex cosine of this
    public Complex cos() {
        return new Complex(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
    }

    // return a new Complex object whose value is the complex tangent of this
    public Complex tan() {
        return this.sin().divides(this.cos());
    }

}