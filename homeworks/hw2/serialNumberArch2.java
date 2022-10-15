import java.util.*;

public class serialNumberArch2 {

    static String[] reverseList(List<String> list) {
        String[] reverselist = new String[list.size()];

        for (int i = 0; i < reverselist.length; i++) {
            reverselist[i] = list.get(list.size() - i - 1);
        }

        return reverselist;
    }

    static String correctSerialNumber(String str, int k) { 

        String output = "";
        char[] arr = str.replaceAll("-", "").toCharArray();
        int length = arr.length, r;
        List<String> list = new ArrayList<String>();

        while (length > 0) {
            String temp = "";
            r = length - k;

            if (r>=0){
                for (int i = 0; i < k; i++) {
                    temp = temp.concat(Character.toString(arr[length - i - 1]));
                }
            }

            else{
                for (int i = 0; i < (-1*r); i++) {
                    temp = temp.concat(Character.toString(arr[length - i - 1]));
                }
            }


            list.add(temp);
            length -= k;
            
        }

        char[] arrOutput = String.join("-", list).toCharArray();

        for (int i=arrOutput.length - 1; i>-1; i--) {
            output = output.concat(Character.toString(arrOutput[i]));
        }
        
        return output;

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        in.nextLine();
        String str = in.nextLine();

        System.out.println(correctSerialNumber(str, k));

        in.close();
    }
    
}
