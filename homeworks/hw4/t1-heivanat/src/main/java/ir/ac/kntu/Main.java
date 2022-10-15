package ir.ac.kntu;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("name", "color", 120, 65, 4);
        System.out.println(animal.getAge());
        System.out.println(animal.getColor());
        System.out.println(animal.getName());
        System.out.println(animal.getHeight());
        System.out.println(animal.getAge());

    }
}