import java.util.Scanner;

class countWords{
    
    // Convert all non-words to whitespace
    // Trim all whitespaces
    // split by " "
    // count the list
    static String removeNonWords(String str){
        return str.replaceAll("[^a-zA-Z]+", " ");
    }

    static String trimString(String str){
        return str.replace("  ", " ");
    }

    static int countingWords(String str){

        // Check if we have String or not
        boolean atleastOneAlpha = str.matches(".*[a-zA-Z]+.*");
        
        if (atleastOneAlpha){
            String temp = trimString(removeNonWords(str)).trim();
            return temp.split(" ").length;
        }

        return 0;
        
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine();
        System.out.println(countingWords(str));
        in.close();

    }
}