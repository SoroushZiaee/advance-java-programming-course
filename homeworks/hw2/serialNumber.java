import java.util.*;


public class serialNumber {

    static String createSerialNumber(String str, int k){

        String output = "", tempStr = str.replaceAll("-", "");
        int counter = 0,len = tempStr.length();

        while (len != 0) {
            if (counter == k & k!=0){ 
                output = "-".concat(output);
                counter = 0;
            }

            output = Character.toString(tempStr.charAt(len - 1)).concat(output);
            

            len --;
            counter ++;
        }
        

        return output;
    }

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        System.out.println(createSerialNumber(str, k));

        in.close();
        
    }
    
}
