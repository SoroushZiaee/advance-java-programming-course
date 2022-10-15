package ir.ac.kntu;

import Math.abs;
import java.util.*;

public class Parallelogram {
    private double x1, y1;
    private double x2, y2;
    private double x3, y3;
    private double x4, y4;
    private List<Double> x = new ArrayList<Double>();
    private List<Double> y = new ArrayList<Double>();

    public Parallelogram(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;

        x.add((Double) x1);
        x.add((Double) x2);
        x.add((Double) x3);
        x.add((Double) x4);

        y.add((Double) y2);
        y.add((Double) y1);
        y.add((Double) y3);
        y.add((Double) y4);
    }

    public double getArea() {
        // TODO: Complete this method
        double b = Collections.max(this.x) - Collections.min(this.x);
        double h = Collections.max(this.y) - Collections.min(this.y);

        return h * b;
    }

    private double calculateDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y1 - y2), 2));
    }

    public double getPerimeter() {
        double Perimeter=0;

        for (int i=0; i<this.x.size(); i++){
            if (i == this.x.size() - 1) 
                Perimeter += calculateDist(x.get(i), y.get(i), x.get(0), y.get(0));
            else
                Perimeter += calculateDist(x.get(i), y.get(i), x.get(i+1), y.get(i+1));
        }

        return Perimeter;
    }

    public double[] getCenter() {
        double[] center = new double[2];

        center[0] = (Collections.max(this.x) + Collections.min(this.x)) / 2;
        center[1] = (Collections.max(this.y) + Collections.min(this.y)) / 2;

        return center;
    }

    public double getDistance(Parallelogram b) {
        // TODO: Complete this method
        // System.out.println("Here");
        double[] aCenter = this.getCenter();
        // System.out.println(Arrays.toString(aCenter));
        double[] bCenter = b.getCenter();

        return this.calculateDist(aCenter[0], aCenter[1], bCenter[0], bCenter[1]);
    }
}
