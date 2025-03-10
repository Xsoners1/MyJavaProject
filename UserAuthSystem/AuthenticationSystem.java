package UserAuthSystem;

import java.util.Scanner;

public class AuthenticationSystem {

    private static final int MAX_USERS = 15;
    private static String[] usernames = new String[MAX_USERS];
    private static String[] passwords = new String[MAX_USERS];
    private static int userCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Меню:");
            System.out.println("1 - Додати користувача");
            System.out.println("2 - Видалити користувача");
            System.out.println("3 - Виконати дію від імені користувача");
            System.out.println("4 - Вихід");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addUser(scanner);
                        break;
                    case 2:
                        removeUser(scanner);
                        break;
                    case 3:
                        authenticateUser(scanner);
                        break;
                    case 4:
                        System.out.println("Вихід...");
                        return;
                    default:
                        System.out.println("Невірний вибір.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void addUser(Scanner scanner) throws Exception {
        if (userCount >= MAX_USERS) {
            throw new Exception("Не можна додати більше користувачів.");
        }

        System.out.print("Введіть ім'я користувача (не менше 5 символів, без пробілів): ");
        String username = scanner.nextLine();
        if (username.length() < 5 || username.contains(" ")) {
            throw new Exception("Ім'я користувача має бути не менше 5 символів і не містити пробіли.");
        }

        System.out.print("Введіть пароль (не менше 10 символів, має хоча б 3 цифри і 1 спеціальний символ): ");
        String password = scanner.nextLine();
        if (!isValidPassword(password)) {
            throw new Exception("Пароль не відповідає вимогам.");
        }

        usernames[userCount] = username;
        passwords[userCount] = password;
        userCount++;
        System.out.println("Користувача успішно зареєстровано.");
    }

    private static void removeUser(Scanner scanner) throws Exception {
        System.out.print("Введіть ім'я користувача для видалення: ");
        String usernameToRemove = scanner.nextLine();

        boolean userFound = false;
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(usernameToRemove)) {
                userFound = true;

                for (int j = i; j < userCount - 1; j++) {
                    usernames[j] = usernames[j + 1];
                    passwords[j] = passwords[j + 1];
                }
                usernames[userCount - 1] = null;
                passwords[userCount - 1] = null;
                userCount--;
                System.out.println("Користувача успішно видалено.");
                break;
            }
        }

        if (!userFound) {
            throw new Exception("Користувача з таким ім'ям не знайдено.");
        }
    }

    private static void authenticateUser(Scanner scanner) throws Exception {
        System.out.print("Введіть ім'я користувача: ");
        String username = scanner.nextLine();

        System.out.print("Введіть пароль: ");
        String password = scanner.nextLine();

        boolean authenticated = false;
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username) && passwords[i].equals(password)) {
                authenticated = true;
                break;
            }
        }

        if (authenticated) {
            System.out.println("Користувач успішно аутентифікований.");
        } else {
            throw new Exception("Невірне ім'я користувача або пароль.");
        }
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 10 || password.contains(" ")) {
            return false;
        }

        int digitCount = 0;
        boolean specialCharFound = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (!Character.isLetterOrDigit(c)) {
                specialCharFound = true;
            }
        }

        return digitCount >= 3 && specialCharFound;
    }
}
