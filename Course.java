package yashpc.commonCodingChallenges;

public class Course {

    private int startTime;
    private int duration;
    private int credits;
    private int endTime;

    public Course(int startTime, int duration, int credits) {
        this.startTime = startTime;
        this.duration = duration;
        this.credits = credits;
        this.endTime = startTime + duration;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "startTime=" + startTime +
                ", duration=" + duration +
                ", credits=" + credits +
                ", endTime=" + endTime +
                '}';
    }
}
