package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Objects;

/**
 * The Lesson class store the id and name of the lessons
 *
 * @author Soroush Ziaee
 * @version 2, 4, Jan, 2022
 */

public class Lesson {
    private final ArrayList<Lesson> lessonPreRequirements;
    private int lessonId;
    private String lessonName;

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
        this.lessonPreRequirements = new ArrayList<Lesson>();
    }

    public Lesson(int lessonId) {
        this.lessonId = lessonId;
        this.lessonPreRequirements = new ArrayList<Lesson>();
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }


    // override clone method to apply encapsulation pillar for getter and setter of LessonPreRequirements
    public Object clone() {
        Lesson aClone = new Lesson(this.lessonName);
        aClone.setLessonId(this.lessonId);
        aClone.setListLessonPreRequire(this.lessonPreRequirements);
        return aClone;
    }

    public ArrayList<Lesson> getListLessonPreRequire() {
        ArrayList<Lesson> lessonList = new ArrayList<Lesson>();
        for (Lesson alesson : this.lessonPreRequirements) {
            lessonList.add((Lesson) alesson.clone());
        }

        return lessonList;
    }

    public void setListLessonPreRequire(ArrayList<Lesson> lessons) {
        for (Lesson l : lessons) {
            this.lessonPreRequirements.add((Lesson) l.clone());
        }
    }

    /**
     * check if a lesson is required by other class
     *
     * @param lesson
     * @return boolean
     */
    public boolean isRequirements(Lesson lesson) {
        for (Lesson aLesson : this.lessonPreRequirements) {
            if (aLesson.equals(lesson)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Lesson)) {
            return false;
        }
        Lesson lesson = (Lesson) o;
        return getLessonId() == lesson.getLessonId() && Objects.equals(getLessonName(), lesson.getLessonName());
    }
}
