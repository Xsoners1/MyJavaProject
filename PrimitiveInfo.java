import java.util.Scanner;

public class PrimitiveInfo {
    public static void main(String[] args) {
        System.out.println("Примітивні типи даних:");
        System.out.println("int:");
        System.out.println("Розмір: " + Integer.BYTES + " байт");
        System.out.println("Мінімальне значення: " + Integer.MIN_VALUE);
        System.out.println("Максимальне значення: " + Integer.MAX_VALUE);
        System.out.println();

        System.out.println("double:");
        System.out.println("Розмір: " + Double.BYTES + " байт");
        System.out.println("Мінімальне значення: " + Double.MIN_VALUE);
        System.out.println("Максимальне значення: " + Double.MAX_VALUE);
        System.out.println();

        System.out.println("boolean:");
        System.out.println("Мінімальне значення: " + Boolean.FALSE);
        System.out.println("Максимальне значення: " + Boolean.TRUE);
        System.out.println();

        System.out.println("char:");
        System.out.println("Розмір: " + Character.BYTES + " байт");
        System.out.println("Мінімальне значення: " + (int) Character.MIN_VALUE);
        System.out.println("Максимальне значення: " + (int) Character.MAX_VALUE);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ціле число (int): ");
        String intInput = scanner.nextLine();
        try {
            int intValue = Integer.parseInt(intInput);
            System.out.println("Ви ввели ціле число: " + intValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для int.");
        }

        System.out.print("Введіть число з плаваючою точкою (double): ");
        String doubleInput = scanner.nextLine();
        try {
            double doubleValue = Double.parseDouble(doubleInput);
            System.out.println("Ви ввели число з плаваючою точкою: " + doubleValue);
        } catch (NumberFormatException e) {
            System.out.println("Неправильний формат для double.");
        }

        System.out.print("Введіть булеве значення (true або false): ");
        String booleanInput = scanner.nextLine();
        try {
            boolean booleanValue = Boolean.parseBoolean(booleanInput);
            System.out.println("Ви ввели булеве значення: " + booleanValue);
        } catch (Exception e) {
            System.out.println("Неправильний формат для boolean.");
        }

        System.out.print("Введіть символ (char): ");
        String charInput = scanner.nextLine();
        if (charInput.length() == 1) {
            char charValue = charInput.charAt(0);
            System.out.println("Ви ввели символ: " + charValue);
        } else {
            System.out.println("Неправильний формат для char.");
        }

        scanner.close();
    }
}
