package ir.ac.kntu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Student class to store student data
 *
 * @author Soroush Ziaee
 * @version 2 3, Jan, 2022
 */

public class Student extends Person{
    private final HashMap<Integer, Double> passedLessons;
    private int maxUnit = 20;

    public Student(String name, String lastname, int id, String pass) {
        super(name, lastname, id, pass);
        this.passedLessons = new HashMap<>();
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




    /**
     * Check if the student pass a lesson or not
     *
     * @param l
     * @return
     */
    public boolean isPassed(Lesson l) {
        return this.passedLessons.containsKey(l.getLessonId());
    }

    /**
     * Add a lesson to lesson group
     *
     * @param lg
     */
    @Override
    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
        setMaxUnit(getMaxUnit() - 1);
    }


    public void showStudentGrades(){
        double avg = 0;
        for (Map.Entry<Integer, Double> map: this.passedLessons.entrySet() ){
            avg += map.getValue();
            System.out.println("\t- id : " + map.getKey() + " grade : " + map.getValue());
        }

        System.out.println("\t - Average : " + avg  / this.passedLessons.size());
    }

    /**
     * Remove a class and save it to a file and wait for admin to accept
     * @param lessonGroup
     * @throws IOException
     */
    public void requestRemoveLesson(LessonGroup lessonGroup) throws IOException {
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("Database/requests/requests.txt", true)
        );

        bw.write(String.format("%d %d %d\n", getId(), lessonGroup.getLessonId(), 0));
        bw.close();
    }

    public Object clone() {
        Student aStudent = new Student(getName(), getLastname(), getId(), getPass());
        aStudent.setLessonGroups(getLessonGroups());
        aStudent.setPassedLessons(getPassedLessons());
        return aStudent;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + getName() + '\'' + ", lastname='" + getLastname() + '\'' + ", studentId=" + getId() + ", loginStatus=" + isLogin() + '}';

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
        return getId() == student.getId();
    }
}
