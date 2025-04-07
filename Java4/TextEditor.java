package Java4;

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
                    writeToFile();
                    break;
                case "2":
                    readFromFile();
                    break;
                case "3":
                    System.out.println("Вихід з редактора.");
                    return;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Текстовий редактор ===");
        System.out.println("1. Записати до файлу");
        System.out.println("2. Прочитати вміст файлу");
        System.out.println("3. Вийти");
        System.out.print("Оберіть дію: ");
    }

    private static void writeToFile() {
        System.out.print("Введіть рядок для запису: ");
        String inputLine = scanner.nextLine();

        char[] chars = inputLine.toCharArray();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            for (char c : chars) {
                writer.write(c);
            }
            writer.write('\n');
            System.out.println("Рядок записано у файл.");
        } catch (IOException e) {
            System.out.println("Помилка запису до файлу: " + e.getMessage());
        }
    }

    private static void readFromFile() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            char[] buffer = new char[1024];
            int numRead;
            System.out.println("\n--- Вміст файлу ---");
            while ((numRead = reader.read(buffer)) != -1) {
                for (int i = 0; i < numRead; i++) {
                    System.out.print(buffer[i]);
                }
            }
            System.out.println("\n--- Кінець файлу ---");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не знайдено. Запишіть щось у файл спочатку.");
        } catch (IOException e) {
            System.out.println("Помилка зчитування файлу: " + e.getMessage());
        }
    }
}
