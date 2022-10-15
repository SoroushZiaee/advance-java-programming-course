package ir.ac.kntu;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    private final int maxTrials = 1000;

    // This is your javafx start function
    // Any improvements to this part is optional and has extra score

    public void start(Stage stage) {
        //add your nodes to pane
        stage.setTitle("PI Calculator");
        stage.setResizable(false);
        stage.show();

    }

    public void runButtonFunction() {
        //set onClick button function
    }

    private class PIComputationThread extends Thread {
        //use this thread to calculate PI with random function
    }

    private void updateDisplay() {
        // use this thread to update your frontend
        // you can use Platform.runLater to avoid IllegalStateException
    }

}