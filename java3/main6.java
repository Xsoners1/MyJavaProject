package java3;

class SineTable {
    public static void main(String[] args) {
        System.out.println("Таблиця значень синусів для кутів від 0 до 90 градусів:");

        for (int degree = 0; degree <= 90; degree++) {
            double radians = Math.toRadians(degree);
            double sineValue = Math.sin(radians);

            System.out.printf("%7.4f", sineValue);

            if (degree % 10 == 9 || degree == 90) {
                System.out.println();
            }
        }
    }
}
