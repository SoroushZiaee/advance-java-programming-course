package ir.ac.kntu;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class SolutionTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private final Point[] points = {new Point(8, 12), new Point(3, 15), new Point(8, 12), new Point(0, 0)
            , new Point(4, 0), new Point(4, 3), new Point(8, 12), new Point(13, -19)
            , new Point(-15, -1), new Point(-7, 6), new Point(3, -17), new Point(-17, 8)
            , new Point(-7, 6), new Point(3, -17), new Point(-17, 8), new Point(0, 0)
            , new Point(4, 0), new Point(4, 3),};


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testTriangles1() {
        TriangleHandling th = new TriangleHandling();
        th.printTriangles(points);
        assertTrue(outContent.toString().contains("invalid coordinates(distance = 0):1"));
    }

    @Test
    public void testTriangles2() {
        TriangleHandling th = new TriangleHandling();
        th.printTriangles(points);
        assertTrue(outContent.toString().contains("orths:2"));
    }

    @Test
    public void testTriangles3() {
        TriangleHandling th = new TriangleHandling();
        th.printTriangles(points);
        assertTrue(outContent.toString().contains("triangles:3"));
    }

//    @After
//    public void restoreStreams() {
//        System.setOut(originalOut);
//    }
}
