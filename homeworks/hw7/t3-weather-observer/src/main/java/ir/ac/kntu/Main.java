package ir.ac.kntu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        Human human1 =  new Human("erfan", eventManager);

        human1.setBadDesire(new ArrayList<>(
                List.of(WeatherType.RAINY)
        ));

        eventManager.setWeatherType(WeatherType.RAINY);

        eventManager.notifyToCreature();

        System.out.println(human1.getMood());
    }
}
