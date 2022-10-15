import java.util.Arrays;
import java.lang.*;

public class helperClasses {

    public static void main(String[] args) {
        // Use Arrays.toString to print an array
        int []x = {8, 4, 3, 2, 9, 1, 5, 6, 10};

        System.out.println("Array : " + Arrays.toString(x));

        // Use Arrays.sort() to sort the array
        Arrays.sort(x);
        System.out.println("Sorted Array : " + Arrays.toString(x));

        // Truncating the Array from specific index to sth
        int from = 2;
        int to = 5;
        int newX[] = Arrays.copyOfRange(x, from, to);
        System.out.println("Truncating array from 2 to 5 : " + Arrays.toString(newX));

        // Print Multi dimensional Arrays
        int multiX[][] = new int[3][3];
        for (int i =0;i<multiX.length; i++)
            for (int j=0; j<multiX[i].length; j++)
                multiX[i][j] = i + j;
        
        System.out.println("Print an multi dimensional array : ");
        System.out.println(Arrays.deepToString(multiX));

        // String method
        String s = "Hello World";
        System.out.println(s.length());
    }
    
}
