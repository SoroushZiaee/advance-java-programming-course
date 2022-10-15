package ir.ac.kntu;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class MethodsTest {
    @Test
    public void testNumberOfToyMethods() {
        Method[] methods = Toy.class.getDeclaredMethods();
        int i = countDeclaredMethods(methods);
        assertEquals(4, i);
    }

    @Test
    public void testNumberOfCarMethods() {

        Method[] methods = Car.class.getDeclaredMethods();
        int i = countDeclaredMethods(methods);
        assertEquals(1, i);
    }

    @Test
    public void testNumberOfHelicopterMethods() {

        Method[] methods = Car.class.getDeclaredMethods();
        int i = countDeclaredMethods(methods);
        assertEquals(1, i);
    }

    private int countDeclaredMethods(Method[] methods) {
        int i = 0;
        for (Method m : methods) {
            if (!m.getName().startsWith("$SWITCH_TABLE$")) {
                i++;
            }
        }
        return i;
    }
}
