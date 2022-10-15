package ir.ac.kntu;

class Student extends Person{
    private final String classStatus;
    private String academy;

    public Student(String name, String address, String phoneNumber, String email, String classStatus, String academy) {
        super(name, address, phoneNumber, email);
        this.classStatus = classStatus;
        this.academy = academy;
    }

    public void study(){
        System.out.println("aval insta...");
    }

    public void liveInPeace(){
        System.out.println("404 not found!");
    }

    private void payTuition(){
        System.out.println("money down the drain");
    }

    @Override
    public String toString(){
        return super.toString() + ", Class: " + classStatus;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public String getAcademy() {
        return academy;
    }
}