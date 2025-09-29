package practichna2;

public class Student {
    private int id;
    private String profilePhoto;
    private String name;
    private String biography;
    private String courses;
    private String schedule;

    public Student(int id, String profilePhoto, String name,
                   String biography, String courses, String schedule) {
        this.id = id;
        this.profilePhoto = profilePhoto;
        this.name = name;
        this.biography = biography;
        this.courses = courses;
        this.schedule = schedule;
    }

    public void register() {}
    public void completeCourse() {}
    public void askQuestion() {}

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", courses='" + courses + '\'' +
                ", schedule='" + schedule + '\'' +
                '}';
    }
}
