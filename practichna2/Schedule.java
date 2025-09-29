package practichna2;

public class Schedule {
    private int id;
    private int subjectsCount;
    private String subjectsList;

    public Schedule(int id, int subjectsCount, String subjectsList) {
        this.id = id;
        this.subjectsCount = subjectsCount;
        this.subjectsList = subjectsList;
    }

    public void addSubject() {}
    public void changeTime() {}

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", subjectsCount=" + subjectsCount +
                ", subjectsList='" + subjectsList + '\'' +
                '}';
    }
}
