package Java1;

class PolygonCheck {
    public static void main(String[] args) {

        int[] angles = {90, 90, 90, 90};

        int n = angles.length;

        int sum = 0;
        for (int angle : angles) {
            sum += angle;
        }

        int theoreticalSum = 180 * (n - 2);

        if (sum == theoreticalSum) {
            System.out.println("Багатокутник із заданими кутами може існувати.");
        } else {
            System.out.println("Багатокутник із заданими кутами не може існувати.");
        }

        System.out.println("Задана сума кутів: " + sum);
        System.out.println("Очікувана сума кутів: " + theoreticalSum);
    }
}
