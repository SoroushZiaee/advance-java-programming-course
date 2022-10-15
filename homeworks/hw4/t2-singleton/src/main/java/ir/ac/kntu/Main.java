package ir.ac.kntu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.info("The logger get successfully");
        Scanner scanner = new Scanner(System.in);
        int a = 10;
        int b = 10;
        int c, d;
        double f;
        try {
            a = Integer.parseInt(scanner.nextLine().trim());
            c = Integer.parseInt(scanner.nextLine().trim());
            d = Integer.parseInt(scanner.nextLine().trim());
            f = c / d;
        } catch (ArithmeticException exception) {
            logger.error(exception.getMessage());
        } finally {
            logger.info("Get Number SuccessFully");
        }
        try {
            b = Integer.parseInt(scanner.nextLine().trim());
        } catch (Exception e) {
            logger.warn(e.getMessage());
        } finally {
            System.out.println("a / b: " + a / b);
        }
        System.out.println("Information: " + logger.getInfo());
        System.out.println("Warnings: " + logger.getWarns());
        System.out.println("Errors: " + logger.getErrors());
    }
}