package app.people;

public class Teacher extends Person {
    public Teacher(int id, String name, String biography) {
        super(id, name, biography);
    }

    @Override
    public void describe() {
        System.out.println("[Teacher.describe] Викладач: " + name + " (" + biography + ")");
    }

    @Override
    public String getRole() {
        return "Викладач";
    }

    @Override
    public void contact() {
        System.out.println("[Teacher.contact] Зв'язок з викладачем: " + name);
    }
}
