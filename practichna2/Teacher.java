package practichna2;

public class Teacher {
    private int id;
    private String photo;
    private String name;
    private String courses;
    private String schedule;
    private String students;
    private String intensity;
    private String biography;

    public Teacher(int id, String photo, String name, String courses, String schedule,
                   String students, String intensity, String biography) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.courses = courses;
        this.schedule = schedule;
        this.students = students;
        this.intensity = intensity;
        this.biography = biography;
    }

    public void createCourse() {}
    public void checkAssignment() {}
    public void giveFeedback() {}

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                ", name='" + name + '\'' +
                ", courses='" + courses + '\'' +
                ", schedule='" + schedule + '\'' +
                ", students='" + students + '\'' +
                ", intensity='" + intensity + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }
}
