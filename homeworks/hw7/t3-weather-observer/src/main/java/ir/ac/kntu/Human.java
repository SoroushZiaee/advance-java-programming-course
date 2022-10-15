package ir.ac.kntu;

import java.util.ArrayList;

public class Human extends AliveCreature{

    private ArrayList<WeatherType> badDesire;

    private ArrayList<WeatherType> goodDesire;

    public Human(String name, EventManager eventManager) {
        super(name);

        super.eventManager = eventManager;

        this.badDesire = new ArrayList<>();

        this.goodDesire = new ArrayList<>();

        super.eventManager.add(this);
    }

    public ArrayList<WeatherType> getBadDesire() {
        return new ArrayList<>(getBadDesire());
    }

    public void setBadDesire(ArrayList<WeatherType> badDesire) {
        this.badDesire = new ArrayList<>(badDesire);
    }

    public ArrayList<WeatherType> getGoodDesire() {
        return new ArrayList<>(this.goodDesire);
    }

    public void setGoodDesire(ArrayList<WeatherType> goodDesire) {
        this.goodDesire = new ArrayList<>(goodDesire);
    }

    @Override
    public void update(WeatherType weatherType) {
        if (badDesire.contains(weatherType)){
            setMood(String.format(getMood(), getName(), Satisfaction.SAD.getFieldDescription(), weatherType.getFieldDescription()));
        } else if (goodDesire.contains(weatherType)){
            setMood(String.format(getMood(), getName(), Satisfaction.HAPPY.getFieldDescription(), weatherType.getFieldDescription()));
        } else {
            setMood(String.format(getMood(), getName(), Satisfaction.NO_DIFFERENCE.getFieldDescription(), weatherType.getFieldDescription()));
        }
    }
}
