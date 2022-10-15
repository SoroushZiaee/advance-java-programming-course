package ir.ac.kntu;

public class Doctor {
    private String name;

    private Account account;

    //create constructor in this form:Doctor(String name, Account account)
    public Doctor(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    //create getter and setter for the fields


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
