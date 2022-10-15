package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {

    protected Database db;

    public Course() {
        this.db = Database.getInstance();
    }

    protected boolean checkPassStudent(Student s, Lesson l) {
        return s.isPassed(l);
    }

    protected void addStudentToGroup(Student s, LessonGroup lg) {
        s.addLessonGroup(lg);
        lg.setStudents(new ArrayList<>(List.of(s)));

        db.updateStudent(s);
        db.updateLessonGroup(lg);
    }

}
