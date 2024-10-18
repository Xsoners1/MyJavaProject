package Java;

import java.util.Scanner;

class MathFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите значение b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите значение x: ");
        double x = scanner.nextDouble();

        double result = 0;

        if (x > -3 && x < 3) {
            // sqrt(x^2 - a)
            if (x * x - a >= 0) {
                result = Math.sqrt(x * x - a);
            } else {
                System.out.println("Ошибка: подкоренное выражение отрицательно.");
                return;
            }
        } else if (x == 3) {
            result = 5 * Math.pow(x, 3) - b * x + 3;
        } else if (x > 3 && x < 8) {
            if (Math.cos(x) != 0) {
                result = 1 / Math.cos(x);
            } else {
                System.out.println("Ошибка: значение cos(x) равно нулю.");
                return;
            }
        } else {
            System.out.println("Ошибка: значение x вне допустимого диапазона.");
            return;
        }

        System.out.printf("Результат f(%.2f) = %.4f%n", x, result);
    }
}
