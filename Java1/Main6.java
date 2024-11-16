package Java1;

class SineTable {
    public static void main(String[] args) {

        int step = 1;
        int valuesPerRow = 10;

        System.out.println("Таблиця синусів (від 0° до 90°):");

        for (int angle = 0; angle <= 90; angle += step) {
            // Обчислення синуса
            double sineValue = Math.sin(Math.toRadians(angle));

            System.out.printf("%6.3f ", sineValue);

            if ((angle + 1) % valuesPerRow == 0 || angle == 90) {
                System.out.println();
            }
        }
    }
}
