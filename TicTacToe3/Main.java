package TicTacToe3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConfigManager.loadConfig();

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Нова гра");
            System.out.println("2. Налаштування");
            System.out.println("3. Статистика");
            System.out.println("4. Вийти");
            System.out.print("Ваш вибір: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                new Game(ConfigManager.config).play();
            } else if (choice.equals("2")) {
                System.out.print("Ім’я гравця X: ");
                ConfigManager.config.player1 = scanner.nextLine();
                System.out.print("Ім’я гравця O: ");
                ConfigManager.config.player2 = scanner.nextLine();
                System.out.print("Розмір поля (3–5): ");
                ConfigManager.config.size = Integer.parseInt(scanner.nextLine());
                ConfigManager.saveConfig();
            } else if (choice.equals("3")) {
                StatisticsManager.showStats();
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Невірний вибір.");
            }
        }
    }
}
