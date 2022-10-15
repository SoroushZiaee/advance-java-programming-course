package ir.ac.kntu;

public class Job {
    private String jobName;
    private int income;

    public Job(String jobName, int income) {
        this.jobName = jobName;
        this.income = income;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobName='" + jobName + '\'' +
                ", income=" + income +
                '}';
    }
}
