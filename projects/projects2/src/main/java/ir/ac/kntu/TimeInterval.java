package ir.ac.kntu;

public class TimeInterval {
    private Time t1;

    public TimeInterval(Time t1) {
        this.t1 = t1;
    }

    public Time getT1() {
        return t1;
    }

    public void setT1(Time t1) {
        this.t1 = t1;
    }

    @Override
    public String toString() {
        return "" + t1;
    }

    // Return -1 if the time interference 1 if not
    public int compareTo(TimeInterval other) {

        int diffHour = Math.abs(this.t1.getHour() - other.getT1().getHour());
        int diffMin = Math.abs(this.t1.getMin() - other.getT1().getMin());

        if (diffHour < 1) {
            return -1;
        }

        if (diffHour == 1) {
            if (diffMin < 30) {
                return -1;
            } else {
                return 1;
            }
        }

        return 1;

    }
}
