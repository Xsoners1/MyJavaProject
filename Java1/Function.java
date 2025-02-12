package Java1;

import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userInput = getValidInput(scanner);

        System.out.println("Оберіть функцію:");
        System.out.println("1 - Перевернути всю строку");
        System.out.println("2 - Перевернути кожне слово окремо");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Результат: " + reverseString(userInput));
        } else if (choice == 2) {
            System.out.println("Результат: " + reverseEachWord(userInput));
        } else {
            System.out.println("Неправильний вибір");
        }
    }

    public static String getValidInput(Scanner scanner) {
        String input;
        while (true) {
            System.out.println("Введіть строку (мінімум 2 слова):");
            input = scanner.nextLine().trim();
            if (input.split("\\s+").length >= 2) {
                return input;
            }
            System.out.println("Помилка! Введіть мінімум два слова.");
        }
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String reverseEachWord(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }

        return result.toString().trim();
    }
}
