package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final ArrayList<Student> students;
    private final ArrayList<Prof> profs;
    private final ArrayList<LessonGroup> lessonGroups;
    private String userName;
    private String pass;
    private boolean loginStatus;

    public Admin(String userName, String pass, ArrayList<Student> students, ArrayList<Prof> profs, ArrayList<LessonGroup> lessonGroups) {
        this.userName = userName;
        this.pass = pass;
        this.students = students;
        this.lessonGroups = lessonGroups;
        this.profs = profs;

    }

    @Override
    public String toString() {
        return "Admin{" + "userName='" + userName + '\'' + ", loginStatus=" + loginStatus + '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void login(String userName, String pass) {
        this.loginStatus = (this.pass.equals(pass) && this.userName.equals(userName));
        if (!this.loginStatus) {
            System.out.println("Error : The Password or Username is wrong");
        }
    }

    public void logout() {
        this.loginStatus = false;
    }

    public boolean isLogin() {
        return loginStatus;
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

    public Student getStudentById(int studentId) {
        for (Student student : this.students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public LessonGroup getLessonGroupById(int lessonGroupId) {
        for (LessonGroup lg : this.lessonGroups) {

            if (lg.getLessonGroupId() == lessonGroupId || lg.getLessonId() == lessonGroupId) {
                return lg;
            }
        }
        return null;
    }

    public int returnLessonGroupIndex(int lessonGroup) {
        for (int i = 0; i < this.lessonGroups.size(); i++) {
            if (lessonGroup == this.lessonGroups.get(i).getLessonId() || lessonGroup == this.lessonGroups.get(i).getLessonGroupId()) {
                return i;
            }
        }
        return -1;
    }

    public void addStudentToGroup(Student s, LessonGroup lg) {
        s.addLessonGroup(lg);
        lg.setStudents(new ArrayList<>(List.of(s)));
    }

    public void changeLessonGroupId(LessonGroup lg, int id) {
        lg.setLessonGroupId(id);
    }

    public void changeSchedule(LessonGroup lg, Schedule s) {
        lg.setSchedule(s);
    }

    public void changeLessonCapacity(LessonGroup lg, int newCapacity) {
        lg.setLessonCapacity(newCapacity);
    }

    public void changeTerm(LessonGroup lg, int newTerm) {
        lg.setTerm(newTerm);
    }

    public void addProfToGroup(Prof p, LessonGroup lg) {
        p.addLessonGroup(lg);
        lg.setProfs(new ArrayList<>(List.of(p)));
    }

    public void removeGroupLesson(LessonGroup lg) {
        // Delete the given lesson from the lessonGroups
        for (LessonGroup lesson : this.lessonGroups) {
            if (lesson.equals(lg)) {
                this.lessonGroups.remove(lg);
                break;
            }
        }

        //Delete the given lesson from the Student List
        for (Student s : this.students) {
            s.removeGroupLesson(lg);
        }

        //Delete the given lesson from the Profs List
        for (Prof p : this.profs) {
            p.removeGroupLesson(lg);
        }
    }

    private boolean checkPassStudent(Student s, Lesson l) {
        return s.isPassed(l);
    }

    public void addUnitStudent(int studentId, int lessonGroupId) {
        Student s = getStudentById(studentId);
        LessonGroup lg = getLessonGroupById(lessonGroupId);

        // Check if the students passed all the requirements for the group lesson
        boolean isAddable = true;
        for (Lesson l : lg.getListLessonPreRequire()) {
            if (!checkPassStudent(s, l)) {
                System.out.println("Don't pass Requirement");
                isAddable = false;
                break;
            }
        }

        // Check if the students had the lesson
        if (checkPassStudent(s, lg)) {
            System.out.println("You Passed the lesson");
            isAddable = false;
        }


        // Check if the lesson has capacity
        if (lg.getLessonCapacity() <= 0) {
            System.out.println("Don't Capacity = 0");
            System.out.println();
            isAddable = false;
        }

        // Check if the lesson has time interference
        for (LessonGroup lesson : s.getLessonGroups()) {
            if (!lg.compareTo(lesson)) {
                System.out.println("The Time Interference with : " + lesson);
                isAddable = false;
                break;
            }
        }

        if (isAddable) {
            addStudentToGroup(s, lg);
            lg.setLessonCapacity(lg.getLessonCapacity() - 1);
        }

    }


}
