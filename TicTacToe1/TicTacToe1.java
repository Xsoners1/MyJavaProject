package TicTacToe1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TicTacToe1 {
    static Scanner scanner = new Scanner(System.in);

    static int size = 3;
    static char[][] board;
    static String player1 = "Гравець 1";
    static String player2 = "Гравець 2";

    public static void main(String[] args) {
        loadConfig();
        while (true) {
            System.out.println("\n--- МЕНЮ ---");
            System.out.println("1. Нова гра");
            System.out.println("2. Налаштування");
            System.out.println("3. Переглянути статистику");
            System.out.println("4. Вийти");
            System.out.print("Ваш вибір: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                playGame();
            } else if (choice.equals("2")) {
                settings();
            } else if (choice.equals("3")) {
                showStats();
            } else if (choice.equals("4")) {
                System.out.println("Вихід...");
                break;
            } else {
                System.out.println("Невірний вибір.");
            }
        }
    }

    static void playGame() {
        board = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';

        char currentPlayer = 'X';
        String nameX = player1;
        String nameO = player2;

        int moves = 0;
        while (true) {
            printBoard();
            System.out.println("Хід гравця " + (currentPlayer == 'X' ? nameX : nameO) + " (" + currentPlayer + ")");
            int row, col;
            while (true) {
                System.out.print("Введіть рядок (0.." + (size - 1) + "): ");
                row = scanner.nextInt();
                System.out.print("Введіть стовпець (0.." + (size - 1) + "): ");
                col = scanner.nextInt();
                scanner.nextLine();
                if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') break;
                System.out.println("Невірний хід, спробуйте ще.");
            }

            board[row][col] = currentPlayer;
            moves++;

            if (checkWin(currentPlayer)) {
                printBoard();
                String winnerName = currentPlayer == 'X' ? nameX : nameO;
                System.out.println("Переможець: " + winnerName);
                saveStats(winnerName, nameX, nameO);
                break;
            } else if (moves == size * size) {
                printBoard();
                System.out.println("Нічия!");
                saveStats("Нічия", nameX, nameO);
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    static void printBoard() {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j]);
                if (j < size - 1) System.out.print(" |");
            }
            System.out.println();
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("---");
                    if (j < size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < size; i++) {
            boolean row = true, col = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != player) row = false;
                if (board[j][i] != player) col = false;
            }
            if (row || col) return true;
        }

        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != player) diag1 = false;
            if (board[i][size - 1 - i] != player) diag2 = false;
        }
        return diag1 || diag2;
    }

    static void settings() {
        System.out.print("Введіть ім’я першого гравця: ");
        player1 = scanner.nextLine();
        System.out.print("Введіть ім’я другого гравця: ");
        player2 = scanner.nextLine();
        while (true) {
            System.out.print("Введіть розмір поля (від 3 до 5): ");
            String input = scanner.nextLine();
            int newSize = Integer.parseInt(input);
            if (newSize >= 3 && newSize <= 5) {
                size = newSize;
                break;
            } else {
                System.out.println("Невірне значення.");
            }
        }
        saveConfig();
    }

    static void saveConfig() {
        try {
            FileWriter fw = new FileWriter("config.txt");
            fw.write("size=" + size + "\n");
            fw.write("player1=" + player1 + "\n");
            fw.write("player2=" + player2 + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Помилка збереження конфігурації.");
        }
    }

    static void loadConfig() {
        try {
            File file = new File("config.txt");
            if (!file.exists()) return;
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("size=")) {
                    size = Integer.parseInt(line.substring(5));
                } else if (line.startsWith("player1=")) {
                    player1 = line.substring(8);
                } else if (line.startsWith("player2=")) {
                    player2 = line.substring(8);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Помилка читання конфігурації.");
        }
    }

    static void saveStats(String winner, String nameX, String nameO) {
        try {
            FileWriter fw = new FileWriter("stats.txt", true);
            String line = LocalDateTime.now().toString() + " | " + nameX + " (X) vs " + nameO + " (O) | Переможець: " + winner + " | Розмір: " + size + "x" + size + "\n";
            fw.write(line);
            fw.close();
        } catch (IOException e) {
            System.out.println("Помилка збереження статистики.");
        }
    }

    static void showStats() {
        try {
            File file = new File("stats.txt");
            if (!file.exists()) {
                System.out.println("Статистика відсутня.");
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("\n--- СТАТИСТИКА ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Помилка читання статистики.");
        }
    }
}
