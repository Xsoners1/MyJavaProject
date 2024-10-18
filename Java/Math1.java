public static void main(String[] args) {
    double a = 1.725;
    double b = 19;
    double c = -2.153;

    double x = Math.abs(Math.pow(a, a) - Math.cbrt(b - 1));

    double numerator = (b - a) * b - (c / (b - Math.cos(a)));
    double denominator = 1 + Math.pow(b - a, 2);
    double y = numerator / denominator;

    System.out.printf("Результат вычисления x: %.4f%n", x);
    System.out.printf("Результат вычисления y: %.4f%n", y);
}
