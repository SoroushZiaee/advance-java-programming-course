import java.util.*;


public class GoodNumber {

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

    static boolean isPrime(int n){
        if (n==1) return false;

        for (int i=2; i<=Math.sqrt(n); i++)
            // System.out.println(i);
            if (n%i == 0)
                return false;
        

        return true;
    }

    static int count(int x){
        int counter = 0;
        while (x>0){ 
            counter ++;
            x/=10;
        }
        return counter;
    }

    static boolean isGoodNumber(int n){
        int counter;
        if (n % 10 ==0){ 
            int temp = count(n);
            if (temp%2==0){
                return false;
            }

            counter = 0;
            while(n>0){
                int r = n % 10;
                if ((r==0 || !isPrime(r)) && counter%2==1){
                    // System.out.println("r : " + r + " counter : " + counter);
                    return false;
                }

                else if (r%2==1 && counter%2==0) { 
                    // System.out.println("r : " + r + " counter : " + counter);
                    return false;
                }

                n /= 10;
                counter ++;
            }

            return true;
        }
        else{
            n = reverseNumber(n);
            counter = 0;
            while(n>0){
                int r = n % 10;
                if ((r==0 || !isPrime(r)) && counter%2==1){
                    // System.out.println("r : " + r + " counter : " + counter);
                    return false;
                }

                else if (r%2==1 && counter%2==0) { 
                    // System.out.println("r : " + r + " counter : " + counter);
                    return false;
                }

                n /= 10;
                counter ++;
            }

            return true;
        }
    }
    public static void main(String args[]) {



        Scanner in = new Scanner(System.in);
        // int n = reverseNumber(in.nextInt());
        // System.out.println(isGoodNumber(n));
        int a = in.nextInt();
        int b = in.nextInt();

        int n = 0;
        for (int i=a+1; i<b; i++){ 
            if (isGoodNumber(i)) {
                // System.out.println("i : " + i);
                n ++;
            }
        }
        System.out.println(n);
        // int n = in.nextInt();
        // System.out.println(isPrime(n));

        // int n = 10923;
        // n = reverseNumber(n);
        // System.out.println(n);
        in.close();
    }
}
