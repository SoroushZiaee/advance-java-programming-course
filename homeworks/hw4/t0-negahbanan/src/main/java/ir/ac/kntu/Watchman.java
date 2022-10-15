package ir.ac.kntu;

import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Watchman {
    public static int watchManNumber = 0;
    private final int workerNumber;
    private final String id;
    private String name;
    private String lastName;
    private String city;
    private String phoneNumber;
    private String email;

    public Watchman(String name, String lastName, String city, String social) {
        this.workerNumber = Watchman.watchManNumber;
        this.id = getAlphaNumericString(8);

        if (checkName(name)) {
            this.name = name;
        } else {
            this.name = null;
        }

        if (checkName(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = null;
        }
        this.city = city;

        if (social.contains("@")) {
            if (checkEmail(social)) {
                this.email = social;
            } else {
                this.email = null;
            }
        } else {
            if (checkPhoneNumber(social)) {
                this.phoneNumber = social;
            } else {
                this.phoneNumber = null;
            }
        }

        // Add The Worker
        Watchman.watchManNumber += 1;
    }

    // Create Random 8 String
    static String getAlphaNumericString(int n) {

        // length is bounded by 256 Character
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, StandardCharsets.UTF_8);

        // Create a StringBuffer to store the result
        StringBuffer r = new StringBuffer();

        // remove all spacial char
        String alphaNumericString
                = randomString
                .replaceAll("[^A-Za-z0-9]", "");

        // Append first 20 alphanumeric characters
        // from the generated random String into the result
        for (int k = 0; k < alphaNumericString.length(); k++) {

            if (Character.isLetter(alphaNumericString.charAt(k))
                    && (n > 0)
                    || Character.isDigit(alphaNumericString.charAt(k))
                    && (n > 0)) {

                r.append(alphaNumericString.charAt(k));
                n--;
            }
        }

        // return the resultant string
        return r.toString();
    }

    // Check Name & LastName
    static Boolean checkName(String str) {
        Pattern regexEmail = Pattern.compile("[a-zA-Z]+");
        Matcher checkEmail = regexEmail.matcher(str);
        return checkEmail.matches();
    }

    // Check Email
    static Boolean checkEmail(String email) {
        Pattern regexEmail = Pattern.compile("^[a-zA-Z][0-9a-zA-Z\\.]+@[a-zA-Z]+(\\.)[a-zA-Z]+$");
        Matcher checkEmail = regexEmail.matcher(email);
        return checkEmail.matches();
    }

    // Check Phone Number
    static boolean checkPhoneNumber(String str) {
        Pattern regexPhoneNumber = Pattern.compile("^(09|9)[0-9]{2}?[0-9]{3}?[0-9]{4}$");
        Matcher checkPhoneNumber = regexPhoneNumber.matcher(str);

        return checkPhoneNumber.matches();
    }

    public int getWorkerNumber() {
        return workerNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkName(name)) {
            this.name = name;
        } else {
            this.name = getName();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (checkName(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = this.getLastName();
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (checkPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = this.getPhoneNumber();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (checkEmail(email)) {
            this.email = email;
        } else {
            this.email = this.getEmail();
        }
    }


}
