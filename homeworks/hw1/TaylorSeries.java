import java.util.*;
import java.lang.Math;


public class TaylorSeries {
    // static double degToRad(int x){
    //     Double PI = Math.PI;
    //     // D     R
    //     // -- = --
    //     // 180  pi
    //     return (x * PI) / 180.0;
    // }

    static int factoriel(int x){
        if (x == 0) return 1;

        return (x * factoriel(x - 1));
    }

    static double cos(int x, int n){
        if (x==0) return 1.0;

        Double cos_value = 0.0;
        Double x_rad = Math.toRadians(x);

        for(int i =0; i<n; i++){ 
            cos_value += (Math.pow(-1, i)) * (Math.pow(x_rad, 2*i)/factoriel(2*i));
        }
        

        return cos_value;
    }
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int x = in.nextInt();
        String output = String.format("%.4f", cos(x, n));
        
        System.out.println(output);
        // System.out.println("Fac : " + factoriel(n));
        in.close();
    }    
}
