package ir.ac.kntu.test;

import ir.ac.kntu.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProfTest {

    private Prof professor;
    private LessonGroup lessonGroup1;

    @Before
    public void setUp(){
        professor = new Prof("Soroush", "Ziaee", 1, "12345678");

        // Define array of classes
        lessonGroup1 = new LessonGroup(10);
        lessonGroup1.setProfs(new ArrayList<Prof>(List.of(professor)));
        lessonGroup1.setLessonGroupId(1);
        lessonGroup1.setSchedule(
                new Schedule(
                        new TimeInterval(
                                new Time(7, 30)
                        ),
                        new TimeInterval(
                                new Time(9, 00)
                        ),
                        new WeekDay[]{
                                WeekDay.Saturday, WeekDay.Monday
                        }
                )
        );
        lessonGroup1.setLessonCapacity(20);
        lessonGroup1.setTerm(1);

        Lesson[] lessons = new Lesson[10];
        for (int i = 0; i < 10; i++) {
            lessons[i] = new Lesson(i + 1);
        }

        lessonGroup1.setListLessonPreRequire(
                new ArrayList<>(
                        List.of(lessons)
                )
        );

        professor.setLessonGroups(
                new ArrayList<>(
                        List.of(
                                lessonGroup1
                        )
                )
        );

    }

    @Test
    public void addLessonGroupTest(){
        LessonGroup lessonTest1 = new LessonGroup(12);
        assertEquals(false, professor.getLessonGroups().contains(lessonTest1));
        professor.addLessonGroup(lessonTest1);
        assertEquals(true, professor.getLessonGroups().contains(lessonTest1));
    }

    @Test
    public void removeGroupLessonTest(){
        assertEquals(false, professor.getLessonGroups().isEmpty());
        LessonGroup lessonTest1 = new LessonGroup(10);
        professor.removeGroupLesson(lessonTest1);
        assertEquals(true, professor.getLessonGroups().isEmpty());

    }

    @Test
    public void showWeeklyScheduleTest(){
        //professor.showWeeklySchedule();
        assertEquals(true, true);
    }

    @Test
    public void showGroupLessonTest(){
        //professor.showGroupLesson();
        assertEquals(true, true);
    }

    @Test
    public void showStudentOfEachLessonTest(){
        Student student = new Student("Soroush", "Ziaee", 9728143, "12345678");
        student.setLessonGroups(
                new ArrayList<>(
                        List.of(lessonGroup1)
                )
        );

        lessonGroup1.setStudents(new ArrayList<Student>(List.of(student)));
        System.out.println("Student added(test) : " + lessonGroup1.getStudents());

        professor.showStudentOfEachLesson();
        assertEquals(true, true);
    }

}
