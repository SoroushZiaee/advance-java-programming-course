package ir.ac.kntu;

enum Place {
    Faculty, Dorm
}

public abstract class Meal {
    private Place place;

    public Meal(Place place) {
        this.place = place;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
}
