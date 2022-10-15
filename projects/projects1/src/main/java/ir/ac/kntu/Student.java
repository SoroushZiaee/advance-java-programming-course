package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student {
    private final HashMap<Integer, Double> passedLessons;
    private final ArrayList<LessonGroup> lessonGroups;
    private String name;
    private String lastname;
    private int studentId;
    private String pass;
    private int maxUnit = 20;
    private boolean loginStatus;
    private final UniqueVariable unique = UniqueVariable.getInstance();

    public Student() {
        this.passedLessons = new HashMap<>();
        this.lessonGroups = new ArrayList<>();
    }

    public Student(String name, String lastname, int studentId, String pass) {
        this.name = name;
        this.lastname = lastname;
        this.studentId = studentId;
        this.pass = pass;
        this.passedLessons = new HashMap<>();
        this.lessonGroups = new ArrayList<>();
        unique.setUniqueStudentId(new ArrayList<>(List.of(this.studentId)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        System.out.println(studentId + " Real Student Id");
        boolean isUnique = !unique.getUniqueStudentId().contains(studentId);

        if (isUnique) {
            this.studentId = studentId;
        } else {
            System.out.println("Choose another studentId");
            this.studentId = 0;
        }

    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getMaxUnit() {
        return maxUnit;
    }

    public void setMaxUnit(int maxUnit) {
        if (maxUnit <= 0) {
            this.maxUnit = 0;
        } else {
            this.maxUnit = maxUnit;
        }
    }

    public HashMap<Integer, Double> getPassedLessons() {
        return passedLessons;
    }

    public void setPassedLessons(HashMap<Integer, Double> passedLessons) {
        this.passedLessons.putAll(passedLessons);
    }

    public ArrayList<LessonGroup> getLessonGroups() {
        ArrayList<LessonGroup> newLessonGroup = new ArrayList<LessonGroup>();
        for (LessonGroup lg : this.lessonGroups) {
            newLessonGroup.add((LessonGroup) lg.clone());
        }
        return newLessonGroup;
    }

    public void setLessonGroups(ArrayList<LessonGroup> lessonGroup) {
        for (LessonGroup lg : lessonGroup) {
            this.lessonGroups.add((LessonGroup) lg.clone());
        }
    }

    public void login(int studentId, String pass) {
        this.loginStatus = (this.pass.equals(pass) && studentId == getStudentId());
        if (!this.loginStatus) {
            System.out.println("The Password or Username is wrong");
        }
    }

    public boolean isLogin() {
        return loginStatus;
    }

    public void editPass(String oldPass, String newPass) {
        if (oldPass.equals(getPass())) {
            setPass(newPass);
        } else {
            System.out.println("Can't Change the password");
        }
    }

    public void logout() {
        this.loginStatus = false;
    }


    public void removeGroupLesson(LessonGroup lg) {
        for (LessonGroup lesson : this.lessonGroups) {
            if (lesson.equals(lg)) {
                this.lessonGroups.remove(lg);
                break;
            }
        }
    }

    public boolean isPassed(Lesson l) {
        return this.passedLessons.containsKey(l.getLessonId());
    }

    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
        setMaxUnit(getMaxUnit() - 1);
    }

    public Object clone() {
        Student aStudent = new Student(this.name, this.lastname, this.studentId, this.pass);
        aStudent.login(this.studentId, this.pass);
        return aStudent;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", lastname='" + lastname + '\'' + ", studentId=" + studentId + ", loginStatus=" + loginStatus + '}';

//        return String.format("%s %s | %d | ", getName(), getLastname(), getStudentId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return studentId == student.studentId;
    }
}
