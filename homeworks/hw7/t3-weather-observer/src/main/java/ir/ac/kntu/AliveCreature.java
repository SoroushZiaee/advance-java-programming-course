package ir.ac.kntu;

import java.util.Objects;

public abstract class AliveCreature {

    private String name;

    private String mood = "%s is %s now, because today the weather is %s";

    protected EventManager eventManager;

    public AliveCreature(String name) {
        this.name = name;
        eventManager = new EventManager();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public abstract void update(WeatherType weatherType);
}
