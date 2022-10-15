package ir.ac.kntu;

public class TripParam {
    private Line line;
    private boolean peakTime;
    private boolean rainy;

    public TripParam(Line line, boolean peakTime, boolean rainy) {
        this.line = new Line(line.getSource(), line.getDestination());
        this.peakTime = peakTime;
        this.rainy = rainy;
    }

    public Line getLine() {
        return new Line(line);
    }

    public void setLine(Line line) {
        this.line = new Line(line);
    }

    public boolean isPeakTime() {
        return peakTime;
    }

    public void setPeakTime(boolean peakTime) {
        this.peakTime = peakTime;
    }

    public boolean isRainy() {
        return rainy;
    }

    public void setRainy(boolean rainy) {
        this.rainy = rainy;
    }

}
