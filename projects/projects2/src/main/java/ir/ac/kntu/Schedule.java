package ir.ac.kntu;

import java.util.Arrays;

public class Schedule {
    private TimeInterval startTime;
    private TimeInterval endTime;
    private WeekDay[] days;

    public Schedule(TimeInterval startTime, TimeInterval endTime, WeekDay[] days) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.days = days;
    }

    public TimeInterval getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeInterval startTime) {
        this.startTime = startTime;
    }

    public TimeInterval getEndTime() {
        return endTime;
    }

    public void setEndTime(TimeInterval endTime) {
        this.endTime = endTime;
    }

    public WeekDay[] getDays() {
        WeekDay[] copy = new WeekDay[this.days.length];
        System.arraycopy(this.days, 0, copy, 0, copy.length);
        return copy;
    }

    public void setDays(WeekDay[] days) {
        this.days = new WeekDay[days.length];
        System.arraycopy(days, 0, this.days, 0, days.length);
    }

    public int compareTo(Schedule other) {
        if (this.days[0] == other.getDays()[0] || this.days[1] == other.getDays()[1]) {
            return this.startTime.compareTo(other.getStartTime());
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Schedule{" + "startTime=" + startTime.getT1().getHour() + ":" + startTime.getT1().getMin() + ", endTime=" + endTime.getT1().getHour() + ":" + endTime.getT1().getMin() + ", days=" + Arrays.toString(days) + '}';
    }
}