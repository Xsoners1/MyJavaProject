package java3;

import java.util.Scanner;
import java.util.Random;

class ArrayReplaceValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Згенерований масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Введіть значення, яке потрібно знайти: ");
        int valueToFind = scanner.nextInt();

        System.out.print("Введіть нове значення для заміни: ");
        int newValue = scanner.nextInt();

        boolean isFound = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToFind) {
                array[i] = newValue;
                isFound = true;
            }
        }

        if (isFound) {
            System.out.println("Значення замінено. Оновлений масив:");
            for (int num : array) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Значення " + valueToFind + " не знайдено в масиві.");
        }
    }
}
