package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

/**
 * Prof class to store student data
 *
 * @author Soroush Ziaee
 * @version 2 3, Jan, 2022
 */
public class Prof extends Person {

    public Prof(String name, String lastname, int id, String pass) {
        super(name, lastname, id, pass);
    }


    public void removeGroupLesson(LessonGroup lg) {
        for (LessonGroup lesson : this.lessonGroups) {
            if (lesson.equals(lg)) {
                this.lessonGroups.remove(lg);
                break;
            }
        }
    }


    /**
     * Write the professor group classes
     */
    public void showGroupLesson() {
        System.out.println("Professor lesson : ");
        for (LessonGroup lessonGroup : this.lessonGroups) {
            System.out.println("\t - " + lessonGroup);
        }
    }

    /**
     * Show Student of each lesson
     */
    public void showStudentOfEachLesson() {
        for (LessonGroup lessonGroup : this.lessonGroups) {
            System.out.println("- " + lessonGroup);
            ArrayList<Student> students = new ArrayList<>(List.of(new Student("a", "A", 9728143, "12345678")));
            for (Student student : lessonGroup.getStudents()) {
                System.out.println("\t - " + student);
            }
        }
    }

    // Implement it
    public void setGradeStudent(Student student, int lessonId, Double grade) {
        System.out.println(String.format("Student : %d, LessonId : %d, Grade : %f", student.getId(), lessonId, grade));
    }


    @Override
    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
    }


    public Object clone() {
        Prof prof = new Prof(getName(), getLastname(), getId(), getPass());
        prof.setLessonGroups(getLessonGroups());
        return prof;
    }

    @Override
    public String toString() {
        return "Prof{" + "name='" + getName() + '\'' + ", lastName='" + getLastname() + '\'' + ", profId=" + getId() + ", loginStatus=" + isLogin() + '}';
    }
}
