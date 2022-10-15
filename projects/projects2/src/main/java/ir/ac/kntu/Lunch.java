package ir.ac.kntu;

import java.util.ArrayList;

public class Lunch extends Meal {
    private ArrayList<Package> packages;

    public Lunch(Place place) {
        super(place);
    }

    public ArrayList<Package> getPackages() throws CloneNotSupportedException {
        ArrayList<Package> newPackages = new ArrayList<>();
        for (Package p : packages) {
            newPackages.add((Package) p.clone());
        }
        return newPackages;
    }

    public void setPackages(ArrayList<Package> packages) {
        for (Package p : packages) {
            this.packages.add(p);
        }
    }


}
