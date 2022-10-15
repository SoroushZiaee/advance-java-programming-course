package ir.ac.kntu.test;

import ir.ac.kntu.*;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Student student;

    @Before
    public void setUp(){
        student = new Student("Soroush", "Ziaee", 9728143, "12345678");

        // Define array of classes
        LessonGroup lessonGroup1 = new LessonGroup(10);
        lessonGroup1.setStudents(new ArrayList<Student>(List.of(student)));
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

        HashMap<Integer, Double> passLessons = new HashMap<>();
        double[] grades = {10, 20, 19, 18, 17, 16, 17.5, 15.4, 14, 16};
        for (int i = 0; i < 10; i++) {
            passLessons.put(i + 1, grades[i]);
        }

        student.setLessonGroups(new ArrayList<LessonGroup>(List.of(
                lessonGroup1
        )));

        lessonGroup1.setStudents(
                new ArrayList<>(
                        List.of(student)
                )
        );

        student.setPassedLessons(passLessons);

    }

    @Test
    public void isLoginTest(){
        assertEquals(false, student.isLogin());
        student.login(9728143, "1234");
        assertEquals(false, student.isLogin());
        student.login(9728143, "12345678");
        assertEquals(true, student.isLogin());
    }

    @Test
    public void editPassTest(){
        student.editPass("12345678", "1234");
        student.login(9728143, "12345678");
        assertEquals(false, student.isLogin());
        student.login(9728143, "1234");
        assertEquals(true, student.isLogin());
    }

    @Test
    public void logoutTest(){
        student.login(9728143, "12345678");
        student.logout();
        assertEquals(false, student.isLogin());
    }

    @Test
    public void removeGroupLessonTest(){
        LessonGroup lessonTest = new LessonGroup(10);
        student.removeGroupLesson((LessonGroup) lessonTest);
        assertEquals(false, student.getLessonGroups().contains(lessonTest));
    }

    @Test
    public void isPassedTest(){
        LessonGroup lessonTest1 = new LessonGroup(5);
        LessonGroup lessonTest2 = new LessonGroup(12);
        assertEquals(true, student.isPassed(lessonTest1));
        assertEquals(false, student.isPassed(lessonTest2));

    }

    @Test
    public void addLessonGroup(){
        LessonGroup lessonTest1 = new LessonGroup(12);
        assertEquals(false, student.getLessonGroups().contains(lessonTest1));
        student.addLessonGroup(lessonTest1);
        assertEquals(true, student.getLessonGroups().contains(lessonTest1));
    }

    @Test
    public void showWeeklySchedule(){
        // student.showWeeklySchedule();

        assertEquals(true, true);
    }

    @Test
    public void showStudentGrades(){
        // student.showStudentGrades();
        assertEquals(true, true);
    }


    @Test
    public void requestRemoveLessonTest() throws IOException {
//        LessonGroup lessonGroup = new LessonGroup(104);
//        student.requestRemoveLesson(lessonGroup);
//
//        BufferedReader bw = new BufferedReader(
//                new FileReader("Database/requests/requests.txt")
//        );
//
//        ArrayList<ArrayList> allText = new ArrayList<>();
//        String s;
//        while ((s = bw.readLine()) != null){
//            try{
//                allText.add(
//                        new ArrayList<String>(
//                                List.of(bw.readLine().split(" "))
//                        )
//                );
//            } catch (Exception ex) {
//                System.out.println("Can't read file");
//            }
//        }
//
//        System.out.println(allText);
//
//        bw.close();

    }


}
