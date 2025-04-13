package Java5;

import java.io.*;
import java.util.Scanner;

public class TextEditor {
    private static final String FILE_NAME = "text.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    writeMultipleLines();
                    break;
                case "2":
                    readFromFile();
                    break;
                case "3":
                    readLineRange();
                    break;
                case "4":
                    insertLineAtPosition();
                    break;
                case "5":
                    System.out.println("Вихід з редактора.");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Текстовий редактор ===");
        System.out.println("1. Записати декілька рядків до файлу");
        System.out.println("2. Прочитати увесь вміст файлу");
        System.out.println("3. Вивести рядки у вказаному діапазоні");
        System.out.println("4. Вставити рядок у вказану позицію");
        System.out.println("5. Вийти");
        System.out.print("Оберіть дію: ");
    }

    private static void writeMultipleLines() {
        System.out.println("Введіть рядки (введіть 'кінець' для завершення):");
        String[] newLines = new String[100];
        int count = 0;

        while (true) {
            System.out.print((count + 1) + ": ");
            String line = scanner.nextLine();
            if (line.equals("кінець")) break;
            if (count < newLines.length) {
                newLines[count] = line;
                count++;
            } else {
                System.out.println("Досягнуто максимум рядків.");
                break;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            for (int i = 0; i < count; i++) {
                writer.write(newLines[i]);
                writer.newLine();
            }
            System.out.println("Рядки записані у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
    }

    private static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int lineNumber = 1;
            System.out.println("\n--- Вміст файлу ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            System.out.println("--- Кінець файлу ---");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено.");
        } catch (IOException e) {
            System.out.println("Помилка зчитування: " + e.getMessage());
        }
    }

    private static void readLineRange() {
        System.out.print("Введіть початковий номер рядка: ");
        int start = Integer.parseInt(scanner.nextLine());
        System.out.print("Введіть кінцевий номер рядка: ");
        int end = Integer.parseInt(scanner.nextLine());

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String[] lines = new String[1000];
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null && index < lines.length) {
                lines[index] = line;
                index++;
            }

            System.out.println("\n--- Рядки з " + start + " по " + end + " ---");
            for (int i = start - 1; i < end && i < index; i++) {
                System.out.println((i + 1) + ": " + lines[i]);
            }
            System.out.println("--- Кінець діапазону ---");

        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }

    private static void insertLineAtPosition() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String[] lines = new String[1000];
            int total = 0;
            String line;
            while ((line = reader.readLine()) != null && total < lines.length) {
                lines[total] = line;
                total++;
            }

            System.out.print("Введіть номер рядка, куди вставити: ");
            int position = Integer.parseInt(scanner.nextLine());

            if (position < 1 || position > total + 1) {
                System.out.println("Некоректна позиція.");
                return;
            }

            System.out.print("Введіть текст для вставки: ");
            String newLine = scanner.nextLine();

            String temp = lines[position - 1];
            lines[position - 1] = newLine;
            lines[total] = temp;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (int i = 0; i <= total; i++) {
                    if (lines[i] != null) {
                        writer.write(lines[i]);
                        writer.newLine();
                    }
                }
                System.out.println("Рядок вставлено.");
            }

        } catch (IOException e) {
            System.out.println("Помилка обробки файлу: " + e.getMessage());
        }
    }
}
