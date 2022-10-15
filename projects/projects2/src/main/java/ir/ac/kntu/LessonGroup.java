package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;

public class LessonGroup extends Lesson {
    private final ArrayList<Student> students;
    private final ArrayList<Prof> profs;
    private final HashMap<Integer, Double> grades;
    private int lessonGroupId;
    private Schedule schedule;
    private int lessonCapacity;
    private int term;

    public LessonGroup(String lessonName) {
        super(lessonName);
        this.students = new ArrayList<>();
        this.profs = new ArrayList<>();
        grades = new HashMap<>();
    }

    public LessonGroup(int lessonId) {
        super(lessonId);
        this.students = new ArrayList<>();
        this.profs = new ArrayList<>();
        grades = new HashMap<>();
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public int getLessonGroupId() {
        return lessonGroupId;
    }

    public void setLessonGroupId(int lessonGroupId) {
        this.lessonGroupId = lessonGroupId;
    }

    public int getLessonId() {
        return super.getLessonId();
    }

    public void setLessonId(int lessonId) {
        super.setLessonId(lessonId);
    }

    // Delete
    public int getLessonCapacity() {
        return lessonCapacity;
    }

    // Delete
    public void setLessonCapacity(int lessonCapacity) {
        if (lessonCapacity <= 0) {
            this.lessonCapacity = 0;
        } else {
            this.lessonCapacity = lessonCapacity;
        }
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> newStudent = new ArrayList<>();
        for (Student s : this.students) {
            newStudent.add((Student) s.clone());
        }
        return newStudent;
    }

    public void setStudents(ArrayList<Student> studentList) {
        for (Student s : studentList) {
            if (getLessonCapacity() > 0) {
                this.students.add((Student) s.clone());
                setLessonCapacity(getLessonCapacity() - 1);
            } else {
                break;
            }

        }
    }

    public ArrayList<Prof> getProfs() {
        ArrayList<Prof> newProf = new ArrayList<>();
        for (Prof p : this.profs) {
            newProf.add((Prof) p.clone());
        }
        return newProf;
    }

    public void setProfs(ArrayList<Prof> profList) {
        for (Prof p : profList) {
            this.profs.add((Prof) p.clone());
        }
    }

    public Object clone() {
        LessonGroup lessonGroup = new LessonGroup(this.getLessonId());
        lessonGroup.setLessonName(getLessonName());
        lessonGroup.setSchedule(getSchedule());
        lessonGroup.setLessonGroupId(getLessonGroupId());
        lessonGroup.setLessonCapacity(getLessonCapacity());
        lessonGroup.setStudents(getStudents());
        lessonGroup.setProfs(getProfs());
        lessonGroup.setTerm(getTerm());
        return lessonGroup;
    }

    public void addStudentGrade(Integer studentId, Double grade) {
        grades.put(studentId, grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LessonGroup)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        LessonGroup that = (LessonGroup) o;
        return getLessonGroupId() == that.getLessonGroupId() || getLessonId() == that.getLessonId();
    }

    // implement in those two classes


    public boolean compareTo(LessonGroup other) {
        return this.schedule.compareTo(other.getSchedule()) >= 0;
    }

    @Override
    public String toString() {
//        return "LessonGroup{" +
//                "lessonGroupId=" + lessonGroupId +
//                ", lessonId=" + getLessonId() +
//                ", schedule=" + schedule +
//                ", lessonCapacity=" + lessonCapacity +
//                ", term=" + term +
//                '}';

        return "Name : " + getLessonName() + " Id : " + getLessonId() + " Time : " + getSchedule() + " Capacity : " + getLessonCapacity();


    }


}
