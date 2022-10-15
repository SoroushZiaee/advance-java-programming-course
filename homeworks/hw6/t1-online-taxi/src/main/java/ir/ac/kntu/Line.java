package ir.ac.kntu;

import java.util.Objects;

public class Line {
    private int source;
    private int destination;

    public Line(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public Line(Line line) {
        this.source = line.source;
        this.destination = line.destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return source == line.source &&
                destination == line.destination;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }
}
