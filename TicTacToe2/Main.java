package TicTacToe2;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Game game;

    public static void main(String[] args) {
        ConfigManager.loadConfig();
        game = new Game(ConfigManager.size, ConfigManager.player1, ConfigManager.player2);

        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Нова гра");
            System.out.println("2. Налаштування");
            System.out.println("3. Переглянути статистику");
            System.out.println("4. Вийти");
            System.out.print("Ваш вибір: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                game.play();
            } else if (choice.equals("2")) {
                System.out.print("Ім’я гравця X: ");
                ConfigManager.player1 = scanner.nextLine();
                System.out.print("Ім’я гравця O: ");
                ConfigManager.player2 = scanner.nextLine();
                System.out.print("Розмір поля (3–5): ");
                ConfigManager.size = Integer.parseInt(scanner.nextLine());

                ConfigManager.saveConfig();
                game = new Game(ConfigManager.size, ConfigManager.player1, ConfigManager.player2);
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
