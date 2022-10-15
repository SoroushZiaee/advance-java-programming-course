package ir.ac.kntu;

import org.junit.experimental.theories.Theories;

public class GenerateTextThread implements Runnable{
    private GenerateData generateData;

    private int threadIndex;

    public GenerateTextThread(GenerateData generateData, int threadIndex) {
        this.generateData = generateData;
        this.threadIndex = threadIndex;
    }

    public int getThreadIndex() {
        return threadIndex;
    }

    public void setThreadIndex(int threadIndex) {
        this.threadIndex = threadIndex;
    }

    public GenerateData getGenerateData() {
        return generateData;
    }

    public void setGenerateData(GenerateData generateData) {
        this.generateData = generateData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.generateData.generateText(100);
            System.out.println("Thread Index : " + threadIndex);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
