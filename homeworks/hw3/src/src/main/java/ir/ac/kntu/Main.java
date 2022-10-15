package ir.ac.kntu;

import java.util.Arrays;

public class Main{  

    public static void main(String[] args) {
        
        // (0,0) ()
        Parallelogram rect = new Parallelogram(0, 0, 1, 0, 1, 1, 0, 1);
        Parallelogram rectb = new Parallelogram(1, 0, 2, 0, 2, 1, 1, 1);
        System.out.println(rect.getArea());
        System.out.println(rect.getPerimeter());
        System.out.println(Arrays.toString(rect.getCenter()));
        System.out.println(rect.getDistance(rectb));


    }

}