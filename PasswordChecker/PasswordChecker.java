import java.util.Scanner;

public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        if (isStrongPassword(password)) {
            System.out.println("Пароль надійний.");
        } else {
            System.out.println("Пароль не відповідає вимогам безпеки.");
        }
    }

    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;
        boolean hasDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasSpecialChar && hasDigit;

    }
}
