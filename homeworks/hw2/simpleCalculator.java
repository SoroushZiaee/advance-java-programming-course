import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class simpleCalculator {

    // Delete WhiteSpace
    static String deleteWhiteSpace(String s) {
        return s.replaceAll("\\s+", "");
    }

    // i.e. -1+12-43+-10 ---> [-1, +12, -43, -10]
    static List<String> advanceSplit(String str){
        List<String> output = new ArrayList<String>();

        Pattern pattern = Pattern.compile("[-+][0-9]+");
        Matcher matcher = pattern.matcher(str);

        while(matcher.find()) {
            output.add(matcher.group(0));
        }

        return output;
    }

    

    static int calculator(String str){
        int output = 0;
        String newStr;
        if (str.charAt(0) != '-'){
            newStr = deleteWhiteSpace("+".concat(str));
        }
        else{ 
            newStr = deleteWhiteSpace(str);
        }


        List<String> list;
        list = advanceSplit(newStr);


        for(String s: list)
            output += Integer.parseInt(s);
        
        return output;
    }



    public static void main( String[] args ) {

        Scanner in = new Scanner(System.in);
        
        String str = in.nextLine();

        System.out.println(calculator(str));

        in.close();
        
    }
    
}
