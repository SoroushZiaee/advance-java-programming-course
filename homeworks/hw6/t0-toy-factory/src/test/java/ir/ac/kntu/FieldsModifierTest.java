package ir.ac.kntu;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

public class FieldsModifierTest {
    @Test
    public void testFieldsModifier() {
        Field[] fields = Toy.class.getDeclaredFields();
        assertTrue(Modifier.isPrivate(fields[0].getModifiers()));
        assertTrue(Modifier.isProtected(fields[1].getModifiers()));
    }
}
