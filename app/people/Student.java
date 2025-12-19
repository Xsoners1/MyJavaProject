package app.people;

public class Student extends Person {
    public Student(int id, String name, String biography) {
        super(id, name, biography);
    }

    @Override
    public void describe() {
        System.out.println("[Student.describe] Студент: " + name + " (" + biography + ")");
    }

    @Override
    public String getRole() {
        return "Студент";
    }

    @Override
    public void contact() {
        System.out.println("[Student.contact] Повідомлення студенту: " + name);
    }
}
