package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Prof {
    private final ArrayList<LessonGroup> lessonGroups;
    private String name;
    private String lastName;
    private int profId;
    private String pass;
    private boolean loginStatus;
    private final UniqueVariable unique = UniqueVariable.getInstance();

    public Prof(String name, String lastName, int profId, String pass) {
        this.name = name;
        this.lastName = lastName;
        this.profId = profId;
        this.pass = pass;
        this.lessonGroups = new ArrayList<LessonGroup>();
        unique.setUniqueProfId(new ArrayList<>(List.of(this.profId)));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        for (Integer i : unique.getUniqueProfId()) {
            if (profId == i) {
                System.out.println("The profId should be unique");
            } else {
                this.profId = profId;
            }
        }
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public void login(int profId, String pass) {

        this.loginStatus = (this.pass.equals(pass) && getProfId() == profId);

        if (!this.loginStatus) {
            System.out.println("The Password or Username is wrong");
        }

    }

    public boolean isLogin() {
        return loginStatus;
    }

    public void logout() {
        this.loginStatus = false;
    }

    public void editPass(String oldPass, String newPass) {
        if (oldPass.equals(getPass())) {
            setPass(newPass);
        } else {
            System.out.println("Can't Change the password");
        }
    }

    public void removeGroupLesson(LessonGroup lg) {
        for (LessonGroup lesson : this.lessonGroups) {
            if (lesson.equals(lg)) {
                this.lessonGroups.remove(lg);
                break;
            }
        }
    }

    public void addLessonGroup(LessonGroup lg) {
        this.lessonGroups.add(lg);
    }


    public Object clone() {
        Prof prof = new Prof(this.name, this.lastName, this.profId, this.pass);
        prof.setLessonGroups(this.lessonGroups);
        return prof;
    }

    @Override
    public String toString() {
        return "Prof{" + "name='" + name + '\'' + ", lastName='" + lastName + '\'' + ", profId=" + profId + ", loginStatus=" + loginStatus + '}';
    }
}
