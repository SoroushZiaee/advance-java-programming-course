package ir.ac.kntu;

import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    @Test
    public void testNumberOfToyConstructors() {
        Constructor[] constructors = Toy.class.getConstructors();
        assertEquals(1, constructors.length);
    }

    @Test
    public void testNumberOfCarConstructors() {
        Constructor[] constructors = Car.class.getConstructors();
        assertEquals(1, constructors.length);
    }

    @Test
    public void testNumberOfHelicopterConstructors() {
        Constructor[] constructors = Helicopter.class.getConstructors();
        assertEquals(1, constructors.length);
    }
}
