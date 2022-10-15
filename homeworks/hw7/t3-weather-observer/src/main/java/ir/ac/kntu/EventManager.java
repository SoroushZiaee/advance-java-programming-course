package ir.ac.kntu;

import java.util.ArrayList;

public class EventManager {

    private ArrayList<AliveCreature> aliveCreatures;

    private WeatherType weatherType;

    public EventManager() {
        this.aliveCreatures = new ArrayList<>();
    }

    public void add(AliveCreature aliveCreature){
        this.aliveCreatures.add(aliveCreature);
    }

    public WeatherType getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(WeatherType weatherType) {
        this.weatherType = weatherType;
    }

    public void notifyToCreature(){
        for (AliveCreature aliveCreature: aliveCreatures){
            aliveCreature.update(weatherType);
        }
    }
}
