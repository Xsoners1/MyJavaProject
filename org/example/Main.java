package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення даних від користувача
        System.out.print("Введіть ціле число: ");
        int integerValue = scanner.nextInt();

        System.out.print("Введіть число з плаваючою точкою: ");
        double floatValue = scanner.nextDouble();

        scanner.nextLine(); // Поглинання нової лінії після введення числа
        System.out.print("Введіть рядок: ");
        String stringValue = scanner.nextLine();

        System.out.print("Введіть 1 для True або 0 для False: ");
        boolean boolValue = scanner.nextInt() == 1;

        // 1. Використання String.format()
        System.out.println("\nФорматування за допомогою String.format():");
        System.out.printf("%d як ціле число%n", integerValue);
        System.out.printf("%x як шістнадцяткове число%n", integerValue);
        System.out.printf("%.2f як число з плаваючою точкою%n", floatValue);
        System.out.printf("%10s як рядок із шириною поля 10%n", stringValue);
        System.out.printf("%b як логічне значення%n", boolValue);

        // 2. Використання printf()
        System.out.println("\nФорматування за допомогою printf():");
        System.out.printf("%d як ціле число%n", integerValue);
        System.out.printf("%x як шістнадцяткове число%n", integerValue);
        System.out.printf("%.2f як число з плаваючою точкою%n", floatValue);
        System.out.printf("%10s як рядок із шириною поля 10%n", stringValue);
        System.out.printf("%b як логічне значення%n", boolValue);

        // 3. Ручне форматування
        System.out.println("\nРучне форматування:");
        System.out.println(integerValue + " як ціле число");
        System.out.println(Integer.toHexString(integerValue) + " як шістнадцяткове число");
        System.out.println(String.format("%.2f", floatValue) + " як число з плаваючою точкою");
        System.out.println(String.format("%10s", stringValue) + " як рядок із шириною поля 10");
        System.out.println(boolValue + " як логічне значення");
    }
}

