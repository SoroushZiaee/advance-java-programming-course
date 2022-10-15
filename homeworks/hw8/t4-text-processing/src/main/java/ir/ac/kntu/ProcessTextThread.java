package ir.ac.kntu;

import java.util.ArrayList;

public class ProcessTextThread implements Runnable{
    private GenerateTextThread generateTextThread;

    private int threadIndex;

    public ProcessTextThread(GenerateTextThread generateTextThread, int threadIndex) {
        this.generateTextThread = generateTextThread;
        this.threadIndex = threadIndex;
    }

    public int getThreadIndex() {
        return threadIndex;
    }

    public void setThreadIndex(int threadIndex) {
        this.threadIndex = threadIndex;
    }

    public GenerateTextThread getGenerateTextThread() {
        return generateTextThread;
    }

    public void setGenerateTextThread(GenerateTextThread generateTextThread) {
        this.generateTextThread = generateTextThread;
    }

    @Override
    public void run() {
        System.out.println("Thread Index : " + threadIndex);
        System.out.println(generateTextThread.getGenerateData().getTexts().toString());
        ArrayList<Integer> counts = generateTextThread.getGenerateData().countPattern();
        for (int i=0; i<generateTextThread.getGenerateData().getTexts().size(); i++){
            System.out.println("\t - Text : " + generateTextThread.getGenerateData().getTexts().get(i) + " Count : " + counts.get(i));
            generateTextThread.getGenerateData().getTexts().remove(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
