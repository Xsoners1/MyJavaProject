package Javaproject;

import java.util.Scanner;

class ReverseNumberWithBothLoops {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле число: ");
        int number = scanner.nextInt();

        int originalNumber = number;

        int reversedWithWhile = 0;
        int tempNumberWhile = originalNumber;
        while (tempNumberWhile != 0) {
            int digit = tempNumberWhile % 10;
            reversedWithWhile = reversedWithWhile * 10 + digit;
            tempNumberWhile /= 10;
        }

        int reversedWithDoWhile = 0;
        int tempNumberDoWhile = originalNumber;
        do {
            int digit = tempNumberDoWhile % 10;
            reversedWithDoWhile = reversedWithDoWhile * 10 + digit;
            tempNumberDoWhile /= 10;
        } while (tempNumberDoWhile != 0);

        System.out.printf("Реверсоване число (while): %010d%n", reversedWithWhile);
        System.out.printf("Реверсоване число (do-while): %010d%n", reversedWithDoWhile);

        scanner.close();
    }
}
