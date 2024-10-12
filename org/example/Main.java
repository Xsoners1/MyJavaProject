package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть ціле число (int): ");
        int intValue = scanner.nextInt();

        System.out.print("Введіть число з плаваючою точкою (double): ");
        double doubleValue = scanner.nextDouble();

        System.out.print("Введіть строку (string): ");

        scanner.nextLine();
        String stringValue = scanner.nextLine();


        boolean boolValue;
        while (true) {
            System.out.print("Введіть логічне значення (boolean - true або false): ");
            try {
                boolValue = scanner.nextBoolean();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: Введіть 'true' або 'false'!");
                scanner.next();
            }
        }

        System.out.println("\nВиведення даних у різних форматах:");


        System.out.println("\n1 підхід: Конкатенація рядків");
        System.out.println("Ціле число (десяткова система): " + intValue);
        System.out.println("Число з плаваючою точкою: " + doubleValue);
        System.out.println("Строка: " + stringValue);
        System.out.println("Логічне значення: " + boolValue);


        System.out.println("\n2 підхід: Використання printf");
        System.out.printf("Ціле число (десяткова система): %d%n", intValue);
        System.out.printf("Ціле число (шістнадцяткова система): %x%n", intValue);
        System.out.printf("Ціле число (вісімкова система): %o%n", intValue);
        System.out.printf("Число з плаваючою точкою (3 символи після коми): %.3f%n", doubleValue);
        System.out.printf("Строка (до 6 символів): %.6s%n", stringValue);
        System.out.printf("Логічне значення: %b%n", boolValue);


        System.out.println("\n3 підхід: Використання формату з шириною поля");
        System.out.printf("Ціле число (десяткова система): %10d%n", intValue);
        System.out.printf("Ціле число (шістнадцяткова система): %10x%n", intValue);
        System.out.printf("Ціле число (вісімкова система): %10o%n", intValue);
        System.out.printf("Число з плаваючою точкою (2 символи після коми): %10.2f%n", doubleValue);
        System.out.printf("Строка (до 4 символів): %.4s%n", stringValue);
        System.out.printf("Логічне значення: %10b%n", boolValue);

        scanner.close();
    }
}
