package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Person class to create student and prof
 *
 * @author Soroush Ziaee
 * @version 2 3, Jan, 2022
 */

public abstract class Person {
    // Make Lesson group protected
    protected ArrayList<LessonGroup> lessonGroups;
    private String name;
    private String lastname;
    private final int id;
    private String pass;
    private boolean loginStatus;


    public Person(String name, String lastname, int id, String pass) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
        this.pass = pass;
        this.lessonGroups = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    // Make the getPass protected to use in student class
    protected String getPass() {
        return pass;
    }

    private void setPass(String pass) {
        this.pass = pass;
    }


    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public ArrayList<LessonGroup> getLessonGroups() {
        ArrayList<LessonGroup> newLessonGroup = new ArrayList<LessonGroup>();
        for (LessonGroup lg : this.lessonGroups) {
            newLessonGroup.add((LessonGroup) lg.clone());
        }
        return newLessonGroup;
    }

    public void setLessonGroups(ArrayList<LessonGroup> lessonGroup) {
        for (LessonGroup lg : lessonGroup) {
            this.lessonGroups.add((LessonGroup) lg.clone());
        }
    }

    /**
     * Login the student to the system
     *
     * @param studentId
     * @param pass
     */

    public void login(int studentId, String pass) {
        this.loginStatus = (this.pass.equals(pass) && studentId == getId());
        if (!this.loginStatus) {
            System.out.println("The Password or Username is wrong");
        }
    }

    /**
     * Check if the student is logged in or not
     *
     * @return
     */
    public boolean isLogin() {
        return loginStatus;
    }

    /**
     * Change the password you must enter the old password and the new password
     *
     * @param oldPass
     * @param newPass
     */
    public void editPass(String oldPass, String newPass) {
        if (oldPass.equals(getPass())) {
            setPass(newPass);
        } else {
            System.out.println("Can't Change the password");
        }
    }

    /**
     * Logout the student from system
     */
    public void logout() {
        this.loginStatus = false;
    }

    /**
     * Remove a lesson from student lesson
     *
     * @param lg
     */
    public void removeGroupLesson(LessonGroup lg) {
        for (LessonGroup lesson : this.lessonGroups) {
            if (lesson.equals(lg)) {
                this.lessonGroups.remove(lg);
                break;
            }
        }
    }

    /**
     * print class info
     *
     * @param nameDay
     * @param lessonGroups
     */
    private void printWeeklyLesson(String nameDay, ArrayList<LessonGroup> lessonGroups) {
        System.out.println("\t-" + nameDay);
        if (!lessonGroups.isEmpty()) {
            for (LessonGroup lg : lessonGroups) {
                System.out.println("\t\t - " + lg);
            }
        } else {
            System.out.println("\t - No Lesson on this day");
        }
    }

    /**
     * Print the student lesson info
     */
    public void showWeeklySchedule() {
        ArrayList<LessonGroup> saturday = new ArrayList<>();
        ArrayList<LessonGroup> sunday = new ArrayList<>();
        ArrayList<LessonGroup> monday = new ArrayList<>();
        ArrayList<LessonGroup> tuesday = new ArrayList<>();
        ArrayList<LessonGroup> wednesday = new ArrayList<>();

        for (LessonGroup lessonGroup : this.lessonGroups) {
            WeekDay[] weekDay = lessonGroup.getSchedule().getDays();

            if (weekDay[0] == WeekDay.Saturday || weekDay[1] == WeekDay.Saturday) {
                saturday.add(lessonGroup);
            }
            if (weekDay[0] == WeekDay.Sunday || weekDay[1] == WeekDay.Sunday) {
                sunday.add(lessonGroup);
            }
            if (weekDay[0] == WeekDay.Monday || weekDay[1] == WeekDay.Monday) {
                monday.add(lessonGroup);
            }
            if (weekDay[0] == WeekDay.Tuesday || weekDay[1] == WeekDay.Tuesday) {
                tuesday.add(lessonGroup);
            }
            if (weekDay[0] == WeekDay.Wednesday || weekDay[1] == WeekDay.Wednesday) {
                wednesday.add(lessonGroup);
            }

            printWeeklyLesson("Saturday", saturday);
            printWeeklyLesson("Sunday", sunday);
            printWeeklyLesson("Monday", monday);
            printWeeklyLesson("Tuesday", tuesday);
            printWeeklyLesson("Wednesday", wednesday);

        }
    }

    public void removeLessonGroup() {
        this.lessonGroups = new ArrayList<>();
    }

    public void addUnitStudent(Student student, LessonGroup lessonGroup, String typeClass) {
        if (typeClass.equals("offline")) {
            OfflineLesson offlineLesson = new OfflineLesson(100, 2);
            offlineLesson.addUnitStudent(student.getId(), lessonGroup.getLessonId());
        } else if (typeClass.equals("online")) {
            OnlineLesson onlineLesson = new OnlineLesson();
            onlineLesson.addUnitStudent(student.getId(), lessonGroup.getLessonId());
        }

    }

    /**
     * Add a lesson to lesson group
     *
     * @param lg
     */
    public abstract void addLessonGroup(LessonGroup lg);

}
