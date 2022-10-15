package ir.ac.kntu.test;

import ir.ac.kntu.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class OfflineLessonTest {

    private Database db;
    private OfflineLesson course;
    private ArrayList<LessonGroup> lessonGroups;
    private ArrayList<Student> students;
    private ArrayList<Prof> profs;

    @Before
    public void setUp(){
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

        Time[] timesStart = {new Time(7, 30), new Time(9, 00),
                new Time(10, 30), new Time(12, 00),
                new Time(15, 30)};
        Time[] timeEnd = {new Time(9, 00), new Time(10, 30),
                new Time(12, 00), new Time(13, 00),
                new Time(17, 00)};

        WeekDay[][] weekDays = {{WeekDay.Saturday, WeekDay.Monday}, {WeekDay.Sunday, WeekDay.Tuesday},
                {WeekDay.Saturday, WeekDay.Monday}, {WeekDay.Monday, WeekDay.Wednesday},
                {WeekDay.Monday, WeekDay.Wednesday}};

        Schedule[] schedules = {new Schedule(new TimeInterval(timesStart[0]),
                new TimeInterval(timeEnd[0]), weekDays[0]), new Schedule(new TimeInterval(timesStart[1]),
                new TimeInterval(timeEnd[1]), weekDays[1]), new Schedule(new TimeInterval(timesStart[2]),
                new TimeInterval(timeEnd[2]), weekDays[2]), new Schedule(new TimeInterval(timesStart[3]),
                new TimeInterval(timeEnd[3]), weekDays[3]), new Schedule(new TimeInterval(timesStart[4]),
                new TimeInterval(timeEnd[4]), weekDays[4]),};

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

        ArrayList<ArrayList<Lesson>> lessonPreRequirements = new ArrayList<ArrayList<Lesson>>(
                List.of(new ArrayList<Lesson>(List.of(group2, group3, group4)),
                        new ArrayList<Lesson>(List.of(group1, group3)),
                        new ArrayList<Lesson>(List.of(group4)),
                        new ArrayList<Lesson>(List.of(group2, group3)),
                        new ArrayList<Lesson>(List.of(group1)))
        );

        for (int i = 0; i < this.lessonGroups.size(); i++) {
            this.lessonGroups.get(i).setListLessonPreRequire(lessonPreRequirements.get(i));
        }

        this.students = new ArrayList<>(List.of(new Student[]{
                new Student("a", "A", 9728143, "12345678"),
                new Student("b", "B", 9729843, "12345678"),
                new Student("c", "C", 9730303, "12345678"),
                new Student("d", "D", 9727283, "12345678"),
        }));
        this.profs = new ArrayList<>(List.of(new Prof[]{
                new Prof("z", "Z", 1, "12345678"),
                new Prof("y", "Y", 2, "12345678"),
                new Prof("x", "X", 3, "12345678"),
                new Prof("w", "W", 4, "12345678"),
        }));

        ArrayList<ArrayList> profGroupLesson = new ArrayList<>(
                List.of(
                        new ArrayList<Lesson>(List.of(group1, group2)),
                        new ArrayList<Lesson>(List.of(group3, group4)),
                        new ArrayList<Lesson>(List.of(group1, group4)),
                        new ArrayList<Lesson>(List.of(group2, group3))
                )
        );

        for (int i = 0; i < profs.size(); i++) {
            this.profs.get(i).setLessonGroups(profGroupLesson.get(i));
        }

        ArrayList<HashMap> grade = new ArrayList<HashMap>(
                List.of(
                        new HashMap<Integer, Double>(),
                        new HashMap<Integer, Double>(),
                        new HashMap<Integer, Double>(),
                        new HashMap<Integer, Double>()
                )
        );

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

        ArrayList<ArrayList> studentLesson = new ArrayList<>(
                List.of(
                        new ArrayList<LessonGroup>(List.of(group1)),
                        new ArrayList<LessonGroup>(List.of(group2)),
                        new ArrayList<LessonGroup>(List.of(group3)),
                        new ArrayList<LessonGroup>(List.of(group4))
                )
        );

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

        db.setStudents(this.students);
        db.setProfs(this.profs);
        db.setLessonGroups(this.lessonGroups);

        course = new OfflineLesson(100, 1);
    }

    @Test
    public void addUnitStudentTest(){
        LessonGroup lessonGroup = new LessonGroup(101);
        lessonGroup.setSchedule(
                new Schedule(
                        new TimeInterval(
                                new Time(20, 30)
                        ),
                        new TimeInterval(
                                new Time(10, 00)
                        ),
                        new WeekDay[]{
                                WeekDay.Saturday, WeekDay.Monday
                        }
                )
        );

        lessonGroup.setLessonCapacity(100);

        db.setLessonGroups(
                new ArrayList<>(
                        List.of(lessonGroup)
                )
        );

        Student student = db.getStudentById(9728143);

        LessonGroup lessonGroupRequire = new LessonGroup(11);
        lessonGroup.setListLessonPreRequire(
                new ArrayList<>(
                        List.of(lessonGroupRequire)
                )
        );

        HashMap<Integer, Double> grades = new HashMap<>();
        grades.put(11, 20.0);
        student.setPassedLessons(
                grades
        );

        course.addUnitStudent(student.getId(), lessonGroup.getLessonGroupId());

        assertEquals(lessonGroup.getLessonId(),
                db.getStudents().get(db.getStudents().size() - 1).getLessonGroups().get(
                        db.getStudents().get(db.getStudents().size() - 1).getLessonGroups().size() - 1
                ).getLessonId());

    }
}
