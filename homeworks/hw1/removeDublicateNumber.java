import java.util.*;



public class removeDublicateNumber {

    static void printOutput(int[] x, int[] y){

        int counter = 0;
        if (x.length == 0 || y.length == 0) {
            System.out.println("{}");
        }
        else  {
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

        
        
        
    }

    static boolean isIn(int []x, int k){
        for (int i=0; i<x.length; i++)
            if (x[i] == k) return true;
        
        return false;
    }

    static int[] removeDublicateInArray(int x[]){
        int n = x.length;
        int temp[];
        if (n==0){ 
            temp = new int[0];
            return temp;
        }

        int arr[] = Arrays.copyOfRange(x, 0, n);
        Arrays.sort(arr);
        
        int j = 0;
        for (int i = 0; i < n - 1; i++){
            if (arr[i] != arr[i+1]){
                // temp[j++] = arr[i];
                j ++;
            }
        }

        j ++;

        temp = new int[j];

        j = 0;

        for (int i = 0; i < x.length; i++){
            if (!isIn(temp, x[i])){
                temp[j++] = x[i];
            }
        }

        return temp;
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

        // System.out.println(Arrays.toString(removeDublicateInArray(x)));
        // System.out.println(Arrays.toString(removeDublicateInArray(y)));


        
        printOutput(removeDublicateInArray(x), removeDublicateInArray(y));
        in.close();
    

        
    }
    
}
