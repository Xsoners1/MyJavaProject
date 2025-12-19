package app.people;

public abstract class Person {
    protected int id;
    protected String name;
    protected String biography;

    public Person(int id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }

    public String getName() {
        return name;
    }

    public abstract void describe();

    public String getRole() {
        return "Користувач";
    }

    public void contact() {
        System.out.println("[Person.contact] Зв'язок з: " + name);
    }
}
