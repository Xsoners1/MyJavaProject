package app;

class Course { // package-private class
    private int id;
    private String title;
    private String description;

    Course(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    void addMaterial(String material) { // package-private method
        System.out.println("Added material: " + material + " to " + title);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
