package practichna2;

public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1, "photo.jpg", "Андрій Куляк", "Java, OOP",
                "Mon-Tue", "Group-1", "High", "Associate Professor of IT");
        Student user = new Student(2, "user.jpg", "Варивода Володимир",
                "3nd-year student", "Java", "Mon-Tue");
        Course course = new Course(3, "Java Basics", "object-oriented programming", "Андрій Куляк");
        Schedule schedule = new Schedule(4, 3, "Java, OOP, Databases");

        System.out.println(teacher.toString());
        System.out.println(user.toString());
        System.out.println(course.toString());
        System.out.println(schedule.toString());
    }
}
