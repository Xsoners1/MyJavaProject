package practichna2;

public class Course {
    private int id;
    private String title;
    private String description;
    private String teachers;

    public Course(int id, String title, String description, String teachers) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.teachers = teachers;
    }

    public void addMaterial() {}
    public void startLesson() {}

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", teachers='" + teachers + '\'' +
                '}';
    }
}
