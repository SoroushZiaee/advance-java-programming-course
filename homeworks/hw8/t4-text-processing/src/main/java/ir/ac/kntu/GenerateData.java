package ir.ac.kntu;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateData {

    private final ArrayList<String> texts;
    private String pattern;

    public GenerateData(String pattern) {
        this.pattern = pattern;
        this.texts = new ArrayList<>();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public ArrayList<String> getTexts() {
        return new ArrayList<>(texts);
    }

    public void setTexts(ArrayList<String> texts) {
        this.texts.addAll(texts);

    }

    public void addText(String text){
        this.texts.add(text);
    }

    public void generateText(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);
        setTexts(new ArrayList<>(
                List.of(new String(array, StandardCharsets.UTF_8).replaceAll("[^a-zA-Z]", "")
                ))
        );
    }

    public ArrayList<Integer> countPattern(){
        ArrayList<Integer> output = new ArrayList<>();
        for (String text: texts){
            output.add(
                    (int) Arrays.stream(text.split(" ")).filter((t) -> t.contains(pattern)).count()
            );
        }
        return output;
    }
}
