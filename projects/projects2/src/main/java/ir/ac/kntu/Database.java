package ir.ac.kntu;

import java.util.ArrayList;


/**
 * @author Soroush Ziaee
 * @version 2, 3, Jan, 2022
 */
public class Database {

    private static final Database DB = new Database();
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Prof> profs = new ArrayList<>();
    private final ArrayList<LessonGroup> lessonGroups = new ArrayList<>();

    private Database() {
    }

    public static Database getInstance() {
        return DB;
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
            this.students.add((Student) s.clone());
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

    public ArrayList<LessonGroup> getLessonGroups() {
        ArrayList<LessonGroup> newLessonGroup = new ArrayList<>();
        for (LessonGroup lg : this.lessonGroups) {
            newLessonGroup.add((LessonGroup) lg.clone());
        }
        return newLessonGroup;
    }

    public void setLessonGroups(ArrayList<LessonGroup> lessonGroups) {
        for (LessonGroup lg : lessonGroups) {
            this.lessonGroups.add((LessonGroup) lg.clone());
        }
    }

    public void removeStudent(int studentId) {
        for (Student student : this.students) {
            if (student.getId() == studentId) {
                this.students.remove(student);
                break;
            }
        }
    }

    public void removeProf(int profId) {
        for (Prof professor : this.profs) {
            if (professor.getId() == profId) {
                this.profs.remove(professor);
                break;
            }
        }
    }

    public void removeGroupLesson(int lessonId) {

        for (LessonGroup lessonGroup : this.lessonGroups) {
            if (lessonGroup.getLessonId() == lessonId) {
                int index = this.lessonGroups.indexOf(lessonGroup);
                this.lessonGroups.remove(index);
                break;
            }
        }
    }

    public Student getStudentById(int studentId) {
        for (Student student : DB.getStudents()) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public LessonGroup getLessonGroupById(int lessonGroupId) {
        for (LessonGroup lg : DB.getLessonGroups()) {

            if (lg.getLessonGroupId() == lessonGroupId || lg.getLessonId() == lessonGroupId) {
                return lg;
            }
        }
        return null;
    }

    public Prof getProfessorById(int profId) {
        for (Prof professor : DB.getProfs()) {

            if (professor.getId() == profId) {
                return professor;
            }
        }
        return null;
    }

    public void updateStudent(Student student){
        this.removeStudent(student.getId());
        this.students.add(student);
    }

    public void updateProf(Prof professor){
        this.removeProf(professor.getId());
        this.profs.add(professor);
    }

    public void updateLessonGroup(LessonGroup lessonGroup){
        this.removeGroupLesson(lessonGroup.getLessonId());
        this.lessonGroups.add(lessonGroup);
    }


}
