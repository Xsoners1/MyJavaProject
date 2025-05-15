package Prakticym2;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;

import Prakticym2.utils.FilesystemUtilities;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Вітаю! Виберіть:");
        System.out.println("1. Створити новий щоденник");
        System.out.println("2. Завантажити існуючий щоденник");
        String choice = scanner.nextLine();

        if (choice.equals("2")) {
            System.out.print("Введіть шлях до файлу щоденника: ");
            String filePath = scanner.nextLine();
            FilesystemUtilities.loadFromFile(filePath, DiaryApplication.dates, DiaryApplication.records, DiaryApplication.storageFormat);
        }

        System.out.println("Виберіть формат дати для відображення (приклад: yyyy-MM-dd HH:mm): ");
        String userFormat = scanner.nextLine();
        try {
            DiaryApplication.storageFormat = DateTimeFormatter.ofPattern(userFormat);
        } catch (Exception e) {
            System.out.println("Невірний формат, використовується стандартний.");
        }

        boolean running = true;
        while (running) {
            System.out.println("\nМІЙ ЩОДЕННИК:");
            System.out.println("1. Додати запис");
            System.out.println("2. Видалити запис за датою");
            System.out.println("3. Переглянути всі записи");
            System.out.println("4. Зберегти щоденник");
            System.out.println("5. Вийти");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    DiaryApplication.addRecord(scanner);
                    break;
                case "2":
                    DiaryApplication.deleteRecord(scanner);
                    break;
                case "3":
                    DiaryApplication.viewRecords();
                    break;
                case "4":
                    System.out.print("Введіть шлях для збереження: ");
                    String filePath = scanner.nextLine();
                    FilesystemUtilities.saveToFile(filePath, DiaryApplication.dates, DiaryApplication.records, DiaryApplication.storageFormat);
                    break;
                case "5":
                    running = false;
                    System.out.println("До побачення!");
                    break;
                default:
                    System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }
}
