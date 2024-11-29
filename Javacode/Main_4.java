package Javacode;

import java.util.Random;
import java.util.Scanner;

class MatrixMinor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть кількість рядків матриці: ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("\nСформована матриця:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10) + 1;
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("\nВведіть номер рядка для виключення (від 0 до " + (rows - 1) + "): ");
        int excludeRow = scanner.nextInt();
        System.out.print("Введіть номер стовпця для виключення (від 0 до " + (cols - 1) + "): ");
        int excludeCol = scanner.nextInt();

        if (excludeRow < 0 || excludeRow >= rows || excludeCol < 0 || excludeCol >= cols) {
            System.out.println("Помилка: введені показники поза межами матриці.");
            return;
        }

        int[][] minor = createMinor(matrix, excludeRow, excludeCol);

        System.out.println("\nМінор матриці:");
        for (int i = 0; i < minor.length; i++) {
            for (int j = 0; j < minor[i].length; j++) {
                System.out.print(minor[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] createMinor(int[][] matrix, int excludeRow, int excludeCol) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] minor = new int[rows - 1][cols - 1];

        int minorRow = 0, minorCol;
        for (int i = 0; i < rows; i++) {
            if (i == excludeRow) continue;
            minorCol = 0;
            for (int j = 0; j < cols; j++) {
                if (j == excludeCol) continue;
                minor[minorRow][minorCol] = matrix[i][j];
                minorCol++;
            }
            minorRow++;
        }

        return minor;
    }
}
