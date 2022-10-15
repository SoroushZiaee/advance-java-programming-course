package ir.ac.kntu;

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String email, String office, double baseSalary, int insurance, String officeHours, String rank) {
        super(name, address, phoneNumber, email, office, baseSalary, insurance);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public void teach() {
        System.out.println("wasting students time");
    }


    @Override
    public String toString() {
        return super.toString() + ", Office Hours: " + officeHours + ", Rank: " + rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}