import java.util.regex.*;
import java.util.*;


class RegistrationForm{

    static boolean checkNameLast(String str){
        str = str.trim();
        Pattern regexUsername = Pattern.compile("^[A-Z][a-z]{1,9}\\s{1}[a-z]{1,15}$");
        Matcher checkUsername = regexUsername.matcher(str);
        return checkUsername.matches();
    }

    static boolean checkEmail(String str){
        Pattern regexEmail = Pattern.compile("^[a-zA-Z][0-9a-zA-Z\\.]+@[a-zA-Z]+(\\.)[a-zA-Z]+$");

        Matcher checkEmail = regexEmail.matcher(str);

        return checkEmail.matches();
    }

    static boolean checkPhoneNumber(String str){
        Pattern regexPhoneNumber = Pattern.compile("^(09|9)[0-9]{2}?[0-9]{3}?[0-9]{4}$");
        Matcher checkPhoneNumber = regexPhoneNumber.matcher(str);

        return checkPhoneNumber.matches();
    }

    static boolean checkPassword(String str){
        Pattern regexPassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
        Matcher checkPassword = regexPassword.matcher(str);

        return checkPassword.matches();
    }

    static boolean validateForm(String [] detailForm){ 
        if (!checkNameLast(detailForm[0])) {
            // System.out.println(detailForm[0]);
            return false;
        }
        if (!checkEmail(detailForm[1])) {
            // System.out.println(detailForm[1]);
            return false;
        }
        if (!checkPhoneNumber(detailForm[2])) {
            // System.out.println(detailForm[2]);
            return false;
        }
        if (!checkPassword(detailForm[3])) {
            // System.out.println(detailForm[3]);
            return false;
        }

        return true;
    }
    public static void main(String[] args){ 
        // String username = "Mohammad yazdi";
        // String email = "szsoroush@gmail.com";
        // String phonenumber = "9126454125";
        // String password = "Soroush.ziaee1";
        // System.out.println(checkNameLast(username));
        // System.out.println(checkEmail(email));
        // System.out.println(checkPhoneNumber(phonenumber));
        // System.out.println(checkPassword(password));

        Scanner in = new Scanner(System.in);
        String[] str = new String[4];

        
        for (int i =0; i<str.length; i++) 
            str[i] = in.nextLine().trim();
        
        // System.out.println(Arrays.toString(str));

        if (validateForm(str)) System.out.println("Successful");
        else System.out.println("Invalid");

        in.close();


    }
}