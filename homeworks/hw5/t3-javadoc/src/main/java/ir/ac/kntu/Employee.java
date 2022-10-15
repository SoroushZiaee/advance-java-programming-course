package ir.ac.kntu;


/**
 * <h1>Employee</h1>
 * <p>We create a company that we need to store our employees detail in such this classes</p>
 *
 * @author Soroush Ziaee
 * @version 1.0
 */
public class Employee {
    private String lastName;
    private String firstName;
    private Double salaryPerHour;
    private int workedHours;


    /**
     * <h1>Employee</h1>
     * a constructor is written to initialize our variable.
     */
    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }


    /**
     * <h1>Employee</h1>
     * a constructor is written to constrcut our object.
     */
    public Employee() {
    }

    /**
     * <h1>Calculate Gross Salary</h1>
     * <p>Calculate our pure salary without substract any tax or insurance from it.</p>
     *
     * @return
     */
    public Double calculateGrossSalary() {
        return salaryPerHour * workedHours;
    }

    /**
     * <h1>Calculate Net Salary</h1>
     * <p>Calculate our pure salary by subtracting tax or insurance from it.</p>
     *
     * @param insurance
     * @param taxRate
     * @return
     */
    public Double calculateNetSalary(Double insurance, Double taxRate) {
        Double grossSalary = salaryPerHour * workedHours;

        return grossSalary - (insurance * grossSalary - taxRate * grossSalary);

    }

    /**
     * Get the Employee last name
     *
     * @return
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set the Employee last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the Employee name
     *
     * @return
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set the Employee name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the Employee Salary rate
     *
     * @return
     */
    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    /**
     * Set the Employee Salary rate
     *
     * @param salaryPerHour
     */
    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    /**
     * Get Employee worked Hour
     *
     * @return
     */
    public int getWorkedHours() {
        return workedHours;
    }

    /**
     * Set Employee Worked Hour
     *
     * @param workedHours
     */
    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }
}
