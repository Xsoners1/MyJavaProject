package app.people;

public class Admin extends Person {
    public Admin(int id, String name, String biography) {
        super(id, name, biography);
    }

    @Override
    public void describe() {
        System.out.println("[Admin.describe] Адміністратор: " + name + " (" + biography + ")");
    }

    @Override
    public String getRole() {
        return "Адміністратор";
    }

    @Override
    public void contact() {
        System.out.println("[Admin.contact] Створено тикет підтримки для: " + name);
    }
}
