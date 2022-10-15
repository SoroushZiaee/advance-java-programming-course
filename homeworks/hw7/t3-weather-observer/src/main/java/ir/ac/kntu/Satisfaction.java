package ir.ac.kntu;

public enum Satisfaction {
    SAD("Sad"), NO_DIFFERENCE("No Difference"), HAPPY("Happy");

    private final String fieldDescription;

    Satisfaction(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }
}
