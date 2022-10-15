package ir.ac.kntu;

public class Staff extends Organizer {

    private long income;

    public Staff(String name, String lastName, long income) {
        super(name, lastName);
        this.income = income;
    }

    public long getIncome() {
        return income;
    }

    public void setIncome(long income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Income : %s", this.income);
    }
}
