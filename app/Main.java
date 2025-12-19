package app;

import app.core.*;
import app.materials.*;
import app.people.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Система онлайн-курсів (Практична №4) ===");

        System.out.print("Введіть назву курсу: ");
        String courseTitle = sc.nextLine();

        System.out.print("Введіть опис курсу: ");
        String courseDesc = sc.nextLine();

        System.out.print("Платформа (наприклад Zoom/Meet): ");
        String platform = sc.nextLine();

        System.out.print("Посилання на зустріч: ");
        String link = sc.nextLine();

        LiveOnlineCourse course = new LiveOnlineCourse(1, courseTitle, courseDesc, platform, link);
        CourseManager manager = new CourseManager(course);

        System.out.print("\nВведіть ім'я викладача: ");
        String teacherName = sc.nextLine();
        Teacher teacher = new Teacher(1, teacherName, "Викладач курсу");
        manager.assignTeacher(teacher);

        System.out.print("\nСкільки студентів додати? ");
        int n = Integer.parseInt(sc.nextLine());
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ім'я студента №" + (i + 1) + ": ");
            String sName = sc.nextLine();
            students[i] = new Student(i + 1, sName, "Студент курсу");
            manager.enrollStudent(students[i]);
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
        }

        System.out.println("\n--- Виставлення оцінок ---");
        for (Student s : students) {
            System.out.print("Оцінка для " + s.getName() + ": ");
            int grade = Integer.parseInt(sc.nextLine());
            manager.recordGrade(s, grade);
        }

        System.out.println("\n=== Person.describe/contact/getRole ===");
        Person[] people = new Person[] { students[0], teacher, new Admin(99, "Адмін", "Підтримка") };
        for (Person p : people) {
            p.describe();
            System.out.println("Роль: " + p.getRole());
            p.contact();
            System.out.println();
        }

        System.out.println("\n===LearningMaterial.info/publish ===");
        LearningMaterial[] materialsDemo = new LearningMaterial[] {
                new LectureMaterial("Демо-лекція", LocalDate.now(), "Тест"),
                new AssignmentMaterial("Демо-завдання", LocalDate.now().plusDays(1), "Тест")
        };
        for (LearningMaterial lm : materialsDemo) {
            lm.info();
            lm.publish();
            System.out.println();
        }
                System.out.println("\n=== ПІДСУМОК КУРСУ ===");
        course.start();
        course.printSummary();
        course.showSchedule();

        manager.showAllGrades();

        System.out.println("\nРоботу програми завершено.");
        sc.close();
    }
}
