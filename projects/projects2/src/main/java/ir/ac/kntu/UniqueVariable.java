package ir.ac.kntu;

import java.util.ArrayList;

public class UniqueVariable {
    private static final UniqueVariable INSTANCE = new UniqueVariable();
    private final ArrayList<Integer> uniqueStudentId = new ArrayList<>();
    private final ArrayList<Integer> uniqueProfId = new ArrayList<>();


    private UniqueVariable() {

    }

    public static UniqueVariable getInstance() {
        return INSTANCE;
    }

    public ArrayList<Integer> getUniqueStudentId() {
        ArrayList<Integer> newUniqueStudentId = new ArrayList<>();
        for (Integer i : uniqueStudentId) {
            newUniqueStudentId.add(i);
        }

        return newUniqueStudentId;
    }

    public void setUniqueStudentId(ArrayList<Integer> studentId) {
        for (Integer i : studentId) {
            if (!getUniqueStudentId().contains(i)) {
                uniqueStudentId.add(i);
            }
        }
    }

    public ArrayList<Integer> getUniqueProfId() {
        ArrayList<Integer> newUniqueProfId = new ArrayList<>();
        for (Integer i : uniqueProfId) {
            newUniqueProfId.add(i);
        }

        return newUniqueProfId;
    }

    public void setUniqueProfId(ArrayList<Integer> profId) {
        for (Integer i : profId) {
            if (!getUniqueProfId().contains(i)) {
                uniqueProfId.add(i);
            }
        }
    }
}
