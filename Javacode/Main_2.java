package Javacode;

import java.util.Random;

class ReplaceWithSquareRoot {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;

        double[][] array = new double[rows][cols];
        Random random = new Random();

        System.out.println("Початковий масив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = 1 + random.nextDouble() * 99;
                System.out.printf("%.2f\t", array[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i % 2 != 0 || j % 2 != 0) {
                    array[i][j] = Math.sqrt(array[i][j]);
                }
            }
        }

        System.out.println("\nОновлений масив:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.2f\t", array[i][j]);
            }
            System.out.println();
        }
    }
}
