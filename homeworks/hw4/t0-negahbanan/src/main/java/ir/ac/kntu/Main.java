package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        Watchman watchman = new Watchman("soroush", "ziaee", "tehran", "szsoroush@gmail.com");
        System.out.println(watchman.getPhoneNumber());
        System.out.println(watchman.getId());
        System.out.println(watchman.getLastName());

    }
}