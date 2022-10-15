

package ir.ac.kntu;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolutionTest {
    private Toy toy;
    private Car car;
    private Helicopter helicopter;

    @Before
    public void onceBeforeEachTest() {
        toy = new Toy(20, ToySize.SMALL);
        car = new Car(20, ToySize.SMALL);
        helicopter = new Helicopter(50, ToySize.SMALL);
    }

    @Test
    public void testCarGetPrice() {
        assertEquals(40, car.getPrice(), 1e-15);
        car.size = ToySize.MEDIUM;
        assertEquals(50, car.getPrice(), 1e-15);
        car.size = ToySize.LARGE;
        assertEquals(60, car.getPrice(), 1e-15);
    }

    @Test
    public void testToyGetPrice() {

        assertEquals(20, toy.getPrice(), 1e-15);
        toy.size = ToySize.MEDIUM;
        assertEquals(30, toy.getPrice(), 1e-15);
        toy.size = ToySize.LARGE;
        assertEquals(40, toy.getPrice(), 1e-15);
    }

    @Test
    public void testHelicopterGetPrice() {
        assertEquals(50, helicopter.getPrice(), 1e-15);
        helicopter.size = ToySize.MEDIUM;
        assertEquals(75, helicopter.getPrice(), 1e-15);
        helicopter.size = ToySize.LARGE;
        assertEquals(200, helicopter.getPrice(), 1e-15);
    }

    @Test
    public void testGetPriceWithDiscount() {
        double price = car.getPrice(20);
        assertEquals(20, car.getBasePrice(), 1e-15);
        assertEquals(32, price, 1e-15);

        price = toy.getPrice(10);
        assertEquals(20, car.getBasePrice(), 1e-15);
        assertEquals(18, price, 1e-15);

        helicopter.size = ToySize.MEDIUM;
        price = helicopter.getPrice(5);
        assertEquals(50, helicopter.getBasePrice(), 1e-15);
        assertEquals(71.25, price, 1e-15);
    }

    @Test
    public void testGetType() {
        assertEquals("Toy", toy.getType());
        assertEquals("Car", car.getType());
        assertEquals("Helicopter", helicopter.getType());
        Toy helicopter2 = new Helicopter(500, ToySize.LARGE);
        assertEquals("Helicopter", helicopter2.getType());
    }
}
