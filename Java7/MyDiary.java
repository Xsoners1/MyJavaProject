package Java7;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.Scanner;

public class MyDiary {
    static final int MAX_RECORDS = 50;
    static LocalDateTime[] dates = new LocalDateTime[MAX_RECORDS];
    static String[] records = new String[MAX_RECORDS];
    static DateTimeFormatter storageFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    static DateTimeFormatter displayFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вітаю! Виберіть:");
        System.out.println("1. Створити новий щоденник");
        System.out.println("2. Завантажити існуючий щоденник");
        String choice = scanner.nextLine();

        if (choice.equals("2")) {
            System.out.print("Введіть шлях до файлу щоденника: ");
            String filePath = scanner.nextLine();
            loadFromFile(filePath);
        }

        System.out.println("Виберіть формат дати для відображення (приклад: yyyy-MM-dd HH:mm): ");
        String userFormat = scanner.nextLine();
        try {
            displayFormat = DateTimeFormatter.ofPattern(userFormat);
        } catch (Exception e) {
            System.out.println("Невірний формат, використовується стандартний.");
        }

        boolean running = true;
        while (running) {
            System.out.println("\nМІЙ ЩОДЕННИК:");
            System.out.println("1. Додати запис");
            System.out.println("2. Видалити запис за датою");
            System.out.println("3. Переглянути всі записи");
            System.out.println("4. Вихід");
            System.out.print("Виберіть опцію: ");
            String opt = scanner.nextLine();

            switch (opt) {
                case "1":
                    addRecord(scanner);
                    break;
                case "2":
                    deleteRecord(scanner);
                    break;
                case "3":
                    viewRecords();
                    break;
                case "4":
                    running = false;
                    savePrompt(scanner);
                    break;
                default:
                    System.out.println("Невірна опція.");
            }
        }

        scanner.close();
    }

    static void addRecord(Scanner scanner) {
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
        String text = "";
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("")) break;
            text += line + "\n";
        }

        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] == null) {
                dates[i] = date;
                records[i] = text;
                System.out.println("Запис додано.");
                return;
            }
        }

        System.out.println("Щоденник заповнений.");
    }

    static void deleteRecord(Scanner scanner) {
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

    static void viewRecords() {
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

    static void savePrompt(Scanner scanner) {
        System.out.print("Бажаєте зберегти щоденник? (так/ні): ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("так")) {
            System.out.print("Введіть шлях до файлу: ");
            String filePath = scanner.nextLine();
            saveToFile(filePath);
        } else {
            System.out.println("Дані не збережено.");
        }
    }

    static void saveToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int i = 0; i < MAX_RECORDS; i++) {
                if (dates[i] != null) {
                    writer.println(dates[i].format(storageFormat));
                    writer.print(records[i]);
                    writer.println();
                }
            }
            System.out.println("Щоденник збережено.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні файлу.");
        }
    }

    static void loadFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;
            while ((line = reader.readLine()) != null && index < MAX_RECORDS) {
                if (line.trim().isEmpty()) continue;
                LocalDateTime date = LocalDateTime.parse(line, storageFormat);
                String text = "";
                while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                    text += line + "\n";
                }
                dates[index] = date;
                records[index] = text;
                index++;
            }
            System.out.println("Щоденник успішно завантажено.");
        } catch (IOException e) {
            System.out.println("Не вдалося прочитати файл.");
        } catch (Exception e) {
            System.out.println("Файл пошкоджений або має невірний формат.");
        }
    }
}
