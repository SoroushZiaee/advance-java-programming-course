import java.util.*;


public class Maximum {

    // Convert the 2D array to 1D array
    static int[] flatten(int m, int n, int[][] array2d){
        int array[] = new int[m * n];
        int counter = 0;
        for (int i=0; i<m; i++)
            for (int j=0; j<n ;j++){
                array[counter] = array2d[i][j];
                counter++;
            }
        
        return array;
    }

    static int[] sortArray(int[] array){ 
        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
            //    System.out.println("i : " + i + " j : " + j);
                if (array[i] < array[j]){ 
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }

    static int[] showIndex(int[][] array, int[] sortArray, int k){ 
        int value, counter=0;
        int index[] = new int[2];
        while (counter != (k-1)){ 
            counter ++;
        }
        value = sortArray[counter];

        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if(array[i][j]==value) {
                    // System.out.println(array[i][j]);
                    index[0] = i;
                    index[1] = j;
                }
            }
        }

        return index;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        m = in.nextInt();
        n = in.nextInt();

        int array[][] = new int[m][n];

        for (int i=0;i<array.length; i++){
            for (int j = 0; j<array[i].length; j++) {
                array[i][j] = in.nextInt();
            }
        }

        int k = in.nextInt();

        int sortedarray[] = sortArray(flatten(m, n, array));
        int index[] = showIndex(array, sortedarray, k);


        System.out.println(index[0] + " " + index[1]);

        in.close();
    }
}
