package app.restricted;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    static void addTeacher(String name) {
        teachers.add(new Teacher(name));
    }

    static void addStudent(String name) {
        students.add(new Student(name));
    }

    public static void main(String[] args) {
        System.out.println("=== App ===");

        boolean running = true;
        while (running) {
            System.out.println("\n1. Додати вчителя");
            System.out.println("2. Додати студента");
            System.out.println("3. Поставити оцінку студенту");
            System.out.println("4. Показати всіх студентів");
            System.out.println("5. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Ім'я вчителя: ");
                    addTeacher(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Ім'я студента: ");
                    addStudent(scanner.nextLine());
                }
                case 3 -> {
                    if (teachers.isEmpty() || students.isEmpty()) {
                        System.out.println("Немає вчителів або студентів.");
                        break;
                    }
                    System.out.println("Виберіть вчителя (0-" + (teachers.size() - 1) + "): ");
                    int tIndex = Integer.parseInt(scanner.nextLine());
                    System.out.println("Виберіть студента (0-" + (students.size() - 1) + "): ");
                    int sIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Оцінка: ");
                    int grade = Integer.parseInt(scanner.nextLine());
                    teachers.get(tIndex).setGrade(students.get(sIndex), grade);
                }
                case 4 -> {
                    System.out.println("Список студентів:");
                    for (Student s : students) {
                        System.out.println(s);
                    }
                }
                case 5 -> running = false;
                default -> System.out.println("Невірна опція.");
            }
        }

        System.out.println("Завершення роботи програми.");
    }
}
