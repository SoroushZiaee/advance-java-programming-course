package ir.ac.kntu;

public class Student implements Comparable<Student> {

    private String id;
    private String name;
    private Double avg;

    public String getId() { return id; }
    public void setId(String str) { this.id = str; }

    public String getName() { return name; }
    public void setName(String str) { this.name = str; }

    public Double getAvg() { return avg; }
    public void setAvg(Double v) { this.avg = v;}

    @Override
    public int compareTo(Student student){
        return getAvg().compareTo(student.getAvg());
    }

    public String toString(){
        return "Student : " + this.name + " With Id : " + this.id + " Avg : " + this.avg;
    }
    
}
