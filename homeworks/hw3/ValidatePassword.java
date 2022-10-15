import java.util.regex.*;
import java.util.*;

public class ValidatePassword {

    static boolean checkPassword(String str) {
        Pattern regexPassword = Pattern.compile(
                "^([2][5-9][0-9]|[3-8][0-9][0-9]|[9][0-4][0-9]|950)-([0-6][0-9]|7[0-5]|[0-9])-([0-9]|[0-9][0-9]|[0-1][0-9][0-9]|2[0-4][0-9]|250)-([2-9])$");
        
        Matcher matchPassword = regexPassword.matcher(str);

        return matchPassword.matches();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++)
            str[i] = in.next().trim();

        // System.out.println(Arrays.toString(str));

        for (String s: str){
            System.out.println(checkPassword(s));
        }

        in.close();
    }

}
