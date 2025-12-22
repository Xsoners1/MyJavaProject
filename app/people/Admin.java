package app.people;

public class Admin extends Person {
    public Admin(String firstName, String lastName, String biography) {
        super(firstName, lastName, biography);
    }

    @Override
    public void describe() {
        System.out.println("[Admin.describe] Адміністратор: " + getName() + " (" + biography + ")");
    }

    @Override
    public String getRole() {
        return "Адміністратор";
    }

    @Override
    public void contact() {
        System.out.println("[Admin.contact] Створено тикет підтримки для: " + getName());
    }

    @Override
    public String toString() {
        return "Admin{id=" + id + ", name='" + getName() + "', bio='" + biography + "'}";
    }
}
