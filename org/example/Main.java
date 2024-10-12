package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        int integerValue = scanner.nextInt();

        System.out.print("Введіть число з плаваючою точкою: ");
        double floatValue = scanner.nextDouble();

        scanner.nextLine();

        System.out.print("Введіть рядок: ");
        String stringValue = scanner.nextLine();

        System.out.print("Введіть 1 для True або 0 для False: ");
        boolean boolValue = scanner.nextInt() == 1;

        System.out.println("\nВиведення даних у різних форматах:");

        System.out.println("\n1 підхід");
        System.out.printf("Ціле число (десяткова система): %d%n", integerValue);
        System.out.printf("Число з плаваючою точкою: %.2f%n", floatValue);
        System.out.printf("Рядок: %s%n", stringValue);
        System.out.printf("Логічне значення: %b%n", boolValue);

        System.out.println("\n2 підхід");
        System.out.printf("Ціле число (десяткова система): %d%n", integerValue);
        System.out.printf("Ціле число (шістнадцяткова система): %x%n", integerValue);
        System.out.printf("Число з плаваючою точкою (з 2 знаками після коми): %.2f%n", floatValue);
        System.out.printf("Рядок (до 10 символів): %.10s%n", stringValue);
        System.out.printf("Логічне значення: %b%n", boolValue);

        System.out.println("\n3 підхід");
        System.out.println(integerValue + " як ціле число");
        System.out.println(Integer.toHexString(integerValue) + " як шістнадцяткове число");
        System.out.println(String.format("%.2f", floatValue) + " як число з плаваючою точкою");
        System.out.println(String.format("%10s", stringValue) + " як рядок із шириною поля 10");
        System.out.println(boolValue + " як логічне значення");
    }
}
