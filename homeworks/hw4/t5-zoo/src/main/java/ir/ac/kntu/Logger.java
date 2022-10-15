package ir.ac.kntu;


import java.util.ArrayList;

public class Logger {
    private static final Logger INSTANCE = new Logger();
    private final ArrayList<String> errorList = new ArrayList<>();
    private final ArrayList<String> infoList = new ArrayList<>();
    private final ArrayList<String> warnList = new ArrayList<>();


    private Logger() {
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public void error(String e) {
        errorList.add(e);
    }

    public void info(String i) {
        infoList.add(i);
    }

    public void warn(String w) {
        warnList.add(w);
    }

    public ArrayList<String> getErrors() {
        return errorList;
    }

    public ArrayList<String> getInfo() {
        return infoList;
    }

    public ArrayList<String> getWarns() {
        return warnList;
    }
}
