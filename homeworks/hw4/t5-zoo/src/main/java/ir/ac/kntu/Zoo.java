package ir.ac.kntu;

import java.util.ArrayList;

public class Zoo {

    private final Logger INSTANCE = Logger.getInstance();
    //add zoo fields to your class
    //dont forget to write a constructor , getter and setter function
    //your constructor should be in this pattern:Zoo(ArrayList<Animal>)
    //write a getter function for an Arraylist that returns a copy of it
    private ArrayList<Animal> animals;
    private ArrayList<String> records;

    public Zoo(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<String> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<String> loggerInfo) {
        this.records = new ArrayList<>(loggerInfo);
    }

    public Boolean checkBmi(double h, int w) {
        return w / h > 10;
    }

    public void collectVulnerableAnimalRecords() {
        //complete this function

        for (Animal animal : this.animals) {
            if (animal.getAge() > 5 | (checkBmi(animal.getHeight(), animal.getWeight()))) {
                INSTANCE.info(String.format("{%s, %s, %d, %d, %f}", animal.getId(), animal.getName(), animal.getAge(), animal.getWeight(), animal.getHeight()));
            }
        }
        this.setRecords(INSTANCE.getInfo());
    }
}
