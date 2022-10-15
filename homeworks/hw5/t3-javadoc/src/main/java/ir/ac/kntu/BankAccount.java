package ir.ac.kntu;

import java.util.Scanner;


/**
 * <h1>Bank Account</h1>
 * <p>We Create a bank here to save our money into out account</p>
 *
 * @author Soroush Ziaee
 * @version 1.0
 */
public class BankAccount {

    private static int lastAccountNumber = 0;
    private final int accountNumber;
    private double balance;


    /**
     * <h1>BankAccount</h1>
     * a constructor is written to initialize our variable.
     */
    public BankAccount(double intialBalance) {
        balance = intialBalance;

        accountNumber = lastAccountNumber + 1;
        lastAccountNumber = accountNumber;
    }

    /**
     * This is the main method which makes use BackAccount class.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        BankAccount account = new BankAccount(1000);
        account.deposit(500);
        account.withdraw(50);

        System.out.println("BankAccount " + account.getNumber());
        System.out.println("Has a balance of " + account.getBalance());
    }

    /**
     * <h2>Deposit</h2>
     * <p>We created a deposit function to put our money into our account</p>
     */
    public void deposit(double depositAmount) {
        balance += depositAmount;
    }

    /**
     * <h2>withdraw</h2>
     * <p>We created a deposit function to take out our money from our account</p>
     */
    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount > balance) {
            System.out.println("Insufficient Funds!!!");
            return false;
        } else {
            balance -= withdrawAmount;
            return true;
        }
    }

    /**
     * <h2>getNumber</h2>
     *
     * @return accountNumber
     */
    public int getNumber() {
        return accountNumber;
    }

    /**
     * <h2>getBalance</h2>
     *
     * @return balance
     */
    public double getBalance() {
        return balance;
    }


}
