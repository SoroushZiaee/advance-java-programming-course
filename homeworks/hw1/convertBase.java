// import java.lang.*;
import java.util.*;

public class convertBase {

    static String numToStr(int r){
        switch (r) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15: 
                return "F";
            default:
                return String.valueOf(r);
        }

    }

    static String[] arrayReverse(String [] x){
        String y[] = new String[x.length];

        for (int i = 0; i < x.length; i++) {
            y[i] = x[x.length - i - 1];
        }

        return y;
    }

    static boolean isOk(String []x){
        String reverseArray[] = new String[x.length];
        reverseArray = arrayReverse(x);

        for (int i = 0; i < x.length; i++) {
            if (! x[i].equals(reverseArray[i])) return false;
        }

        return true;
    }

    static String baseConversion(int x, int b, String a){
        if (x<b) return a + numToStr(x % b);

        else return baseConversion(x / b, b, a + numToStr(x % b));
    }

    public static void main(String args[]) {
        // int b = 16; // Base 2
        // int x = 459; // Our Number 

        int x, b;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        b = in.nextInt();

        String outPut[];
        outPut = arrayReverse(baseConversion(x, b, "").split(""));
        // System.out.println(Arrays.toString(outPut));
        // System.out.println(outPut[0]);

        for (int i=0; i<outPut.length; i++) {
            System.out.print(outPut[i]);
            
            if (i!=outPut.length) 
                System.out.print(" ");
        }

        System.out.println("");

        if (isOk(outPut)) System.out.println("YES");
        else System.out.println("NO");

        in.close();

        // outPut = baseConversion(x, b, outPut);
        
    }
    
}
