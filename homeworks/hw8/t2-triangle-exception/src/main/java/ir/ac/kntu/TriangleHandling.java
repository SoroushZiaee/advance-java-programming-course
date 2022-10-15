package ir.ac.kntu;

import java.util.Random;

public class TriangleHandling {
    private int orthCounter = 0;

    private int triangleCounter = 0;

    private int invalidCounter = 0;

    public Point[] randomArray() {
        //complete this method
        int bound = 10;
        int numberOfCollection;
        do {
            numberOfCollection = new Random().nextInt(bound) * 3;
        } while (numberOfCollection == 0);

        Point[] points = new Point[numberOfCollection];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(new Random().nextInt(bound), new Random().nextInt(bound));
        }

        return points;
    }

    public int calculateSide(Point p1, Point p2) {
        //complete this method
        return (int) (Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow((p1.getY() - p2.getY()), 2)));
    }

    public void checkSides(int a, int b, int c) throws InvalidCoordinatesEx {
        if (a == 0 || b == 0 || c == 0) {
            throw new InvalidCoordinatesEx();
        }
    }

    public void isTri(int a, int b, int c) throws TriangleEx {
        if (a + b > c && b + c > a && a + c > b) {
            throw new TriangleEx();
        }
    }

    public void isOrth(int a, int b, int c) throws OrthEx {
        if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
            throw new OrthEx();
        }
    }

    public void printTriangles(Point[] points) {

        for (int i = 0; i < points.length / 3; i++) {
            Point a = points[i * 3];
            Point b = points[i * 3 + 1];
            Point c = points[i * 3 + 2];


            try {

                this.checkSides(calculateSide(a, b), calculateSide(b, c), calculateSide(a, c));
                this.isOrth(calculateSide(a, b), calculateSide(b, c), calculateSide(a, c));
                this.isTri(calculateSide(a, b), calculateSide(b, c), calculateSide(a, c));

            } catch (TriangleEx ex) {
                this.triangleCounter++;
            } catch (OrthEx ex) {
                this.orthCounter++;
            } catch (InvalidCoordinatesEx ex) {
                this.invalidCounter++;
            }

        }
        printResult();
    }

    private void printResult() {
        System.out.println("invalid coordinates(distance = 0):" + invalidCounter + "\n" + "orths:" + orthCounter + "\n" + "triangles:" + triangleCounter);
    }
}
