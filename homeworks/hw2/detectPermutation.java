import java.util.*;

class detectPermutation{

    // First convert the string to char list
    // Second create nested for loop
    // If one of the element isn't in that list return false
    // also if the count of word isn't correct return false
    // else return true 

    static boolean isPermutations(String str1, String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();


        for (char c: ch1)
            if (str2.indexOf(c) == -1)
                return false; 
            
            else if (countWords(str1, c) != countWords(str2, str2.charAt(str2.indexOf(c)))) 
                return false;

        for (char c: ch2)
            if (str1.indexOf(c) == -1)
                return false; 
        
        return true;
    }

    static int countWords(String str, char c){
        int counter = 0;
        for (char c1: str.toCharArray())
            if (c == c1)
                counter++;

        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);    

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        if (isPermutations(str1, str2)) 
            System.out.println("True");
        
        else
            System.out.println("False");

        in.close();

        
    }
}