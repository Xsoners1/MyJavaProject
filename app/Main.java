package app;

import app.core.*;
import app.materials.*;
import app.people.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Система онлайн-курсів (Практична №5) ===");

        System.out.print("Введіть назву курсу: ");
        String courseTitle = sc.nextLine();

        System.out.print("Введіть опис курсу: ");
        String courseDesc = sc.nextLine();

        System.out.print("Платформа (наприклад Zoom/Meet): ");
        String platform = sc.nextLine();

        System.out.print("Посилання на зустріч: ");
        String link = sc.nextLine();

        LiveOnlineCourse course = new LiveOnlineCourse(courseTitle, courseDesc, platform, link);

        AppStorage.addCourse(course);

        CourseManager manager = new CourseManager(course);

        System.out.print("\nВведіть ім'я викладача (Ім'я Прізвище): ");
        String teacherFull = sc.nextLine();
        String[] tParts = splitName(teacherFull);

        System.out.print("Коротка біографія викладача: ");
        String teacherBio = sc.nextLine();

        Teacher teacher = new Teacher(tParts[0], tParts[1], teacherBio);
        manager.assignTeacher(teacher);
        AppStorage.addTeacher(teacher);

        System.out.print("\nСкільки студентів додати? ");
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ім'я студента №" + (i + 1) + " (Ім'я Прізвище): ");
            String sFull = sc.nextLine();
            String[] sParts = splitName(sFull);

            System.out.print("Коротка біографія студента: ");
            String sBio = sc.nextLine();

            students[i] = new Student(sParts[0], sParts[1], sBio);

            manager.enrollStudent(students[i]);
            AppStorage.addStudent(students[i]);
        }

        System.out.print("\nСкільки записів додати у розклад? ");
        int k = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < k; i++) {
            System.out.print("Дата і час (наприклад 2025-12-20 10:00): ");
            String dateTime = sc.nextLine();

            System.out.print("Тема заняття: ");
            String topic = sc.nextLine();

            course.addScheduleEntry(dateTime, topic);
        }

        System.out.print("\nСкільки матеріалів додати? ");
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            System.out.println("\nТип матеріалу: 1-Лекція, 2-Завдання");
            int type = Integer.parseInt(sc.nextLine());

            System.out.print("Назва: ");
            String title = sc.nextLine();

            System.out.print("Короткий зміст/опис: ");
            String content = sc.nextLine();

            LearningMaterial material;
            if (type == 1) {
                material = new LectureMaterial(title, LocalDate.now(), content);
            } else {
                material = new AssignmentMaterial(title, LocalDate.now().plusDays(3), content);
            }

            manager.publishMaterial(material);
            AppStorage.addMaterial(material);
        }

        System.out.println("\n--- Виставлення оцінок ---");
        for (Student s : students) {
            System.out.print("Оцінка для " + s.getName() + ": ");
            int grade = Integer.parseInt(sc.nextLine());
            manager.recordGrade(s, grade);
        }

        System.out.println("\n=== Person.describe/contact/getRole ===");
        Admin admin = new Admin("Адмін", "Системний", "Підтримка платформи");
        Person[] people = new Person[] { students[0], teacher, admin };
        for (Person p : people) {
            p.describe();
            System.out.println("Роль: " + p.getRole());
            p.contact();
            System.out.println();
        }

        System.out.println("\n=== LearningMaterial.info/publish ===");
        LearningMaterial[] demoMaterials = new LearningMaterial[] {
                new LectureMaterial("Демо-лекція", LocalDate.now(), "Тест"),
                new AssignmentMaterial("Демо-завдання", LocalDate.now().plusDays(1), "Тест")
        };
        for (LearningMaterial lm : demoMaterials) {
            lm.info();
            lm.publish();
            System.out.println();
        }

        System.out.println("\n=== ПІДСУМОК КУРСУ ===");
        course.start();
        course.printSummary();
        course.showSchedule();

        manager.showGrades();

        AppStorage.printAll();

        System.out.println("\nРоботу програми завершено.");
        sc.close();
    }

    private static String[] splitName(String fullName) {
        String trimmed = fullName == null ? "" : fullName.trim();
        if (trimmed.isEmpty()) {
            return new String[] { "Невідомо", "Невідомо" };
        }
        String[] parts = trimmed.split("\\s+");
        if (parts.length == 1) {
            return new String[] { parts[0], "БезПрізвища" };
        }
        return new String[] { parts[0], parts[1] };
    }
}
