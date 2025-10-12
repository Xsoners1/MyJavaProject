package app;

public class Student {
    private int id;
    private String name;
    private String biography;
    private String courseName;

    public Student(int id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.courseName = "None";
    }

    public void enroll(Course course) {
        this.courseName = course.getTitle();
        System.out.println(name + " enrolled in " + courseName);
    }

    public void updateBiography(String newBio) {
        this.biography = newBio;
        System.out.println(name + "'s biography updated.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}

