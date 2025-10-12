package app.restricted;

public class Student {
    private String name;
    private int grade;

    public Student(String name) {
        this.name = name;
        this.grade = 0;
    }

    void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", Grade: " + grade;
    }
}

