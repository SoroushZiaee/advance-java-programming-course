import java.util.*;

public class serialNumberArch1 {

    static char[] preprocessStr(String str) {
        return str.replaceAll("-", "").toCharArray();
    }

    static List<Integer> countSection(int length, int k){
        List<Integer> result = new ArrayList<Integer>();
        int r;
        while (length > 0) {
            r = length - k;

            if (r >= 0){
                result.add(k);
            }

            else{ 
                result.add(-1 * (length - k));
            }

            length -= k;
        }   

        return result;
    }
 
    static List<String> orderSerial(char[] c, int k){
        List<String> output = new ArrayList<String>();
        List<Integer> result = countSection(c.length, k);

        int length = c.length;
        for (int section: result){
            List<String> temp = new ArrayList<String>();
            String[] reverseTemp;
            for (int i = 0; i<section; i++){
                temp.add(Character.toString(c[length - i - 1]));
            }

            reverseTemp = reverseList(temp);
            output.add(String.join("", reverseTemp));
            length -= section;
        }

        return output;
    }

    static String[] reverseList(List<String> list) {
        String[] reverselist = new String[list.size()];

        for (int i = 0; i < reverselist.length; i++) {
            reverselist[i] = list.get(list.size() - i - 1);
        }

        return reverselist;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        String[] output = reverseList(orderSerial(preprocessStr(str), k));
        
        System.out.println(String.join("-", output));

        in.close();
    }
    
}
