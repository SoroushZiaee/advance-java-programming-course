import java.util.*;

public class PerfectNumber {
    static int countNumber (int n){
        int counter = 0;
        while (n > 0){
            counter ++;
            n /= 10;
        }
        return counter;
    }

    static int reverseNumber(int n){
        int temp_n = n;
        int counter = 0;
        while (temp_n > 0){ 
            counter ++;
            temp_n /= 10;
        }

        int new_int = 0;
        for (int i = counter; i>-1; i--){ 
            new_int += (n%10) * Math.pow(10, i - 1);
            n /= 10;
        }

        return new_int;
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    static boolean isGoodNumber(int n){
        if (countNumber(n) % 2 == 0 && n % 10 == 0) return false;

        int r, counter = 0;

        int newN = reverseNumber(n);

        if (countNumber(n) == 1 || n % 10 == 0) newN = n;

        while (newN>0){
            r = newN % 10;

            if ((r==0 || !isPrime(r)) && counter % 2 == 1){ 
                return false;
            }

            if (r % 2 == 1 && counter % 2 == 0){
                return false;
            }

            newN /= 10;
            counter ++ ;
        }

        return true;

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a, b, counter = 0;
        a = input.nextInt();
        b = input.nextInt();

        for (int i = a + 1; i < b ; i++){
            if (isGoodNumber(i)) {
                System.out.println(i);
                counter ++;
            }
        }

        System.out.println(counter);

        input.close();
    }
}
