package ir.ac.kntu;

public class Account {
    private String accountNumber;

    private double balance;

    //create constructor in this form:Account(String accountNumber, double balance)
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Change Boolean to void
    public Boolean withDraw(int amount) {
        //complete this function
        return this.balance >= (double)amount;
    }

    public void deposit(int amount) {
        //complete this function
        this.balance += amount;
    }

    //create getter and setter for the fields

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
