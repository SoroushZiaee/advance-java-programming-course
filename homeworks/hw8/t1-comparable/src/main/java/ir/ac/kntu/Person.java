package ir.ac.kntu;

public class Person implements Comparable<Person> {

    private int id;
    private String name;
    private int age;
    private boolean single;
    private Job job;


    public Person(int id, String name, int age, boolean single, Job job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.single = single;
        this.job = job;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", single=" + single + ", job=" + job + '}' + "\n";
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.equals(o.getName())){
            return 0;
        }
        return this.name.compareTo(o.getName()) > 0 ? 1: -1;
    }

}