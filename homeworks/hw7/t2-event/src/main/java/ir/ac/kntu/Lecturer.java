package ir.ac.kntu;

public class Lecturer extends Organizer {


    private String subject;

    public Lecturer(String name, String lastName, String subject) {
        super(name, lastName);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Subject : %s", this.subject);
    }
}
