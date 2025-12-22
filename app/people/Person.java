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
    public abstract String getRole();
    public abstract void contact();

    public static class NameInfo {
        public String firstName;
        public String lastName;

        public NameInfo(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    @Override
    public String toString() {
        return "Person{id=" + id + ", name='" + getName() + "', bio='" + biography + "'}";
    }
}
