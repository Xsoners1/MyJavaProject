package Javaproject;

import java.util.Scanner;

class RangeAndPrimeFilter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть початкове значення діапазону: ");
        int start = scanner.nextInt();

        System.out.print("Введіть кінцеве значення діапазону: ");
        int end = scanner.nextInt();

        int prime;
        do {
            System.out.print("Введіть просте число (2, 3, 5 або 7): ");
            prime = scanner.nextInt();
        } while (prime != 2 && prime != 3 && prime != 5 && prime != 7);

        System.out.println("Числа в діапазоні від " + start + " до " + end + ", що не кратні " + prime + ":");
        for (int i = start; i <= end; i++) {
            if (i % prime == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        scanner.close();
    }
}
