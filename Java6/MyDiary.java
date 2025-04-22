package Java6;

import java.util.Scanner;

public class MyDiary {
    static final int MAX_RECORDS = 50;
    static String[] dates = new String[MAX_RECORDS];
    static String[] records = new String[MAX_RECORDS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nМІЙ ЩОДЕННИК:");
            System.out.println("1. Додати запис");
            System.out.println("2. Видалити запис");
            System.out.println("3. Переглянути усі записи");
            System.out.println("4. Вихід");
            System.out.print("Виберіть опцію: ");
            String choice = scanner.nextLine();

            switch (choice) {
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
                    break;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }

        scanner.close();
    }

    static void addRecord(Scanner scanner) {
        System.out.print("Введіть дату запису (у форматі РРРР-ММ-ДД): ");
        String date = scanner.nextLine().trim();

        if (!isValidDate(date)) {
            System.out.println("Неправильний формат дати.");
            return;
        }

        System.out.println("Введіть текст запису. Для завершення введення натисніть порожній рядок:");
        String text = "";
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("")) break;
            text += line + "\n";
        }

        // Зберегти запис
        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] == null) {
                dates[i] = date;
                records[i] = text;
                System.out.println("Запис додано.");
                return;
            }
        }

        System.out.println("Щоденник заповнений. Неможливо додати новий запис.");
    }

    static void deleteRecord(Scanner scanner) {
        System.out.print("Введіть дату запису, який хочете видалити (у форматі РРРР-ММ-ДД): ");
        String date = scanner.nextLine().trim();

        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] != null && dates[i].equals(date)) {
                dates[i] = null;
                records[i] = null;
                System.out.println("Запис видалено.");
                return;
            }
        }

        System.out.println("Запис з такою датою не знайдено.");
    }

    static void viewRecords() {
        boolean found = false;
        for (int i = 0; i < MAX_RECORDS; i++) {
            if (dates[i] != null) {
                found = true;
                System.out.println("Дата: " + dates[i]);
                System.out.println("Запис:\n" + records[i]);
                System.out.println("-------------------------");
            }
        }

        if (!found) {
            System.out.println("Записів не знайдено.");
        }
    }

    static boolean isValidDate(String date) {
        if (date.length() != 10) return false;
        if (date.charAt(4) != '-' || date.charAt(7) != '-') return false;

        String yearStr = date.substring(0, 4);
        String monthStr = date.substring(5, 7);
        String dayStr = date.substring(8, 10);

        for (int i = 0; i < yearStr.length(); i++) {
            if (!Character.isDigit(yearStr.charAt(i))) return false;
        }
        for (int i = 0; i < monthStr.length(); i++) {
            if (!Character.isDigit(monthStr.charAt(i))) return false;
        }
        for (int i = 0; i < dayStr.length(); i++) {
            if (!Character.isDigit(dayStr.charAt(i))) return false;
        }

        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dayStr);

        return month >= 1 && month <= 12 && day >= 1 && day <= 31;
    }
}
