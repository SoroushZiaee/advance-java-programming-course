package ir.ac.kntu;

class Employee extends Person {
    private String office;
    private double baseSalary;
    private int insurance;

    public Employee(String name, String address, String phoneNumber, String email, String office, double baseSalary, int insurance) {
        super(name, address, phoneNumber, email);
        this.office = office;
        this.baseSalary = baseSalary;
        this.insurance = insurance;
    }

    protected void getPaid() {
        System.out.println("business is boomin");
    }

    protected void getRaise(int raise) {
        baseSalary += baseSalary * raise / 100;
    }

    protected void getPromotion(String newPosition) {
        System.out.println("Congratulations!");
        System.out.println("You just promoted to " + newPosition + " position!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + getSalary() + ", Office: " + office;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public double getSalary() {
        return baseSalary * (100 - insurance) / 100;
    }
}