package app;

import app.core.CourseBase;
import app.materials.LearningMaterial;
import app.people.Student;
import app.people.Teacher;

import java.util.ArrayList;
import java.util.List;

public final class AppStorage {
    private AppStorage() {}

    public static final List<Student> students = new ArrayList<>();
    public static final List<Teacher> teachers = new ArrayList<>();
    public static final List<CourseBase> courses = new ArrayList<>();
    public static final List<LearningMaterial> materials = new ArrayList<>();

    public static void addStudent(Student s) {
        students.add(s);
        System.out.println("[AppStorage.addStudent] Додано студента: " + s.getName());
    }

    public static void addTeacher(Teacher t) {
        teachers.add(t);
        System.out.println("[AppStorage.addTeacher] Додано викладача: " + t.getName());
    }

    public static void addCourse(CourseBase c) {
        courses.add(c);
        System.out.println("[AppStorage.addCourse] Додано курс: " + c.getTitle());
    }

    public static void addMaterial(LearningMaterial m) {
        materials.add(m);
        System.out.println("[AppStorage.addMaterial] Додано матеріал: " + m.getTitle());
    }

    public static void printAll() {
        System.out.println("\n=== AppStorage: Всі дані ===");

        System.out.println("\nСтуденти:");
        for (Student s : students) System.out.println("  - " + s);

        System.out.println("\nВикладачі:");
        for (Teacher t : teachers) System.out.println("  - " + t);

        System.out.println("\nКурси:");
        for (CourseBase c : courses) System.out.println("  - " + c);

        System.out.println("\nМатеріали:");
        for (LearningMaterial m : materials) System.out.println("  - " + m.getTitle());
    }
}
