import java.util.*;

public class HelloWorld {

    static void printHelloWorld(int a){
        for(int i = 0; i<a; i++){
            System.out.println("Hello World!");
        }
    }
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(n>=0){
            printHelloWorld(n);
        }

        else{
            System.out.println("Wrong Input!");
        }
        
        in.close();
    }
}