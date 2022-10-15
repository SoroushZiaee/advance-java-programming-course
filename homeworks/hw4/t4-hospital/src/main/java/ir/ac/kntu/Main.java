package ir.ac.kntu;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("ali",new Account("122546",2050000)));
        patients.add(new Patient("sara",new Account("554126",3200000)));
        Hospital hospital1 = new Hospital(new Account("11111",0),null,patients);
        hospital1.receiveHospitalCosts();
        double actual = patients.get(0).getAccount().getBalance();
        System.out.println("Hospital1 Balance : ");
        System.out.println(hospital1.getAccount().getBalance());
        System.out.println("Patients Balance : ");
        for (Patient p: patients)
            System.out.println(p.getAccount().getBalance());

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("ali",new Account("122546",0)));
        doctors.add(new Doctor("sara",new Account("554126",1800000)));
        Hospital hospital2 = new Hospital(new Account("11111",20000000),doctors,null);
        hospital2.payDoctorsSalary();
        System.out.println("Hospital2 Balance : ");
        System.out.println(hospital2.getAccount().getBalance());
        System.out.println("Doctors Balance : ");
        for (Doctor d: doctors)
            System.out.println(d.getAccount().getBalance());

    }
}