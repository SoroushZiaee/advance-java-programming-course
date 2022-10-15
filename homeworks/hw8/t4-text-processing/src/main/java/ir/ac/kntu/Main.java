package ir.ac.kntu;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GenerateData generateData = new GenerateData("ab");
        GenerateTextThread generateTextThread = new GenerateTextThread(generateData, 0);
        ProcessTextThread processTextThread = new ProcessTextThread(generateTextThread, 1);

        Thread thread1 = new Thread(generateTextThread);
        Thread thread2 = new Thread(processTextThread);

        thread1.setPriority(10);
        thread2.setPriority(1);

        thread1.start();
        thread2.start();

        System.out.println(generateData.countPattern());
    }
}
