package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Course {

    private String name;
    private List<Student> students;

    public Course(){
        students = new ArrayList<Student>();
    }

    public String getName() { return name; }
    public void setName(String str) { this.name = str; }
    
    public List<Student> getStudents() { return students; }


    public void addStudent(Student s){
        this.students.add(s);
    }

    public Student getMaxStudent(){
        Collections.sort(this.students);
        Student student = this.students.get(students.size() - 1);
        return student;
    }

    public Student getMinStudent(){
        Collections.sort(this.students);
        Student student = this.students.get(0);
        return student;
    }

    public double getAvg(){ 
        double avg=0;

        for (Student student: this.students){ 
            avg += student.getAvg();
        }

        return avg / this.students.size();

    }

    
}
