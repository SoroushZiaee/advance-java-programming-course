package ir.ac.kntu;

public class Bat extends Animal{
    public Bat(String name, EventManager eventManager) {
        super(name);

        super.eventManager = eventManager;

        super.eventManager.add(this);
    }

    @Override
    public void update(WeatherType weatherType) {
        switch (weatherType){
            case SUNNY:
                setMood(String.format(getMood(), getName(), Satisfaction.SAD, weatherType));
            default:
                setMood(String.format(getMood(), getName(), Satisfaction.NO_DIFFERENCE, weatherType));
        }
    }
}
