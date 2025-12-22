package app;

import app.core.CourseBase;
import app.core.CourseManager;
import app.core.LiveOnlineCourse;
import app.materials.AssignmentMaterial;
import app.materials.LectureMaterial;
import app.materials.LearningMaterial;
import app.people.Admin;
import app.people.Person;
import app.people.Student;
import app.people.Teacher;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Практична робота №6 ===\n");

        System.out.print("Введіть назву курсу: ");
        String courseTitle = sc.nextLine();

        System.out.print("Введіть опис курсу: ");
        String courseDesc = sc.nextLine();

        System.out.print("Платформа (Zoom/Meet/Teams): ");
        String platform = sc.nextLine();

        System.out.print("Посилання на зустріч: ");
        String link = sc.nextLine();

        LiveOnlineCourse liveCourse = new LiveOnlineCourse(courseTitle, courseDesc, platform, link);

        CourseBase course = liveCourse;

        CourseManager manager = new CourseManager(course);

        AppStorage.addCourse(course);

        System.out.print("\nВведіть викладача (Ім'я Прізвище): ");
        String teacherFull = sc.nextLine();
        String[] tName = splitName(teacherFull);

        System.out.print("Біографія викладача: ");
        String teacherBio = sc.nextLine();

        Teacher concreteTeacher = new Teacher(tName[0], tName[1], teacherBio);
        Person teacher = concreteTeacher;

        manager.assignTeacher(concreteTeacher);
        AppStorage.addTeacher(concreteTeacher);

        System.out.print("\nСкільки студентів додати? ");
        int n = Integer.parseInt(sc.nextLine());

        Student[] studentObjects = new Student[n];
        Person[] personsForDemo = new Person[n + 2];

        for (int i = 0; i < n; i++) {
            System.out.print("Студент №" + (i + 1) + " (Ім'я Прізвище): ");
            String full = sc.nextLine();
            String[] sName = splitName(full);

            System.out.print("Біографія студента: ");
            String sBio = sc.nextLine();

            Student concreteStudent = new Student(sName[0], sName[1], sBio);
            studentObjects[i] = concreteStudent;

            manager.enrollStudent(concreteStudent);

            AppStorage.addStudent(concreteStudent);

            personsForDemo[i] = concreteStudent;
        }

        Admin concreteAdmin = new Admin("Адмін", "Системи", "Підтримка платформи");
        Person admin = concreteAdmin;

        personsForDemo[n] = (Person) teacher;
        personsForDemo[n + 1] = admin;

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

        LearningMaterial[] materialsForDemo = new LearningMaterial[m];

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

            materialsForDemo[i] = material;
        }

        System.out.println("\n--- Виставлення оцінок ---");
        for (Student s : studentObjects) {
            System.out.print("Оцінка для " + s.getName() + ": ");
            int grade = Integer.parseInt(sc.nextLine());
            manager.recordGrade(s, grade);
        }

        System.out.println("\n============================");
        System.out.println("ДЕМО 1: Робота Person");
        System.out.println("============================");
        for (Person p : personsForDemo) {
            processPerson(p);
            System.out.println();
        }

        System.out.println("\n============================");
        System.out.println("ДЕМО 2: Робота LearningMaterial");
        System.out.println("============================");
        for (LearningMaterial mat : materialsForDemo) {
            processMaterial(mat);
            System.out.println();
        }

        System.out.println("\n============================");
        System.out.println("ДЕМО 3: Робота CourseBase");
        System.out.println("============================");
        processCourse(course);

        System.out.println("\n============================");
        System.out.println("ДЕМО 4: Прямий тип vs abstract посилання");
        System.out.println("============================");

        System.out.println("1) Виклик через прямий тип LiveOnlineCourse:");
        liveCourse.start();

        System.out.println("2) Виклик через абстрактний тип CourseBase:");
        CourseBase abstractRef = liveCourse;
        abstractRef.start();

        System.out.println("\n=== ПІДСУМОК (для скрінів) ===");
        course.printSummary();
        course.showSchedule();
        manager.showGrades();

        System.out.println("\n=== AppStorage.printAll (static сховище) ===");
        AppStorage.printAll();

        System.out.println("\nРоботу програми завершено.");
        sc.close();
    }

    private static void processPerson(Person p) {
        p.describe();
        System.out.println("Роль: " + p.getRole());
        p.contact();
    }

    private static void processMaterial(LearningMaterial m) {
        m.info();
        System.out.println("Тип: " + m.getType());
        m.publish();
    }

    private static void processCourse(CourseBase c) {
        c.start();
        c.printSummary();
        System.out.println("Платформа: " + c.getPlatform());
        c.showSchedule();
    }

    private static String[] splitName(String fullName) {
        String trimmed = (fullName == null) ? "" : fullName.trim();
        if (trimmed.isEmpty()) return new String[]{"Невідомо", "Невідомо"};

        String[] parts = trimmed.split("\\s+");
        if (parts.length == 1) return new String[]{parts[0], "БезПрізвища"};

        return new String[]{parts[0], parts[1]};
    }
}
