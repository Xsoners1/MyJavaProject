package app.restricted;

public class Teacher {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    void setGrade(Student student, int grade) {
        student.setGrade(grade);
    }

    @Override
    public String toString() {
        return "Teacher: " + name;
    }
}
