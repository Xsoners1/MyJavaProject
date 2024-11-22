package java3;

import java.util.Scanner;

class ArrayOrderCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть розмір масиву: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Масив випадкових значень:");
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * 100);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        System.out.print("Перевіряти на зростання (1) чи спадання (2)? ");
        int choice = scanner.nextInt();

        boolean isOrdered = true;
        if (choice == 1) {
            for (int i = 1; i < n; i++) {
                if (array[i] < array[i - 1]) {
                    isOrdered = false;
                    break;
                }
            }
            if (isOrdered) {
                System.out.println("Масив відсортований за зростанням.");
            } else {
                System.out.println("Масив не відсортований за зростанням.");
            }
        } else if (choice == 2) {
            for (int i = 1; i < n; i++) {
                if (array[i] > array[i - 1]) {
                    isOrdered = false;
                    break;
                }
            }
            if (isOrdered) {
                System.out.println("Масив відсортований за спаданням.");
            } else {
                System.out.println("Масив не відсортований за спаданням.");
            }
        } else {
            System.out.println("Невірний вибір.");
        }

        scanner.close();
    }
}
