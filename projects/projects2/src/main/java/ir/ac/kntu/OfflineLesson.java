package ir.ac.kntu;

public class OfflineLesson extends Course implements Add {
    private final int classCapacity;
    private final int classId;

    public OfflineLesson(int classCapacity, int classId) {
        this.classCapacity = classCapacity;
        this.classId = classId;
    }

    @Override
    public void addUnitStudent(int studentId, int lessonGroupId) {
        Student s = db.getStudentById(studentId);
        LessonGroup lg = db.getLessonGroupById(lessonGroupId);

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

        if (this.classCapacity <= 0) {
            System.out.println("Capacity is 0");
            System.out.println();
            isAddable = false;
        }

        // Check if the lesson has capacity
        if (lg.getLessonCapacity() <= 0) {
            System.out.println("Capacity is 0");
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
            System.out.println("Lesson add Successfully");
            lg.setLessonCapacity(lg.getLessonCapacity() - 1);
        }
    }
}
