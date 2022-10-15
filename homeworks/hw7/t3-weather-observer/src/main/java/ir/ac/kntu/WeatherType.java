package ir.ac.kntu;

public enum WeatherType {
    SUNNY("Sunny"), RAINY("Rainy"), WINDY("Windy"), COLD("Cold");

    private final String fieldDescription;

    WeatherType(String value){
        this.fieldDescription = value;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
