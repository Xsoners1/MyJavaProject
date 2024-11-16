package Java1;

import java.util.Scanner;
import java.util.Random;

class ArrayOrderCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int size = scanner.nextInt();

        if (size <= 1) {
            System.out.println("Розмір масиву має бути більше 1 для перевірки.");
            return;
        }

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Згенерований масив:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Введіть тип перевірки (1 - зростання, 2 - спадання): ");
        int checkType = scanner.nextInt();

        boolean isOrdered = true;

        if (checkType == 1) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isOrdered = false;
                    break;
                }
            }
            System.out.println(isOrdered ? "Масив є зростаючим." : "Масив не є зростаючим.");
        }

        else if (checkType == 2) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    isOrdered = false;
                    break;
                }
            }
            System.out.println(isOrdered ? "Масив є спадним." : "Масив не є спадним.");
        } else {
            System.out.println("Некоректний вибір типу перевірки.");
        }
    }
}
