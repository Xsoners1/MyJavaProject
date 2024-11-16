package Java1;

import java.util.Scanner;
import java.util.Random;

class ReplaceValueInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        if (size <= 0) {
            System.out.println("Розмір масиву повинен бути більше нуля.");
            return;
        }

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Початковий масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Введіть значення, яке потрібно замінити: ");
        int oldValue = scanner.nextInt();

        System.out.print("Введіть нове значення: ");
        int newValue = scanner.nextInt();

        boolean isReplaced = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldValue) {
                array[i] = newValue;
                isReplaced = true;
            }
        }

        if (isReplaced) {
            System.out.println("Масив після заміни:");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            System.out.println("Значення " + oldValue + " не знайдено в масиві.");
        }
    }
}
