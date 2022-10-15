package ir.ac.kntu.test;

import ir.ac.kntu.Lesson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LessonTest {

    private Lesson lesson;
    private ArrayList<Lesson> lessonPreRequirements;

    @Before
    public void setUp() {
        lesson = new Lesson(100);

        // Create array of lesson
        Lesson[] lessons = new Lesson[10];
        for (int i = 0; i < 10; i++) {
            lessons[i] = new Lesson(i + 1);
        }
        lessonPreRequirements = new ArrayList<>(List.of(lessons));
        lesson.setListLessonPreRequire(lessonPreRequirements);

    }

    @Test
    public void testIsRequirementsCheck1() {

        Lesson lessonTest1 = new Lesson(4);
        Lesson lessonTest2 = new Lesson(11);
        assertEquals(true, lesson.isRequirements(lessonTest1));
        assertEquals(false, lesson.isRequirements(lessonTest2));

    }
}
