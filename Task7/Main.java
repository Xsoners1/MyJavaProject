package Task7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc =
                new Scanner(System.in);

        UserRegistry registry =
                new UserRegistry();

        System.out.println(
                "Завантажити базу? (y/n)"
        );

        if (
                sc.nextLine()
                        .equalsIgnoreCase("y")
        ) {

            System.out.print(
                    "Файл: "
            );

            registry.loadFromFile(
                    sc.nextLine()
            );
        }

        while (true) {

            System.out.println("\n1 Реєстрація");
            System.out.println("2 Логін");
            System.out.println("3 Показати");
            System.out.println("0 Вихід");

            int option =
                    sc.nextInt();

            sc.nextLine();

            switch (option) {

                case 1:

                    System.out.print(
                            "Логін: "
                    );

                    String login =
                            sc.nextLine();

                    System.out.print(
                            "Пароль: "
                    );

                    String pass =
                            sc.nextLine();

                    registry.registerUser(
                            login,
                            pass
                    );

                    break;

                case 2:

                    System.out.print(
                            "Логін: "
                    );

                    login =
                            sc.nextLine();

                    System.out.print(
                            "Пароль: "
                    );

                    pass =
                            sc.nextLine();

                    registry.loginUser(
                            login,
                            pass
                    );

                    break;

                case 3:

                    registry.displayUsers();

                    break;

                case 0:

                    System.out.println(
                            "Зберегти? (y/n)"
                    );

                    if (
                            sc.nextLine()
                                    .equalsIgnoreCase("y")
                    ) {

                        System.out.print(
                                "Файл: "
                        );

                        registry.saveToFile(
                                sc.nextLine()
                        );
                    }

                    return;
            }
        }
    }
}