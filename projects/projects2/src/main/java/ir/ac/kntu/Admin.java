package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Admin extends Person {
    Database db = Database.getInstance();
    private final ArrayList<String[]> studentsRequest = new ArrayList<>();

    public Admin(String name, String lastname, int id, String pass) {
        super(name, lastname, id, pass);
    }

    @Override
    public void addLessonGroup(LessonGroup lg) {
        db.setLessonGroups(
                new ArrayList<LessonGroup>(
                        List.of(lg)
                )
        );
    }

    public void addStudent(Student student) {
        db.setStudents(
                new ArrayList<Student>(
                        List.of(student)
                )
        );
    }

    public void addProf(Prof professor) {
        db.setProfs(
                new ArrayList<Prof>(
                        List.of(professor)
                )
        );
    }

    public void removeLessonGroup(int lessonGroupId) {
        db.removeGroupLesson(lessonGroupId);
    }

    public void removeStudent(int studentId) {
        db.removeStudent(studentId);
    }

    public void removeProf(int profId) {
        db.removeProf(profId);
    }

    public void changeLessonGroupId(int lessonId, int newLessonGroupId) {
        LessonGroup lessonGroup = db.getLessonGroupById(lessonId);
        lessonGroup.setLessonGroupId(newLessonGroupId);
        db.updateLessonGroup(lessonGroup);
    }

    public void changeSchedule(int lessonId, Schedule newSchedule) {
        LessonGroup lessonGroup = db.getLessonGroupById(lessonId);
        lessonGroup.setSchedule(newSchedule);
        db.updateLessonGroup(lessonGroup);
    }

    public void changeLessonCapacity(int lessonId, int newCapacity) {
        LessonGroup lessonGroup = db.getLessonGroupById(lessonId);
        lessonGroup.setLessonCapacity(newCapacity);
        db.updateLessonGroup(lessonGroup);
    }

    public void changeLessonTerm(int lessonId, int newTerm) {
        LessonGroup lessonGroup = db.getLessonGroupById(lessonId);
        lessonGroup.setTerm(newTerm);
        db.updateLessonGroup(lessonGroup);
    }

    public void changeStudentName(int studentId, String newName) {
        Student student = db.getStudentById(studentId);
        student.setName(newName);
        db.updateStudent(student);
    }

    public void changeStudentLastName(int studentId, String newLastName) {
        Student student = db.getStudentById(studentId);
        student.setLastname(newLastName);
        db.updateStudent(student);
    }

    public void changeStudentPass(int studentId, String oldPassword, String newPassword) {
        Student student = db.getStudentById(studentId);
        student.editPass(oldPassword, newPassword);
        db.updateStudent(student);
    }

    public void changeProfessorName(int profId, String newName) {
        Prof professor = db.getProfessorById(profId);
        professor.setName(newName);
        db.updateProf(professor);
    }

    public void changeProfessorLastName(int profId, String newLastName) {
        Prof professor = db.getProfessorById(profId);
        professor.setLastname(newLastName);
        db.updateProf(professor);
    }

    public void changeProfessorPass(int profId, String oldPassword, String newPassword) {
        Prof professor = db.getProfessorById(profId);
        professor.editPass(oldPassword, newPassword);
        db.updateProf(professor);
    }

    public void collectRequestStudent() throws IOException {
        BufferedReader bw = new BufferedReader(
                new FileReader("Database/requests/requests.txt")
        );

        String s;
        while ((s = bw.readLine()) != null) {
            studentsRequest.add(
                    s.split(" ")
            );
        }
    }

    public void applyRequestStudent() {
        for (String[] strings : this.studentsRequest) {
            System.out.println("The Id deleted : " + Integer.parseInt(strings[1]));
            Student student = db.getStudentById(Integer.parseInt(strings[0]));
            ArrayList<LessonGroup> newLessonGroup = new ArrayList<>();
            for (int i = 0; i < student.getLessonGroups().size(); i++) {
                LessonGroup tempLessonGroup = student.getLessonGroups().get(i);
                if (tempLessonGroup.getLessonId() == Integer.parseInt(strings[1])) {
                    continue;
                } else {
                    newLessonGroup.add(student.getLessonGroups().get(i));
                }
            }
            System.out.println("Before : " + student.getLessonGroups());
            student.removeLessonGroup();
            student.setLessonGroups(newLessonGroup);
            System.out.println("After : " + student.getLessonGroups());
            db.updateStudent(student);
        }
    }



}
