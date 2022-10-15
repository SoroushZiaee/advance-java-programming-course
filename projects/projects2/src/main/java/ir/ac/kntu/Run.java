package ir.ac.kntu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Run {

    private Database db;
    private ArrayList<LessonGroup> lessonGroups;
    private ArrayList<Student> students;
    private ArrayList<Prof> profs;
    private Admin admin;
    private final LessonGroup lessonGroup = new LessonGroup(101);
    private Student student;
    private Prof professor;

    public static void mainMenu() {
        System.out.println("0 : Enter as Admin");
        System.out.println("1 : Enter as Student");
        System.out.println("2 : Enter as PROF");
        System.out.println("9 : Exit");
    }

    public static void adminMenu() {
        System.out.println("\t0 : Add Student To Lesson");
        System.out.println("\t1 : Add New Class");
        System.out.println("\t2 : Edit Class");
        System.out.println("\t3 : Show Group Lesson");
        System.out.println("\t4 : Show Students");
        System.out.println("\t5 : Show Professors");
        System.out.println("\t6 : Add Student");
        System.out.println("\t7 : Add Professor");
        System.out.println("\t9 : Remove Group Lesson");
        System.out.println("\t10 : Remove Student");
        System.out.println("\t11 : Remove Professor");
        System.out.println("\t12 : Remove Student Lesson Request");
        System.out.println("\t15 : Logout");
    }

    public static Time createTime(String time) {
        String[] hourMin = time.split(":");
        return new Time(Integer.parseInt(hourMin[0]), Integer.parseInt(hourMin[1]));
    }

    public static WeekDay[] createWeekDay(String day1, String day2) {
        WeekDay[] weekDays = new WeekDay[2];
        weekDays[0] = WeekDay.valueOf(day1);
        weekDays[1] = WeekDay.valueOf(day2);

        return weekDays;
    }

    public static void editClassMenu() {
        System.out.println("\t\t0 : Change Name : ");
        System.out.println("\t\t1 : Change Schedule : ");
        System.out.println("\t\t2 : Change Capacity : ");
        System.out.println("\t\t3 : Change term : ");
        System.out.println("\t\t8 : Cancel Editing");
    }

    public static void studentMenu() {
        System.out.println("\t0 : Add Classes");
        System.out.println("\t1 : Weekly Program");
        System.out.println("\t2 : Calculate Average");
        System.out.println("\t3 : Remove A Lesson");
        System.out.println("\t4 : Change Password");
        System.out.println("\t5 : Reserve Food");
        System.out.println("\t8 : Logout");
    }

    public static void profMenu() {
        System.out.println("\t0 : Show Prof Class");
        System.out.println("\t1 : Show Student info");
        System.out.println("\t2 : Show Weekly info");
        System.out.println("\t3 : Enter Student Grade");
        System.out.println("\t4 : Change Password");
        System.out.println("\t8 : Logout");
    }

    private void setUp() {
        db = Database.getInstance();

        LessonGroup group1 = new LessonGroup(1);
        LessonGroup group2 = new LessonGroup(2);
        LessonGroup group3 = new LessonGroup(3);
        LessonGroup group4 = new LessonGroup(4);
        LessonGroup group5 = new LessonGroup(5);

        this.lessonGroups = new ArrayList<>(List.of(group1, group2, group3, group4, group5));

        int[] groupsId = {10, 20, 30, 40, 50};
        for (int i = 0; i < groupsId.length; i++) {
            this.lessonGroups.get(i).setLessonGroupId(groupsId[i]);
        }

        Time[] timesStart = {new Time(7, 30), new Time(9, 00), new Time(10, 30), new Time(12, 00), new Time(15, 30)};
        Time[] timeEnd = {new Time(9, 00), new Time(10, 30), new Time(12, 00), new Time(13, 00), new Time(17, 00)};

        WeekDay[][] weekDays = {{WeekDay.Saturday, WeekDay.Monday}, {WeekDay.Sunday, WeekDay.Tuesday}, {WeekDay.Saturday, WeekDay.Monday}, {WeekDay.Monday, WeekDay.Wednesday}, {WeekDay.Monday, WeekDay.Wednesday}};

        Schedule[] schedules = {new Schedule(new TimeInterval(timesStart[0]), new TimeInterval(timeEnd[0]), weekDays[0]), new Schedule(new TimeInterval(timesStart[1]), new TimeInterval(timeEnd[1]), weekDays[1]), new Schedule(new TimeInterval(timesStart[2]), new TimeInterval(timeEnd[2]), weekDays[2]), new Schedule(new TimeInterval(timesStart[3]), new TimeInterval(timeEnd[3]), weekDays[3]), new Schedule(new TimeInterval(timesStart[4]), new TimeInterval(timeEnd[4]), weekDays[4]),};

        for (int i = 0; i < this.lessonGroups.size(); i++) {
            lessonGroups.get(i).setSchedule(schedules[i]);
        }

        int[] capacity = {3, 2, 4, 1, 5};
        for (int i = 0; i < this.lessonGroups.size(); i++) {
            this.lessonGroups.get(i).setLessonCapacity(capacity[i]);
        }

        int[] term = {1, 1, 1, 1, 1};
        for (int i = 0; i < this.lessonGroups.size(); i++) {
            this.lessonGroups.get(i).setTerm(term[i]);
        }

        ArrayList<ArrayList<Lesson>> lessonPreRequirements = new ArrayList<ArrayList<Lesson>>(List.of(new ArrayList<Lesson>(List.of(group2, group3, group4)), new ArrayList<Lesson>(List.of(group1, group3)), new ArrayList<Lesson>(List.of(group4)), new ArrayList<Lesson>(List.of(group2, group3)), new ArrayList<Lesson>(List.of(group1))));

        for (int i = 0; i < this.lessonGroups.size(); i++) {
            this.lessonGroups.get(i).setListLessonPreRequire(lessonPreRequirements.get(i));
        }

        this.students = new ArrayList<>(List.of(new Student[]{new Student("a", "A", 9728143, "12345678"), new Student("b", "B", 9729843, "12345678"), new Student("c", "C", 9730303, "12345678"), new Student("d", "D", 9727283, "12345678"),}));
        this.profs = new ArrayList<>(List.of(new Prof[]{new Prof("z", "Z", 1, "12345678"), new Prof("y", "Y", 2, "12345678"), new Prof("x", "X", 3, "12345678"), new Prof("w", "W", 4, "12345678"),}));

        ArrayList<ArrayList> profGroupLesson = new ArrayList<>(List.of(new ArrayList<Lesson>(List.of(group1, group2)), new ArrayList<Lesson>(List.of(group3, group4)), new ArrayList<Lesson>(List.of(group1, group4)), new ArrayList<Lesson>(List.of(group2, group3))));

        for (int i = 0; i < profs.size(); i++) {
            this.profs.get(i).setLessonGroups(profGroupLesson.get(i));
        }

        ArrayList<HashMap> grade = new ArrayList<HashMap>(List.of(new HashMap<Integer, Double>(), new HashMap<Integer, Double>(), new HashMap<Integer, Double>(), new HashMap<Integer, Double>()));

        grade.get(0).put(group2.getLessonId(), 19.2);
        grade.get(0).put(group3.getLessonId(), 15.2);
        grade.get(0).put(group4.getLessonId(), 18.2);

        grade.get(1).put(group3.getLessonId(), 17.5);
        grade.get(1).put(group1.getLessonId(), 14.5);

        grade.get(2).put(group4.getLessonId(), 18.4);

        grade.get(3).put(group3.getLessonId(), 20);
        grade.get(3).put(group2.getLessonId(), 16.4);

        for (int i = 0; i < students.size(); i++) {
            this.students.get(i).setPassedLessons(grade.get(i));
        }

        ArrayList<ArrayList> studentLesson = new ArrayList<>(List.of(new ArrayList<LessonGroup>(List.of(group1)), new ArrayList<LessonGroup>(List.of(group2)), new ArrayList<LessonGroup>(List.of(group3)), new ArrayList<LessonGroup>(List.of(group4))));

        for (int i = 0; i < students.size(); i++) {
            this.students.get(i).setLessonGroups(studentLesson.get(i));
        }

        for (LessonGroup lg : this.lessonGroups) {
            lg.setStudents(new ArrayList<Student>(students));
        }

        for (LessonGroup lg : this.lessonGroups) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getLessonGroups().contains(lg)) {
                    lg.setStudents(new ArrayList<>(List.of(students.get(i))));
                }
            }
        }

        for (LessonGroup lg : this.lessonGroups) {
            for (int i = 0; i < profs.size(); i++) {
                if (profs.get(i).getLessonGroups().contains(lg)) {
                    lg.setProfs(new ArrayList<>(List.of(profs.get(i))));
                }
            }
        }

        lessonGroup.setSchedule(new Schedule(new TimeInterval(new Time(20, 30)), new TimeInterval(new Time(10, 00)), new WeekDay[]{WeekDay.Saturday, WeekDay.Monday}));

        lessonGroup.setLessonCapacity(100);

        db.setStudents(this.students);
        db.setProfs(this.profs);
        db.setLessonGroups(this.lessonGroups);

        db.setLessonGroups(new ArrayList<>(List.of(lessonGroup)));

        Student student = db.getStudentById(9728143);

        LessonGroup lessonGroupRequire = new LessonGroup(11);
        lessonGroup.setListLessonPreRequire(new ArrayList<>(List.of(lessonGroupRequire)));

        HashMap<Integer, Double> grades = new HashMap<>();
        grades.put(11, 20.0);
        student.setPassedLessons(grades);

        admin = new Admin("Soroush", "Ziaee", 1, "12345678");
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setProfessor(Prof professor) {
        this.professor = professor;
    }

    public void addStudentToClass(Person person, String[] studentLessonGroupIdInfo, String typeClass) {
        Student student = this.db.getStudentById(Integer.parseInt(studentLessonGroupIdInfo[0]));
        LessonGroup lessonGroup = this.db.getLessonGroupById(Integer.parseInt(studentLessonGroupIdInfo[1]));
        person.addUnitStudent(student, lessonGroup, typeClass);
    }

    public void addClassProcess(Scanner in) {
        System.out.print("Please Enter Lesson Id : ");
        LessonGroup lg = new LessonGroup(Integer.parseInt(in.nextLine()));
        System.out.print("Please Enter Lesson Name : ");
        lg.setLessonName(in.nextLine());
        System.out.print("Please Enter Lesson Group Id : ");
        lg.setLessonGroupId(Integer.parseInt(in.nextLine()));
        System.out.print("Please Enter Lesson Class Capacity : ");
        lg.setLessonCapacity(Integer.parseInt(in.nextLine()));
        System.out.print("Please Enter Lesson Term : ");
        lg.setTerm(Integer.parseInt(in.nextLine()));
        System.out.print("Please Enter the Lesson schedule in form of | startTime endTime day1 day2: ");
        String[] schedules = in.nextLine().split(" ");
        lg.setSchedule(new Schedule(new TimeInterval(createTime(schedules[0])), new TimeInterval(createTime(schedules[1])), createWeekDay(schedules[2], schedules[3])));
        this.admin.addLessonGroup(lg);
        System.out.println("Successfully add the Class");
    }

    public void addStudentProcess(Scanner in) {
        System.out.print("Please Enter name : ");
        String name = in.nextLine();
        System.out.print("Please Enter Lastname : ");
        String lastName = in.nextLine();
        System.out.print("Please Enter StudentId : ");
        int studentId = Integer.parseInt(in.nextLine());
        System.out.print("Please Enter password : ");
        String password = in.nextLine();
        Student student = new Student(name, lastName, studentId, password);
        this.admin.addStudent(student);
        System.out.println("Successfully add the Student");
    }

    public void addProfProcess(Scanner in) {
        System.out.print("Please Enter name : ");
        String name = in.nextLine();
        System.out.print("Please Enter Lastname : ");
        String lastName = in.nextLine();
        System.out.print("Please Enter ProfessorId : ");
        int studentId = Integer.parseInt(in.nextLine());
        System.out.print("Please Enter password : ");
        String password = in.nextLine();
        Prof professor = new Prof(name, lastName, studentId, password);
        this.admin.addProf(professor);
        System.out.println("Successfully add the Professor");
    }

    public void editClassProcess(Scanner in) {
        System.out.print("Please Enter the Group Lesson Id : ");
        int lessonId = Integer.parseInt(in.nextLine());

//        int lessonGroupIndex = -1;
//        for (int i = 0; i < this.lessonGroups.size(); i++) {
//            if (this.lessonGroups.get(i).getLessonId() == lessonId || this.lessonGroups.get(i).getLessonGroupId() == lessonId) {
//                lessonGroupIndex = i;
//                break;
//            }
//        }

        LessonGroup lessonGroup = db.getLessonGroupById(lessonId);

        editClassMenu();

        int editController = Integer.parseInt(in.nextLine());

        switch (editController) {
            case 0:
                System.out.print("Enter New Name : ");
                lessonGroup.setLessonName(in.nextLine());
                db.updateLessonGroup(lessonGroup);
                System.out.println("Update Name Successfully");
                break;
            case 1:
                System.out.print("Enter New Schedule : ");
                String[] timeInfo = in.nextLine().split(" ");
                lessonGroup.setSchedule(new Schedule(new TimeInterval(createTime(timeInfo[0])), new TimeInterval(createTime(timeInfo[1])), createWeekDay(timeInfo[2], timeInfo[3])));
                db.updateLessonGroup(lessonGroup);
                System.out.println("Update Schedule Successfully");
                break;
            case 2:
                System.out.print("Enter New Capacity: ");
                lessonGroup.setLessonCapacity(Integer.parseInt(in.nextLine()));
                db.updateLessonGroup(lessonGroup);
                System.out.println("Update Capacity Successfully");
                break;
            case 3:
                System.out.print("Enter New Term: ");
                lessonGroup.setTerm(Integer.parseInt(in.nextLine()));
                db.updateLessonGroup(lessonGroup);
                System.out.println("Update Term Successfully");
                break;
            case 8:
                System.out.println("Cancel Editing Successfully");
                break;
            default:
                break;
        }
    }

    public void adminProcess(Scanner in) throws IOException {
        System.out.print("Enter the Admin Username & Password : ");
        String[] loginInfoAdmin = in.nextLine().split(" ");
        this.admin.login(Integer.parseInt(loginInfoAdmin[0]), loginInfoAdmin[1]);


        while (admin.isLogin()) {
            adminMenu();
            int adminController = Integer.parseInt(in.nextLine());

            switch (adminController) {
                case 0:
                    System.out.print("Please Input a Student and Lesson Group in form of | student_id lesson_group_id | : ");
                    String[] studentLessonGroupIdInfo = in.nextLine().split(" ");
                    addStudentToClass(this.admin, studentLessonGroupIdInfo, "online");
                    break;
                case 1:
                    System.out.println("Add Classes");
                    addClassProcess(in);
                    break;
                case 2:
                    System.out.println("Edit Classes");
                    editClassProcess(in);
                    break;
                case 3:
                    System.out.println("Show Lesson Group");
                    for (LessonGroup lg : db.getLessonGroups()) {
                        System.out.println("\t\t + " + lg);
                    }
                    break;
                case 4:
                    System.out.println("Show Students");
                    for (Student s : db.getStudents()) {
                        System.out.println("\t\t + " + s);
                    }
                    break;
                case 5:
                    System.out.println("Show Prof");
                    for (Prof p : db.getProfs()) {
                        System.out.println("\t\t + " + p);
                    }
                    break;
                case 6:
                    addStudentProcess(in);
                    break;
                case 7:
                    addProfProcess(in);
                    break;
                case 9:
                    System.out.print("Please Select a classes to delete : ");
                    int lessonId = Integer.parseInt(in.nextLine());
                    System.out.print("Are you Sure to delete the lesson (y/n) : ");
                    String confirm = in.nextLine();
                    if (confirm.equals("y")) {
                        db.removeGroupLesson(lessonId);
                    } else {
                        break;
                    }
                    break;
                case 10:
                    System.out.print("Please Select a student to delete : ");
                    lessonId = Integer.parseInt(in.nextLine());
                    System.out.print("Are you Sure to delete the lesson (y/n) : ");
                    confirm = in.nextLine();
                    if (confirm.equals("y")) {
                        db.removeStudent(lessonId);
                    } else {
                        break;
                    }
                    break;
                case 11:
                    System.out.print("Please Select a professor to delete : ");
                    lessonId = Integer.parseInt(in.nextLine());
                    System.out.print("Are you Sure to delete the lesson (y/n) : ");
                    confirm = in.nextLine();
                    if (confirm.equals("y")) {
                        db.removeProf(lessonId);
                    } else {
                        break;
                    }
                    break;
                case 12:
                    System.out.println("Read requests from file");
                    this.admin.collectRequestStudent();
                    this.admin.applyRequestStudent();
                    break;

                case 15:
                    System.out.println("logout");
                    this.admin.logout();
                    break;
                default:
                    System.out.println("Error : Choose One of Above Option");
                    break;
            }

        }
    }

    public void studentProcess(Scanner in) throws IOException {
        System.out.print("Enter the Student Username & Password : ");
        String[] loginInfoStudent = in.nextLine().split(" ");

        for (Student s : db.getStudents()) {
            if (s.getId() == Integer.parseInt(loginInfoStudent[0])) {
                setStudent(s);
                this.student.login(Integer.parseInt(loginInfoStudent[0]), loginInfoStudent[1]);
                break;
            }
        }

        while (this.student.isLogin()) {
            studentMenu();
            int studentController = Integer.parseInt(in.nextLine());

            switch (studentController) {
                case 0:
                    System.out.print("Please Input a Lesson Group in form of | lesson_group_id | : ");
                    String[] studentLessonGroupIdInfo = {String.valueOf(this.student.getId()), in.nextLine()};
                    addStudentToClass(this.student, studentLessonGroupIdInfo, "online");
                    break;
                case 1:
                    System.out.println("Weekly Program");
                    this.student.showWeeklySchedule();
                    break;
                case 2:
                    System.out.println(this.student.getPassedLessons());
                    System.out.println("Show Student " + this.student.getId());
                    this.student.showStudentGrades();
                    break;
                case 3:
                    System.out.println("Add a remove request");
                    System.out.print("Enter a lessonId to remove : ");
                    int lessonId = Integer.parseInt(in.nextLine());
                    LessonGroup lessonGroup = db.getLessonGroupById(lessonId);
                    this.student.requestRemoveLesson(lessonGroup);
                    break;

                case 4:
                    System.out.print("Enter oldPassword & newPassword : ");
                    String[] passwords = in.nextLine().split(" ");
                    this.student.editPass(passwords[0], passwords[1]);
                    break;
                case 5:
                    System.out.println("*********************Under Construction***********************");
                    System.out.println("*********************Error 404***********************");
                    break;
                case 8:
                    this.student.logout();
                    break;
                default:
                    System.out.println("Error : Choose One of Above Option");
                    break;
            }

        }
    }

    public void profProcess(Scanner in) {
        System.out.print("Enter the PROF Username & Password : ");
        String[] loginInfoProf = in.nextLine().split(" ");
        for (Prof p : this.profs) {
            System.out.println(p);
            if (p.getId() == Integer.parseInt(loginInfoProf[0])) {
                setProfessor(p);
                this.professor.login(Integer.parseInt(loginInfoProf[0]), loginInfoProf[1]);
                break;
            }
        }

        while (this.professor.isLogin()) {
            profMenu();
            int profController = Integer.parseInt(in.nextLine());

            switch (profController) {
                case 0:
                    System.out.println("Class Schedule");
                    this.professor.showGroupLesson();
                    break;
                case 1:
                    System.out.println("Show Each Class Student");
                    this.professor.showStudentOfEachLesson();
                    break;
                case 2:
                    System.out.println("Weekly Schedule");
                    this.professor.showWeeklySchedule();
                    break;
                case 3:
                    System.out.print("Enter Student & Lesson id to enter grade :");
                    String[] studentLessonGroupIdInfo = in.nextLine().split(" ");
                    System.out.print("Enter Grade of Student : ");
                    Student student = db.getStudentById(Integer.parseInt(studentLessonGroupIdInfo[0]));
                    double grade = Double.parseDouble(in.nextLine());
                    this.professor.setGradeStudent(student, Integer.parseInt(studentLessonGroupIdInfo[1]), grade);
                    break;
                case 4:
                    System.out.print("Enter oldPassword & newPassword : ");
                    String[] passwords = in.nextLine().split(" ");
                    this.professor.editPass(passwords[0], passwords[1]);
                    break;
                case 8:
                    this.professor.logout();
                default:
                    System.out.println("Error : Choose One of Above Option");
                    break;
            }
        }
    }

    public void runApplication() throws IOException {
        System.out.println("Loading the Data From Database");
        setUp();
//        System.out.println(db.getStudents());
        Scanner in = new Scanner(System.in);
        while (true) {

            mainMenu();

            int controller = Integer.parseInt(in.nextLine());

            if (controller == 9) {
                break;
            }

            switch (controller) {
                case 0:
                    adminProcess(in);
                    break;
                case 1:
                    studentProcess(in);
                    break;
                case 2:
                    profProcess(in);
                    break;
                default:
                    System.out.println("Error : Choose One of Above Option");
                    break;
            }


        }
    }

}
