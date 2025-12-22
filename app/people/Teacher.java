package app.people;

public class Teacher extends Person {
    public Teacher(String firstName, String lastName, String biography) {
        super(firstName, lastName, biography);
    }

    @Override
    public void describe() {
        System.out.println("[Teacher.describe] Викладач: " + getName() + " (" + biography + ")");
    }

    @Override
    public String getRole() {
        return "Викладач";
    }

    @Override
    public void contact() {
        System.out.println("[Teacher.contact] Зв'язок з викладачем: " + getName());
    }

    @Override
    public String toString() {
        return "Teacher{id=" + id + ", name='" + getName() + "', bio='" + biography + "'}";
    }
}
