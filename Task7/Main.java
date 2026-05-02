package Task7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserRegistry registry = new UserRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Logout");
            System.out.println("4. Check user");
            System.out.println("5. Remove user");
            System.out.println("6. Count users");
            System.out.println("7. Show all users");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Password: ");
                    String pass = scanner.nextLine();
                    registry.registerUser(login, pass);
                    break;

                case 2:
                    System.out.print("Login: ");
                    login = scanner.nextLine();
                    System.out.print("Password: ");
                    pass = scanner.nextLine();
                    registry.loginUser(login, pass);
                    break;

                case 3:
                    System.out.print("User ID: ");
                    int id = scanner.nextInt();
                    registry.logoutUser(id);
                    break;

                case 4:
                    System.out.print("Login: ");
                    login = scanner.nextLine();
                    System.out.println(registry.isUserRegistered(login));
                    break;

                case 5:
                    System.out.print("User ID: ");
                    id = scanner.nextInt();
                    registry.removeUser(id);
                    break;

                case 6:
                    registry.printTotalUniqueUsers();
                    break;

                case 7:
                    registry.displayAllUsers();
                    break;

                case 0:
                    return;
            }
        }
    }
}