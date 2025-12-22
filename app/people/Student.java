package app.people;

public class Student extends Person {
    public Student(String firstName, String lastName, String biography) {
        super(firstName, lastName, biography);
    }

    @Override
    public void describe() {
        System.out.println("[Student.describe] Студент: " + getName() + " (" + biography + ")");
    }

    @Override
    public String getRole() {
        return "Студент";
    }

    @Override
    public void contact() {
        System.out.println("[Student.contact] Повідомлення студенту: " + getName());
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + getName() + "', bio='" + biography + "'}";
    }
}
