package app;

public class Schedule {
    private int subjectsCount;

    public Schedule(int subjectsCount) {
        this.subjectsCount = subjectsCount;
    }

    public void addSubject() {
        subjectsCount++;
        System.out.println("Added new subject. Total: " + subjectsCount);
    }

    public int getSubjectsCount() {
        return subjectsCount;
    }
}
