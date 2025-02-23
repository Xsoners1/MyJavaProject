package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int boardSize = 3;

        while (running) {
            char[][] board = initializeBoard(boardSize);
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    playGame(scanner, board, boardSize);
                    break;
                case 2:
                    boardSize = configureSettings(scanner);
                    break;
                case 3:
                    System.out.println("Вихід з гри. До побачення!");
                    running = false;
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    public static char[][] initializeBoard(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    public static void displayMenu() {
        System.out.println("============================");
        System.out.println("|      Хрестики-Нулики     |");
        System.out.println("============================");
        System.out.println("|  1. Грати (Нова гра)     |");
        System.out.println("|  2. Налаштування         |");
        System.out.println("|  3. Вийти                |");
        System.out.println("============================");
        System.out.print("Оберіть пункт меню: ");
    }

    public static int getUserChoice(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            return -1;
        }
    }

    public static int configureSettings(Scanner scanner) {
        System.out.println("\n ======= Налаштування ========");
        System.out.println("1.|    Змінити розмір поля     |");
        System.out.println("2.|    Повернутися до меню     |");
        System.out.print("Оберіть пункт: ");

        int settingsChoice = getUserChoice(scanner);
        if (settingsChoice == 1) {
            System.out.println("\n Виберіть розмір поля:");
            System.out.println("1. 3x3");
            System.out.println("2. 5x5");
            System.out.println("3. 7x7");
            System.out.println("4. 9x9");
            System.out.print("Оберіть пункт: ");

            int sizeChoice = getUserChoice(scanner);
            switch (sizeChoice) {
                case 1: return 3;
                case 2: return 5;
                case 3: return 7;
                case 4: return 9;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    return 3;
            }
        }
        return 3;
    }

    public static void playGame(Scanner scanner, char[][] board, int size) {
        char currentPlayer = 'X';
        boolean gameRunning = true;

        while (gameRunning) {
            printBoard(board, size);
            System.out.println("Гравець " + currentPlayer + ", введіть рядок і стовпчик: ");
            int row = getUserChoice(scanner) - 1;
            int col = getUserChoice(scanner) - 1;

            if (isValidMove(board, row, col, size)) {
                board[row][col] = currentPlayer;
                if (checkWin(board, size, currentPlayer)) {
                    printBoard(board, size);
                    System.out.println("Гравець " + currentPlayer + " переміг!");
                    gameRunning = false;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Неправильний хід. Спробуйте ще раз.");
            }
        }
    }

    public static boolean isValidMove(char[][] board, int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ';
    }

    public static void printBoard(char[][] board, int size) {
        System.out.println();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < size - 1) System.out.print("|");
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

    public static boolean checkWin(char[][] board, int size, char player) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j + 2 < size && board[i][j] == player && board[i][j + 1] == player && board[i][j + 2] == player) return true;
                if (i + 2 < size && board[i][j] == player && board[i + 1][j] == player && board[i + 2][j] == player) return true;
                if (i + 2 < size && j + 2 < size && board[i][j] == player && board[i + 1][j + 1] == player && board[i + 2][j + 2] == player) return true;
                if (i + 2 < size && j - 2 >= 0 && board[i][j] == player && board[i + 1][j - 1] == player && board[i + 2][j - 2] == player) return true;
            }
        }
        return false;
    }
}
