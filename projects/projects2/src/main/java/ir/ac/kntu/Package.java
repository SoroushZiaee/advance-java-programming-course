package ir.ac.kntu;

import java.util.ArrayList;

public class Package {
    private ArrayList<Food> foods;

    public Package() {
        this.foods = new ArrayList<>();
    }


    public ArrayList<Food> getFoods() throws CloneNotSupportedException {
        ArrayList<Food> newFoods = new ArrayList<>();
        for (Food food: foods){
            newFoods.add((Food) food.clone());
        }
        return newFoods;
    }

    public void setFoods(ArrayList<Food> foods) {
        for (Food food: foods){
            this.foods.add(food);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
