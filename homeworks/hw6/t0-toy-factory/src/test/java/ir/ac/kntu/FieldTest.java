package ir.ac.kntu;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class FieldTest {
    @Test
    public void testNumberOfToyFields() {

        Field[] fields = Toy.class.getDeclaredFields();
        int i = countDeclaredFields(fields);
        assertEquals(2, i);
    }

    @Test
    public void testNumberOfCarFields() {
        Field[] fields = Car.class.getDeclaredFields();
        int i = countDeclaredFields(fields);
        assertEquals(0, i);
    }

    @Test
    public void testNumberOfHelicopterFields() {
        Field[] fields = Helicopter.class.getDeclaredFields();
        int i = countDeclaredFields(fields);
        assertEquals(0, i);
    }

    private int countDeclaredFields(Field[] fields) {

        int i = 0;
        for (Field f : fields) {
            if (!f.getName().startsWith("$SWITCH_TABLE$")) {
                i++;
            }
        }
        return i;
    }
}
