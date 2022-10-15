package ir.ac.kntu;

import java.util.ArrayList;

public class Hospital {
    private final int hospitalCosts = 2000000;

    private final int doctorsSalary = 8000000;
    private final ArrayList<Doctor> doctors;
    private final ArrayList<Patient> patients;
    private Account account;

    // complete the fields and complete constructor in this form:
    public Hospital(Account account, ArrayList<Doctor> doctors, ArrayList<Patient> patients) {
        // todo
        this.account = account;
        this.doctors = doctors;
        this.patients = patients;
    }

    //create getter and setter functions
    //!!!Attention!!! do not write getter function for ArrayLists


    public int getDoctorsSalary() {
        return doctorsSalary;
    }

    public int getHospitalCosts() {
        return hospitalCosts;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setPatients(Patient patient) {
        this.patients.add(patient);
    }

    public void setDoctors(Doctor doctor) {
        this.doctors.add(doctor);
    }

    public void receiveHospitalCosts() {
        //complete this function
        for (Patient p : this.patients) {
            Account patientAccount = p.getAccount();
            if (patientAccount.withDraw(hospitalCosts)) {
                // Set the balance of Patient if patient has enough money
                patientAccount.setBalance(patientAccount.getBalance() - hospitalCosts);
                // Deposit money to bank account
                this.getAccount().deposit(hospitalCosts);
            }
        }
    }

    public void payDoctorsSalary() {
        //complete this function
        for (Doctor d : this.doctors) {
            Account doctorAccount = d.getAccount();
            if (this.getAccount().withDraw(doctorsSalary)) {
                // Set the balance of Patient if patient has enough money
                doctorAccount.deposit(doctorsSalary);
                // Deposit money to bank account
                this.getAccount().setBalance(this.getAccount().getBalance() - doctorsSalary);
            }
        }
    }
}
