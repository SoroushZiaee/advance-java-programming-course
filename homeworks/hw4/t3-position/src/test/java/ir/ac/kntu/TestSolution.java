package ir.ac.kntu;

import org.junit.Assert;
import org.junit.Test;

public class TestSolution {
    @Test
    public void checkToString() {
        Position position1 = new Position(10.33, 22);
        Assert.assertSame("check toString Method", position1.toString(), "{x: 10.33, y: 22}");
    }

    @Test
    public void checkGetter() {
        Position position1 = new Position(10.33, 22);
        Assert.assertTrue("check x", position1.getX() == 10.33);
        Assert.assertTrue("check y", position1.getY() == 22);
    }

    @Test
    public void checkEquals1() {
        Position position1 = new Position(10.33, 22);
        Position position2 = new Position(10.33, 22);
        Assert.assertTrue("Should be the same", position1.equals(position2));
    }

    @Test
    public void checkEquals2() {
        Position position1 = new Position(10.33, 22.213);
        Position position2 = new Position(10.31, 22.2133);
        Assert.assertFalse("Shouldn't be the same", position1.equals(position2));
    }


    @Test
    public void checkStringToPosition1() {
        Position position1 = new Position(9012.213, 22.141341);
        Position position2 = Position.convertStringToPosition("9012.213,22.141341");
        Assert.assertTrue("Should convert String works", position2.equals(position1));
    }

    @Test
    public void checkStringToPosition2() {
        Position position1 = new Position(9012.2113, 22.141341);
        Position position2 = Position.convertStringToPosition("9012.213,22.141341");
        Assert.assertFalse("Shouldn't convert String works", position2.equals(position1));
    }

    @Test
    public void checkArrayToPosition1() {
        Position position1 = new Position(9012.213, 22.141341);
        Position position2 = Position.convertArrayToPosition(new double[]{9012.213, 22.141341});
        Assert.assertTrue("Should convert String works", position2.equals(position1));
    }

    @Test
    public void checkArrayToPosition2() {
        Position position1 = new Position(9012.2113, 22.141341);
        Position position2 = Position.convertArrayToPosition(new double[]{9012.21131, 22.1341341});
        Assert.assertFalse("Shouldn't convert String works", position2.equals(position1));
    }

    @Test
    public void checkArrayToPositionString1() {
        Position position1 = Position.convertStringToPosition("9012.213,22.141341");
        Position position2 = Position.convertArrayToPosition(new double[]{9012.213, 22.141341});
        Assert.assertTrue("Should convert String works", position2.equals(position1));
    }

    @Test
    public void checkArrayToPositionString2() {
        Position position1 = Position.convertStringToPosition("9012.213,22.141341");
        Position position2 = Position.convertArrayToPosition(new double[]{9012.21131, 22.1341341});
        Assert.assertFalse("Shouldn't convert String works", position1.equals(position2));
    }
}
