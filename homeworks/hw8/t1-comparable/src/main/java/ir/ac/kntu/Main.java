package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void printList(ArrayList<Person> persons) {
        System.out.println("----------Print the persons-----------");
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {

        Comparator<Person> comparatorSalary = (Person p1, Person p2) -> {
            return Integer.compare(p1.getJob().getIncome(), p2.getJob().getIncome());
        };

        Comparator<Person> comparatorSingle = (Person p1, Person p2) -> {
            return Boolean.compare(p1.isSingle(), p2.isSingle());
        };

        String[] jobTitles = {"Programmer", "Engineer", "Doctor"};
        String[] names = {"Soroush", "Milad", "Erfan"};
        int[] incomes = {1000, 500, 1100};
        Boolean[] singles = {true, false, true};
        int[] ages = {18, 35, 22};

        ArrayList<Person> persons = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            persons.add(new Person(i, names[i], ages[i], singles[i], new Job(jobTitles[i], incomes[i])));
        }

        printList(persons);

        Collections.sort(persons);

        printList(persons);

        persons.sort(comparatorSalary);

        printList(persons);

        persons.sort(comparatorSingle);

        printList(persons);

    }
}
