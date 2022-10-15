package ir.ac.kntu;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
public class SolutionTest {



    @Test
    public void testVIPTaxiInSameArea() {
       
        TripHandler taxi = TripHandler.getInstance();

        assertEquals(10000, taxi.calcPrice("vip", new TripParam(new Line(0, 0), false, false)));
        assertEquals(30000, taxi.calcPrice("vip", new TripParam(new Line(1, 1), true, true)));
        assertEquals(20000, taxi.calcPrice("vip", new TripParam(new Line(1, 1), false, true)));
        assertEquals(20000, taxi.calcPrice("vip", new TripParam(new Line(1, 1), true, false)));
    }

    @Test
    public void testVIPTaxiInDifferentAreas() {
        
        TripHandler taxi = TripHandler.getInstance();
        // 1->2 = 4
        assertEquals(40000, taxi.calcPrice("vip", new TripParam(new Line(1, 2), false, false)));
        assertEquals(120000, taxi.calcPrice("vip", new TripParam(new Line(1, 2), true, true)));
        assertEquals(80000, taxi.calcPrice("vip", new TripParam(new Line(1, 2), false, true)));
        assertEquals(80000, taxi.calcPrice("vip", new TripParam(new Line(1, 2), true, false)));

        // 2->1 = 5
        assertEquals(50000, taxi.calcPrice("vip", new TripParam(new Line(2, 1), false, false)));
        assertEquals(150000, taxi.calcPrice("vip", new TripParam(new Line(2, 1), true, true)));
        assertEquals(100000, taxi.calcPrice("vip", new TripParam(new Line(2, 1), false, true)));
        assertEquals(100000, taxi.calcPrice("vip", new TripParam(new Line(2, 1), true, false)));

    }

    @Test
    public void testEconomicTaxiInSameArea() {
        
        TripHandler taxi = TripHandler.getInstance();

        assertEquals(5000, taxi.calcPrice("economic", new TripParam(new Line(2, 2), false, false)));
        assertEquals(7000, taxi.calcPrice("economic", new TripParam(new Line(2, 2), true, true)));
        assertEquals(6000, taxi.calcPrice("economic", new TripParam(new Line(2, 2), false, true)));
        assertEquals(6000, taxi.calcPrice("economic", new TripParam(new Line(2, 2), true, false)));
    }

    @Test
    public void testEconomicTaxiInDifferentAreas() {
        
        TripHandler taxi = TripHandler.getInstance();
        // 0->2 = 2
        assertEquals(10000, taxi.calcPrice("economic", new TripParam(new Line(0, 2), false, false)));
        assertEquals(14000, taxi.calcPrice("economic", new TripParam(new Line(0, 2), true, true)));
        assertEquals(12000, taxi.calcPrice("economic", new TripParam(new Line(0, 2), false, true)));
        assertEquals(12000, taxi.calcPrice("economic", new TripParam(new Line(0, 2), true, false)));

        // 2->0 = 3
        assertEquals(15000, taxi.calcPrice("economic", new TripParam(new Line(2, 0), false, false)));
        assertEquals(21000, taxi.calcPrice("economic", new TripParam(new Line(2, 0), true, true)));
        assertEquals(18000, taxi.calcPrice("economic", new TripParam(new Line(2, 0), false, true)));
        assertEquals(18000, taxi.calcPrice("economic", new TripParam(new Line(2, 0), true, false)));
    }

    @Test
    public void testBikeTaxiInSameArea() {
        
        TripHandler taxi = TripHandler.getInstance();

        assertEquals(4000, taxi.calcPrice("bike", new TripParam(new Line(0, 0), false, false)));
        assertEquals(6000, taxi.calcPrice("bike", new TripParam(new Line(1, 1), true, true)));
        assertEquals(3200, taxi.calcPrice("bike", new TripParam(new Line(1, 1), false, true)));
        assertEquals(8000, taxi.calcPrice("bike", new TripParam(new Line(1, 1), true, false)));
    }

    @Test
    public void testBikeTaxiInDifferentAreas() {
        
        TripHandler taxi = TripHandler.getInstance();
        // 1->2 = 4
        assertEquals(16000, taxi.calcPrice("bike", new TripParam(new Line(1, 2), false, false)));
        assertEquals(24000, taxi.calcPrice("bike", new TripParam(new Line(1, 2), true, true)));
        assertEquals(12800, taxi.calcPrice("bike", new TripParam(new Line(1, 2), false, true)));
        assertEquals(32000, taxi.calcPrice("bike", new TripParam(new Line(1, 2), true, false)));

        // 2->1 = 5
        assertEquals(20000, taxi.calcPrice("bike", new TripParam(new Line(2, 1), false, false)));
        assertEquals(30000, taxi.calcPrice("bike", new TripParam(new Line(2, 1), true, true)));
        assertEquals(16000, taxi.calcPrice("bike", new TripParam(new Line(2, 1), false, true)));
        assertEquals(40000, taxi.calcPrice("bike", new TripParam(new Line(2, 1), true, false)));

    }

    @Test
    public void testMutipleTrip() {
        
        TripHandler taxi = TripHandler.getInstance();
        assertEquals(40000, taxi.calcPrice("vip", new TripParam(new Line(4, 2), true, false)));

        assertEquals(21000, taxi.calcPrice("economic", new TripParam(new Line(0, 4), true, true)));

        assertEquals(12000, taxi.calcPrice("bike", new TripParam(new Line(2, 3), false, false)));
    }

