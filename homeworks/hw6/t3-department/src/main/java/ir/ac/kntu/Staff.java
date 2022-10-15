package ir.ac.kntu;

class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String email, String office, double baseSalary, int insurance, String title) {
        super(name, address, phoneNumber, email, office, baseSalary, insurance);
        this.title = title;
    }

    private void beUseful() {
        System.out.println("i don't think i will");
    }

    @Override
    public String toString() {
        return super.toString() + ", Title: " + title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}