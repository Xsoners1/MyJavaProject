package Prakticym2;

import Prakticym2.utils.FilesystemUtilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DiaryApplication {
    private static final int MAX_RECORDS = 50;
    public static LocalDateTime[] dates = new LocalDateTime[MAX_RECORDS];
    public static String[] records = new String[MAX_RECORDS];
    public static DateTimeFormatter storageFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static DateTimeFormatter displayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void addRecord(Scanner scanner) {
        System.out.print("Введіть дату та час запису (yyyy-MM-dd HH:mm): ");
        String input = scanner.nextLine();
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(input, storageFormat);
        } catch (Exception e) {
            System.out.println("Невірний формат дати.");
            return;
        }

        System.out.println("Введіть текст запису. Завершіть порожнім рядком:");
        StringBuilder text = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("")) break;
            text.append(line).append("\n");
        }

        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] == null) {
                dates[i] = date;
                records[i] = text.toString();
                System.out.println("Запис додано.");
                return;
            }
        }

        System.out.println("Щоденник заповнений.");
    }

    public static void deleteRecord(Scanner scanner) {
        System.out.print("Введіть дату запису для видалення (yyyy-MM-dd HH:mm): ");
        String input = scanner.nextLine();
        LocalDateTime target;
        try {
            target = LocalDateTime.parse(input, storageFormat);
        } catch (Exception e) {
            System.out.println("Невірний формат дати.");
            return;
        }

        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] != null && dates[i].equals(target)) {
                dates[i] = null;
                records[i] = null;
                System.out.println("Запис видалено.");
                return;
            }
        }

        System.out.println("Запис не знайдено.");
    }

    public static void viewRecords() {
        boolean hasRecords = false;
        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] != null) {
                hasRecords = true;
                System.out.println("Дата: " + dates[i].format(displayFormat));
                System.out.println(records[i]);
                System.out.println("---------------------------");
            }
        }

        if (!hasRecords) {
            System.out.println("Записів немає.");
        }
    }

    public void savePrompt(Scanner scanner) {
        System.out.print("Бажаєте зберегти щоденник? (так/ні): ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("так")) {
            System.out.print("Введіть шлях до файлу: ");
            String filePath = scanner.nextLine();
            FilesystemUtilities.saveToFile(filePath, dates, records, storageFormat);
        } else {
            System.out.println("Дані не збережено.");
        }
    }

    public void loadDiary(String filePath) {
        FilesystemUtilities.loadFromFile(filePath, dates, records, storageFormat);
    }
}
