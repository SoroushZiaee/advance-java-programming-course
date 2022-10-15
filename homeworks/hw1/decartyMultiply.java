import java.util.*;

public class decartyMultiply {

    static void printOutput(int[] x, int[] y){

        int counter = 0;
        
        System.out.print("{");
        for (int i=0; i<x.length; i++) {
            for (int j=0; j<y.length; j++) {
                System.out.print("(");
                System.out.print(x[i]);
                System.out.print(",");
                System.out.print(y[j]);
                System.out.print(")");
                counter ++;

                if (counter!=x.length * y.length) {
                    System.out.print(",");
                }
                
            }

            
            
        }
        System.out.println("}");
        
        
    }

    static int count(int[] x, int k){
        int counter = 0;
        for (int i=0; i<x.length; i++)
            if (x[i] == k)
                counter ++;
        
        return counter;
    }

    static boolean isIn(int []x, int k){
        for (int i=0; i<x.length; i++)
            if (x[i] == k) return true;
        
        return false;
    }


    static int[] makeSet(int[] x){
        int new_x[], temp_count, prev_num = 765;
        int size = x.length;

        for (int i=0; i<x.length; i++){
            temp_count = count(x, x[i]); 
            // System.out.println("X[i] : " + x[i] + " Count : " + temp_count);
            if (temp_count > 1 && x[i] != prev_num){
                size = size - temp_count + 1; 
                prev_num = x[i];
            }
        }

        new_x = new int[size];
        int counter = 0;
        int idx = 0;
        prev_num = 765;
        while (counter != size){ 
            if (x[idx] != prev_num){
                new_x[counter] = x[idx];
                prev_num = x[idx];
                counter ++;
            }
            idx ++;
        }

        // System.out.println("new size : " + size);

        return new_x;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int x[] = new int[n];
        for (int i=0; i<n; i++)
            x[i] = in.nextInt();

        n = in.nextInt();
        int y[] = new int[n];
        for (int i=0; i<n; i++)
            y[i] = in.nextInt();
        

        // System.out.print("{");
        // System.out.print("}");

        // int x[] = {1, 1 , 1};
        // int y[] = {3, 4, 5};
        // int y[] = makeSet(x);
        // for (int i=0; i<y.length; i++) {
        //     System.out.println(y[i]);
        // }
        // System.out.println("y = " + y);
        
        printOutput(makeSet(x), makeSet(y));
        in.close();
    }
    
}
