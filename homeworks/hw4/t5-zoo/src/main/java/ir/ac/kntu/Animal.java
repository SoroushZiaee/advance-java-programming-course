package ir.ac.kntu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Animal {
    public static int animalCount = 0;
    private final int id;
    private String name;
    private String color;
    private double height;
    private int weight;
    private int age;

    public Animal(String name, String color, double height, int weight, int age) {
        this.id = Animal.animalCount;
        if (checkName(name)) {
            this.name = name;
        } else {
            this.name = null;
        }

        if (checkName(color)) {
            this.color = color;
        } else {
            this.color = null;
        }

        if (height > 0) {
            this.height = height;
        } else {
            this.height = 0;
        }
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        if (age > 0) {
            this.age = age;
        } else {
            this.age = 0;
        }

        Animal.animalCount += 1;

    }

    static Boolean checkName(String str) {
        Pattern regexEmail = Pattern.compile("^[a-zA-Z]+$");
        Matcher checkEmail = regexEmail.matcher(str);
        return checkEmail.matches();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkName(name)) {
            this.name = name;
        } else {
            this.name = this.getName();
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (checkName(color)) {
            this.color = color;
        } else {
            this.color = this.getColor();
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height > 0) {
            this.height = height;
        } else {
            this.height = this.getHeight();
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 0) {
            this.weight = weight;
        } else {
            this.weight = this.getWeight();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            this.age = this.getAge();
        }
    }
}