    @Test
    public void testIfTripHandlerIsSingletone1() {
        
        TripHandler th1 = TripHandler.getInstance();
        TripHandler th2 = TripHandler.getInstance();
        TripHandler th3 = TripHandler.getInstance();
        assertSame(th1, th2);
        assertSame(th1, th3);
        assertSame(th2, th3);
    }

    @Test
    public void testIfTripHandlerIsSingletone2() {
        
        Constructor<?>[] cons = TripHandler.class.getConstructors();
        for (Constructor<?> c : cons) {
            assertTrue(Modifier.isPrivate(c.getModifiers()));
        }
    }

    @Test
    public void testVIPTaxiInSameArea2() {

        TripMethod method = new VIPTripMethod();

        assertEquals(10000, method.calcPrice(new TripParam(new Line(0, 0), false, false)));
        assertEquals(30000, method.calcPrice(new TripParam(new Line(1, 1), true, true)));
        assertEquals(20000, method.calcPrice(new TripParam(new Line(1, 1), false, true)));
        assertEquals(20000, method.calcPrice(new TripParam(new Line(1, 1), true, false)));
    }

    @Test
    public void testVIPTaxiInDifferentAreas2() {

        TripMethod method = new VIPTripMethod();

        // 1->2 = 4
        assertEquals(40000, method.calcPrice(new TripParam(new Line(1, 2), false, false)));
        assertEquals(120000, method.calcPrice(new TripParam(new Line(1, 2), true, true)));
        assertEquals(80000, method.calcPrice(new TripParam(new Line(1, 2), false, true)));
        assertEquals(80000, method.calcPrice(new TripParam(new Line(1, 2), true, false)));

        // 2->1 = 5
        assertEquals(50000, method.calcPrice(new TripParam(new Line(2, 1), false, false)));
        assertEquals(150000, method.calcPrice(new TripParam(new Line(2, 1), true, true)));
        assertEquals(100000, method.calcPrice(new TripParam(new Line(2, 1), false, true)));
        assertEquals(100000, method.calcPrice(new TripParam(new Line(2, 1), true, false)));
    }

    @Test
    public void testEconomicTaxiInSameArea2() {

        TripMethod method = new EconomicTripMethod();

        assertEquals(5000, method.calcPrice(new TripParam(new Line(2, 2), false, false)));
        assertEquals(7000, method.calcPrice(new TripParam(new Line(2, 2), true, true)));
        assertEquals(6000, method.calcPrice(new TripParam(new Line(2, 2), false, true)));
        assertEquals(6000, method.calcPrice(new TripParam(new Line(2, 2), true, false)));
    }

    @Test
    public void testEconomicTaxiInDifferentAreas2() {

        TripMethod method = new EconomicTripMethod();

        // 0->2 = 2
        assertEquals(10000, method.calcPrice(new TripParam(new Line(0, 2), false, false)));
        assertEquals(14000, method.calcPrice(new TripParam(new Line(0, 2), true, true)));
        assertEquals(12000, method.calcPrice(new TripParam(new Line(0, 2), false, true)));
        assertEquals(12000, method.calcPrice(new TripParam(new Line(0, 2), true, false)));

        // 2->0 = 3
        assertEquals(15000, method.calcPrice(new TripParam(new Line(2, 0), false, false)));
        assertEquals(21000, method.calcPrice(new TripParam(new Line(2, 0), true, true)));
        assertEquals(18000, method.calcPrice(new TripParam(new Line(2, 0), false, true)));
        assertEquals(18000, method.calcPrice(new TripParam(new Line(2, 0), true, false)));
    }

    @Test
    public void testBikeTaxiInSameArea2() {

        TripMethod method = new BikeTripMethod();

        assertEquals(4000, method.calcPrice(new TripParam(new Line(0, 0), false, false)));
        assertEquals(6000, method.calcPrice(new TripParam(new Line(1, 1), true, true)));
        assertEquals(3200, method.calcPrice(new TripParam(new Line(1, 1), false, true)));
        assertEquals(8000, method.calcPrice(new TripParam(new Line(1, 1), true, false)));
    }

    @Test
    public void testBikeTaxiInDifferentAreas2() {

        TripMethod method = new BikeTripMethod();

        // 1->2 = 4
        assertEquals(16000, method.calcPrice(new TripParam(new Line(1, 2), false, false)));
        assertEquals(24000, method.calcPrice(new TripParam(new Line(1, 2), true, true)));
        assertEquals(12800, method.calcPrice(new TripParam(new Line(1, 2), false, true)));
        assertEquals(32000, method.calcPrice(new TripParam(new Line(1, 2), true, false)));

        // 2->1 = 5
        assertEquals(20000, method.calcPrice(new TripParam(new Line(2, 1), false, false)));
        assertEquals(30000, method.calcPrice(new TripParam(new Line(2, 1), true, true)));
        assertEquals(16000, method.calcPrice(new TripParam(new Line(2, 1), false, true)));
        assertEquals(40000, method.calcPrice(new TripParam(new Line(2, 1), true, false)));
    }
}
