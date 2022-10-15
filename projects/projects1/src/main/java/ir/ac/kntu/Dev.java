package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dev {
    public Dev() {
        LessonGroup group1 = new LessonGroup(1);
        LessonGroup group2 = new LessonGroup(2);
        LessonGroup group3 = new LessonGroup(3);
        LessonGroup group4 = new LessonGroup(4);
        ArrayList<LessonGroup> lessonGroups = new ArrayList<>(List.of(group1, group2, group3, group4));

        System.out.println("Print The init GroupLesson : ");
        System.out.println("\t + " + lessonGroups);

        System.out.println("Set the GroupIds");
        int[] groupsId = {10, 20, 30, 40};
        for (int i = 0; i < groupsId.length; i++) {
            lessonGroups.get(i).setLessonGroupId(groupsId[i]);
        }

        //init Schedules Parameters
        Time[] timesStart = {new Time(7, 30), new Time(9, 00), new Time(10, 30), new Time(12, 00)};

        Time[] timeEnd = {new Time(9, 00), new Time(10, 30), new Time(12, 00), new Time(13, 00),};

        WeekDay[][] weekDays = {{WeekDay.Saturday, WeekDay.Monday}, {WeekDay.Sunday, WeekDay.Tuesday}, {WeekDay.Saturday, WeekDay.Monday}, {WeekDay.Monday, WeekDay.Wednesday}};

        Schedule[] schedules = {new Schedule(new TimeInterval(timesStart[0]), new TimeInterval(timeEnd[0]), weekDays[0]), new Schedule(new TimeInterval(timesStart[1]), new TimeInterval(timeEnd[1]), weekDays[1]), new Schedule(new TimeInterval(timesStart[2]), new TimeInterval(timeEnd[2]), weekDays[2]), new Schedule(new TimeInterval(timesStart[3]), new TimeInterval(timeEnd[3]), weekDays[3]),};

        System.out.println("Set the Schedules of GroupLessons");
        for (int i = 0; i < lessonGroups.size(); i++) {
            lessonGroups.get(i).setSchedule(schedules[i]);
        }

        // Delete 4 after Creating
        int[] capacity = {3, 2, 4, 1};
        System.out.println("Set the Capacity of GroupLessons");
        for (int i = 0; i < lessonGroups.size(); i++) {
            lessonGroups.get(i).setLessonCapacity(capacity[i] + 3);
        }

        int[] term = {1, 1, 1, 1};
        System.out.println("Set the Term of GroupLessons");
        for (int i = 0; i < lessonGroups.size(); i++) {
            lessonGroups.get(i).setTerm(term[i]);
        }

        // Requirements
        System.out.println("Set the Requirements of GroupLessons");
        ArrayList<ArrayList<Lesson>> lessonPreRequirements = new ArrayList<ArrayList<Lesson>>(List.of(new ArrayList<Lesson>(List.of(group2, group3, group4)), new ArrayList<Lesson>(List.of(group1, group3)), new ArrayList<Lesson>(List.of(group4)), new ArrayList<Lesson>(List.of(group2, group3))));

        for (int i = 0; i < lessonGroups.size(); i++) {
            lessonGroups.get(i).setListLessonPreRequire(lessonPreRequirements.get(i));
        }

        System.out.println("\t + Print The Requirement : ");
        for (int i = 0; i < lessonGroups.size(); i++) {
            System.out.println("\t + " + lessonGroups.get(i).getListLessonPreRequire());
        }

        System.out.println("Create Profs and Students list");
        Student[] students = {new Student("a", "A", 9728143, "12345678"), new Student("b", "B", 9729843, "12345678"), new Student("c", "C", 9730303, "12345678"), new Student("d", "D", 9727283, "12345678"),};

        Prof[] profs = {new Prof("z", "Z", 1, "12345678"), new Prof("y", "Y", 2, "12345678"), new Prof("x", "X", 3, "12345678"), new Prof("w", "W", 4, "12345678"),};


        System.out.println("\tPrint the professors List");
        for (int i = 0; i < profs.length; i++) {
            System.out.println("\t + " + profs[i]);
        }

        ArrayList<ArrayList> profGroupLesson = new ArrayList<>(List.of(new ArrayList<Lesson>(List.of(group1, group2)), new ArrayList<Lesson>(List.of(group3, group4)), new ArrayList<Lesson>(List.of(group1, group4)), new ArrayList<Lesson>(List.of(group2, group3))));

        System.out.println("set the professors lesson List");
        for (int i = 0; i < profs.length; i++) {
            profs[i].setLessonGroups(profGroupLesson.get(i));
        }

        System.out.println("\t\tPrint the professors List");
        for (int i = 0; i < profs.length; i++) {
            System.out.println("\t\t - " + profs[i].getLessonGroups());
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

        System.out.println("Set the students passed lesson.");
        for (int i = 0; i < students.length; i++) {
            students[i].setPassedLessons(grade.get(i));
        }

        System.out.println("\tPrint the Student List");
        for (int i = 0; i < students.length; i++) {
            System.out.println("\t + " + students[i]);
        }

        System.out.println("\t\tPrint the Student pass Lesson List");
        for (int i = 0; i < students.length; i++) {
            System.out.println("\t\t - " + students[i].getPassedLessons());
        }

        ArrayList<ArrayList> studentLesson = new ArrayList<>(List.of(new ArrayList<LessonGroup>(List.of(group1)), new ArrayList<LessonGroup>(List.of(group2)), new ArrayList<LessonGroup>(List.of(group3)), new ArrayList<LessonGroup>(List.of(group4))));

        for (int i = 0; i < students.length; i++) {
            students[i].setLessonGroups(studentLesson.get(i));
        }

        System.out.println("\t\tPrint the Student Lesson List");
        for (int i = 0; i < students.length; i++) {
            System.out.println("\t\t - " + students[i].getLessonGroups());
        }

        for (int i = 0; i < students.length; i++) {
            System.out.println("\t\t - Max UNit : " + students[i].getMaxUnit());
        }

        for (LessonGroup lg : lessonGroups) {
            lg.setStudents(new ArrayList<Student>(List.of(students)));
        }

        // There is a Bug to add the Student to Lesson Groups. All Students add to all courses
        for (int i = 0; i < students.length; i++) {
            for (LessonGroup lg : students[i].getLessonGroups()) {
                lg.setStudents(new ArrayList<>(List.of(students[i])));
            }
        }

        for (LessonGroup lg : lessonGroups) {
            System.out.println(lg.getStudents());
        }

        for (LessonGroup lg : lessonGroups) {
            System.out.println("\t\t" + lg.getLessonId());
            System.out.println("\t\t - Capacity : " + lg.getLessonCapacity());
        }

        for (int i = 0; i < profs.length; i++) {
            for (LessonGroup lg : profs[i].getLessonGroups()) {
                lg.setProfs(new ArrayList<>(List.of(profs[i])));
            }
        }

        System.out.println(profs[0].getLessonGroups());
        System.out.println("The Prof of Group1");
        System.out.println(lessonGroups.get(3).getProfs());

        System.out.println("The Students Functions : ");
        students[0].addLessonGroup(group2);
        System.out.println(students[0].getLessonGroups());
        students[0].removeGroupLesson(group2);
        System.out.println(students[0].getLessonGroups());
        System.out.println("\t + false : " + students[0].isPassed(group1));
        System.out.println("\t + true : " + students[0].isPassed(group2));

        System.out.println("Login Status :");
        System.out.println("\t + false : " + students[0].isLogin());
        students[0].login(9728143, "12345678");
        System.out.println("\t + true : " + students[0].isLogin());

        System.out.println("The Prof Functions : ");
        profs[0].addLessonGroup(group2);
        System.out.println(profs[0].getLessonGroups());
        profs[0].removeGroupLesson(group2);
        System.out.println(profs[0].getLessonGroups());

        System.out.println("Login Status :");
        System.out.println("\t + false : " + profs[0].isLogin());
        profs[0].login(profs[0].getProfId(), "12345678");
        System.out.println("\t + true : " + profs[0].isLogin());

        System.out.println("Create a Admin");
        Admin admin = new Admin("soroush", "12345678", new ArrayList<Student>(List.of(students)), new ArrayList<Prof>(List.of(profs)), lessonGroups);

        System.out.println(admin);

        System.out.println("Login Status :");
        System.out.println("\tfalse : " + admin.isLogin());
        admin.login("soroush", "12345678");
        System.out.println("\ttrue : " + admin.isLogin());

        System.out.println("Create test cases of admin");
        LessonGroup group5 = new LessonGroup(5);
        Student s = new Student("e", "E", 9726548, "12345678");
        Prof p = new Prof("v", "V", 5, "12345678");

        Schedule schedule = new Schedule(new TimeInterval(new Time(13, 30)), new TimeInterval(new Time(5, 00)), new WeekDay[]{WeekDay.Saturday, WeekDay.Sunday});

        Schedule scheduleInterference = new Schedule(new TimeInterval(new Time(7, 30)), new TimeInterval(new Time(10, 00)), new WeekDay[]{WeekDay.Saturday, WeekDay.Wednesday});

        LessonGroup group6 = new LessonGroup(6);
        group6.setSchedule(scheduleInterference);
        group6.setLessonCapacity(10);


        if (admin.isLogin()) {
            System.out.println(admin.getLessonGroups());
            System.out.println(admin.getStudents());
            System.out.println(admin.getProfs());

            System.out.println("add new workers : ");
            admin.setStudents(new ArrayList<>(List.of(s)));
            admin.setLessonGroups(new ArrayList<>(List.of(group5)));
            admin.setProfs(new ArrayList<>(List.of(p)));

            System.out.println(admin.getLessonGroups());
            System.out.println(admin.getStudents());
            System.out.println(admin.getProfs());

            System.out.println("Add Student : ");
            admin.addStudentToGroup(s, group5);
            System.out.println(group5.getStudents());

            System.out.println("Change GroupId : ");
            admin.changeLessonGroupId(group5, 6);
            System.out.println(group5.getLessonGroupId());
            admin.changeLessonGroupId(group5, 5);

            System.out.println("Set Scheduler : ");
            admin.changeSchedule(group5, schedule);
            System.out.println(group5.getSchedule());

            System.out.println("Set Capacity : ");
            admin.changeLessonCapacity(group5, 10);
            System.out.println(group5.getLessonCapacity());

            System.out.println("Add Prof : ");
            admin.addProfToGroup(p, group5);
            System.out.println(group5.getProfs());

            System.out.println("remove Group 5 : ");
            admin.removeGroupLesson(group5);
            System.out.println(admin.getLessonGroups());
            admin.setLessonGroups(new ArrayList<>(List.of(group5)));
            System.out.println(admin.getLessonGroups());

            System.out.println("Add Group1 to Student 1 : ");
            System.out.println("Student Lesson : " + students[0].getLessonGroups());
            students[0].removeGroupLesson(group1);
            System.out.println("Student Lesson : " + students[0].getLessonGroups());

            admin.addUnitStudent(students[0].getStudentId(), lessonGroups.get(0).getLessonGroupId());
            System.out.println("Student Lesson : " + students[0].getLessonGroups());


            group5.setListLessonPreRequire(new ArrayList<>(List.of(group1)));
            System.out.println("Requirements Group5 : " + group5.getListLessonPreRequire());
            admin.addUnitStudent(students[0].getStudentId(), group5.getLessonGroupId());


            // Check Capacity
            admin.changeLessonCapacity(group5, 0);
            admin.addUnitStudent(students[0].getStudentId(), group5.getLessonGroupId());

            // Repetition
            admin.addUnitStudent(students[0].getStudentId(), group2.getLessonGroupId());
            System.out.println("Student Lesson (Must Be One Item) : " + students[0].getLessonGroups());

            admin.addUnitStudent(students[0].getStudentId(), group6.getLessonGroupId());
            System.out.println("Student Lesson (Must Be One Item) : " + students[0].getLessonGroups());

        }
    }
}
