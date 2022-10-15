package ir.ac.kntu;

public class InvalidCoordinatesEx extends Exception{
    public InvalidCoordinatesEx() {
        super("You can't have a triangle with zero length");
    }
}
