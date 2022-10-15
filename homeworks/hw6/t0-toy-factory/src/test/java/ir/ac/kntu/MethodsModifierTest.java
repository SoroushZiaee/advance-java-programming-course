package ir.ac.kntu;

import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public class MethodsModifierTest {
    @Test
    public void testToyMethodsModifier() {
        Method[] methods = Toy.class.getDeclaredMethods();
        for (Method m : methods) {
            if (!m.getName().startsWith("$SWITCH_TABLE$")) {
                assertTrue(Modifier.isPublic(m.getModifiers()));
            }
        }
    }

    @Test
    public void testCarMethodsModifier() {
        Method[] methods = Car.class.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("$SWITCH_TABLE$")) {
                assertTrue(Modifier.isPublic(method.getModifiers()));
            }
        }
    }

    @Test
    public void testHelicopterMethodsModifier() {
        Method[] methods = Helicopter.class.getDeclaredMethods();
        for (Method method : methods) {
            if (!method.getName().startsWith("$SWITCH_TABLE$")) {
                assertTrue(Modifier.isPublic(method.getModifiers()));
            }
        }
    }
}
