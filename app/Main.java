package app;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Alice", "Interested in programming");
        Course course = new Course(1, "Java Basics", "Introduction to programming");
        Schedule schedule = new Schedule(2);

        student.enroll(course);
        student.updateBiography("Now studying Java OOP");
        schedule.addSubject();
        course.addMaterial("Encapsulation and Classes");

        System.out.println("\n--- Current State ---");
        System.out.println(student);
        System.out.println(course);
        System.out.println("Subjects in schedule: " + schedule.getSubjectsCount());
    }
}
