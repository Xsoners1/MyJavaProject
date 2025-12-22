package app.people;

public abstract class Person {
    protected int id;
    protected NameInfo nameInfo;
    protected String biography;

    private static int idCounter = 1;

    public static int generateId() {
        return idCounter++;
    }

    public Person(String firstName, String lastName, String biography) {
        this.id = generateId();
        this.nameInfo = new NameInfo(firstName, lastName);
        this.biography = biography;
    }

    public String getName() {
        return nameInfo.firstName + " " + nameInfo.lastName;
    }

    public abstract void describe();

    public String getRole() {
        return "Користувач";
    }

    public void contact() {
        System.out.println("[Person.contact] Зв'язок з: " + getName());
    }

    public static class NameInfo {
        public String firstName;
        public String lastName;

        public NameInfo(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
