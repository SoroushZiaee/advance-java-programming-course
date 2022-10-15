package ir.ac.kntu;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HospitalTest {
    @Test
    public void testReceiveCostsFunction1(){
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("ali",new Account("122546",2050000)));
        patients.add(new Patient("sara",new Account("554126",3200000)));
        Hospital hospital = new Hospital(new Account("11111",0),null,patients);
        hospital.receiveHospitalCosts();
        double actual = patients.get(0).getAccount().getBalance();
        assertEquals(50000,actual,0.000001);
    }
    @Test
    public void testReceiveCostsFunction2(){
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("ali",new Account("122546",2050000)));
        patients.add(new Patient("sara",new Account("554126",3200000)));
        Hospital hospital = new Hospital(new Account("11111",0),null,patients);
        hospital.receiveHospitalCosts();
        double actual = patients.get(1).getAccount().getBalance();
        assertEquals(1200000,actual,0.000001);
    }
    @Test
    public void testReceiveCostsFunction3(){
        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("ali",new Account("122546",2050000)));
        patients.add(new Patient("sara",new Account("554126",3200000)));
        Hospital hospital = new Hospital(new Account("11111",0),null,patients);
        hospital.receiveHospitalCosts();
        double actual = hospital.getAccount().getBalance();
        assertEquals(4000000,actual,0.000001);
    }
    @Test
    public void testPayDoctorsSalary1(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("ali",new Account("122546",0)));
        doctors.add(new Doctor("sara",new Account("554126",1800000)));
        Hospital hospital = new Hospital(new Account("11111",20000000),doctors,null);
        hospital.payDoctorsSalary();
        double actual = doctors.get(0).getAccount().getBalance();
        assertEquals(8000000,actual,0.000001);
    }
    @Test
    public void testPayDoctorsSalary2(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("ali",new Account("122546",0)));
        doctors.add(new Doctor("sara",new Account("554126",1800000)));
        Hospital hospital = new Hospital(new Account("11111",20000000),doctors,null);
        hospital.payDoctorsSalary();
        double actual = doctors.get(1).getAccount().getBalance();
        assertEquals(9800000,actual,0.000001);
    }
    @Test
    public void testPayDoctorsSalary3(){
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("ali",new Account("122546",0)));
        doctors.add(new Doctor("sara",new Account("554126",1800000)));
        Hospital hospital = new Hospital(new Account("11111",20000000),doctors,null);
        hospital.payDoctorsSalary();
        double actual = hospital.getAccount().getBalance();
        assertEquals(4000000,actual,0.000001);
    }
}
