package java3;

class PolygonAngleValidation {
    public static void main(String[] args) {

        int[] angles = {90, 90, 90, 90};

        int n = angles.length;

        int requiredSum = 180 * (n - 2);

        int actualSum = 0;
        for (int angle : angles) {
            actualSum += angle;
        }

        if (actualSum == requiredSum) {
            System.out.println("Багатокутник з такими кутами може існувати.");
        } else {
            System.out.println("Багатокутник з такими кутами не може існувати.");
        }

        System.out.println("Кути багатокутника:");
        for (int angle : angles) {
            System.out.print(angle + " ");
        }
        System.out.println();
        System.out.println("Фактична сума кутів: " + actualSum);
        System.out.println("Необхідна сума кутів: " + requiredSum);
    }
}
