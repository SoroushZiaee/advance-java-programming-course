package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Animal a1 = new Animal("happya", "black", 0.5, 30, 5);
        Animal a2 = new Animal("happyb", "black", 0.5, 60, 5);
        Animal a3 = new Animal("happyc", "black", 0.8, 50, 7);
        Animal a4 = new Animal("happyd", "black", 0.5, 40, 12);
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(a1, a2, a3, a4));

        Zoo zoo = new Zoo(animals);
        zoo.collectVulnerableAnimalRecords();
        ArrayList<String> records = zoo.getRecords();

        System.out.println(records);
    }
}