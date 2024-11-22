package Javacode;

class JaggedPyramidArray {
    public static void main(String[] args) {
        int[][] pyramid = new int[5][];
        for (int i = 0; i < pyramid.length; i++) {
            pyramid[i] = new int[i + 1];
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = j + 1;
            }
        }

        System.out.println("Піраміда у звичайному порядку:");
        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nПіраміда у зворотньому порядку:");
        for (int i = pyramid.length - 1; i >= 0; i--) {
            for (int j = 0; j < pyramid[i].length; j++) {
                System.out.print(pyramid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
