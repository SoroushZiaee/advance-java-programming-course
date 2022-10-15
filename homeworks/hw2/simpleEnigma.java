import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class simpleEnigma {
    static int charToInt(char c){
        char temp = Character.toLowerCase(c);

        switch(temp){
            case 'a':
                return 1;
            
            case 'b':
                return 2;
        
            case 'c':
                return 3;
            
            case 'd':
                return 4;

            case 'e':
                return 5;
            
            case 'f':
                return 6;
        
            case 'g':
                return 7;
            
            case 'h':
                return 8;

            case 'i':
                return 9;
            
            case 'j':
                return 10;
        
            case 'k':
                return 11;
            
            case 'l':
                return 12;

            case 'm':
                return 13;
            
            case 'n':
                return 14;
        
            case 'o':
                return 15;
            
            case 'p':
                return 16;
            
            case 'q':
                return 17;
            
            case 'r':
                return 18;
        
            case 's':
                return 19;
            
            case 't':
                return 20;

            case 'u':
                return 21;
            
            case 'v':
                return 22;
        
            case 'w':
                return 23;
            
            case 'x':
                return 24;

            case 'y':
                return 25;
            
            case 'z':
                return 26;
        }

        return 0;
    }

    static char intToChar(int i){
        switch(i){ 
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            case 9:
                return 'I';
            case 10:
                return 'J';
            case 11:
                return 'K';
            case 12:
                return 'L';
            case 13:
                return 'M';
            case 14:
                return 'N';
            case 15:
                return 'O';
            case 16:
                return 'P';
            case 17:
                return 'Q';
            case 18:
                return 'R';
            case 19:
                return 'S';
            case 20: 
                return 'T';
            case 21: 
                return 'U';
            case 22:
                return 'V';
            case 23:
                return 'W';
            case 24:
                return 'X';
            case 25:
                return 'Y';
            case 26:
                return 'Z';
        }

        return '0';
    }

    static void changeEnigmaOrder(int[] router){
        int temp, MAX = 26;
        for (int i=0; i<router.length; i++){
            temp = router[i] - 1;
            if (temp == 0)
                router[i] = MAX;
            
            else
                router[i] = temp;
        }
    }

    static List<String> enigmaMachine(String str, int[] router1, int[] router2, int[] router3){
        char[] charArr = str.toCharArray();
        int c1 = 0;
        int c2 = 0;
        // System.out.println(Arrays.toString(charArr));
        List<String> output = new ArrayList<String>();

        for (char c: charArr){
            if (c == ' '){
                output.add(Character.toString(' '));
            }
            else{
                int idx = charToInt(c);
                idx -= 1; // normalize the idx to feed into out arrays
                
                // System.out.println(idx);
                idx = router1[idx] - 1;
                // System.out.println(idx);
                idx = router2[idx] - 1;
                // System.out.println(idx);
                idx = router3[idx];

                output.add(Character.toString(intToChar(idx)));

                c1 += 1;
                changeEnigmaOrder(router1);

                if (c1 == 26){
                    changeEnigmaOrder(router2);
                    c2 += 1;
                    c1 = 0;
                }

                if (c2 == 26){
                    changeEnigmaOrder(router3);
                    c2 = 0;
            }

        }
    }

        return output;
    }

    static int[] mapStrToInt(String str) {
        String[] temp = str.split(" ");
        int[] output = new int[temp.length];

        int i = 0;
        for (String s: temp){ 
            output[i] = Integer.parseInt(s);
            i ++;
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // int[] router1 = {2, 1, 3, 4, 5};
        // int[] router2 = {1, 2, 3, 4, 5};
        // int[] router3 = {1, 3, 2, 5, 4};

        int[] router1 = mapStrToInt(in.nextLine());
        int[] router2 = mapStrToInt(in.nextLine());
        int[] router3 = mapStrToInt(in.nextLine());

        String str = in.nextLine();

        List<String> output = enigmaMachine(str, router1, router2, router3);

        System.out.println(String.join("", output));

        // for (String o: output){
        //     System.out.println(o);
        // }

        in.close();

        // System.out.println(Arrays.toString(router1));
        // changeEnigmaOrder(router1);
        // System.out.println(Arrays.toString(router1));
        // changeEnigmaOrder(router1);
        // System.out.println(Arrays.toString(router1));
        // changeEnigmaOrder(router1);
        // System.out.println(Arrays.toString(router1));
        // changeEnigmaOrder(router1);
        // System.out.println(Arrays.toString(router1));
        // changeEnigmaOrder(router1);
        // System.out.println(Arrays.toString(router1));


        // char c = 'a';
        // int i = 26;
        // System.out.println(charToInt(c));
        // System.out.println(intToChar(i));


    }
    
}
