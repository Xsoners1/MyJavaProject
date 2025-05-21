package TicTacToe2;

import java.util.Scanner;

public class Game {
    private int size;
    private char[][] board;
    private String playerX, playerO;
    private Scanner scanner = new Scanner(System.in);

    public Game(int size, String p1, String p2) {
        this.size = size;
        this.playerX = p1;
        this.playerO = p2;
        board = new char[size][size];
    }

    public void play() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                board[i][j] = ' ';

        char current = 'X';
        int moves = 0;

        while (true) {
            printBoard();
            System.out.println("Хід " + (current == 'X' ? playerX : playerO) + " (" + current + ")");
            int r, c;
            while (true) {
                System.out.print("Рядок: ");
                r = scanner.nextInt();
                System.out.print("Стовпець: ");
                c = scanner.nextInt();
                scanner.nextLine();
                if (r >= 0 && r < size && c >= 0 && c < size && board[r][c] == ' ') break;
                System.out.println("Невірна позиція.");
            }
            board[r][c] = current;
            moves++;

            if (checkWin(current)) {
                printBoard();
                String winner = current == 'X' ? playerX : playerO;
                System.out.println("Переміг: " + winner);
                StatisticsManager.saveStats(winner, playerX, playerO, size);
                break;
            } else if (moves == size * size) {
                printBoard();
                System.out.println("Нічия!");
                StatisticsManager.saveStats("Нічия", playerX, playerO, size);
                break;
            }

            current = (current == 'X') ? 'O' : 'X';
        }
    }

    private void printBoard() {
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

    private boolean checkWin(char p) {
        for (int i = 0; i < size; i++) {
            boolean row = true, col = true;
            for (int j = 0; j < size; j++) {
                if (board[i][j] != p) row = false;
                if (board[j][i] != p) col = false;
            }
            if (row || col) return true;
        }
        boolean d1 = true, d2 = true;
        for (int i = 0; i < size; i++) {
            if (board[i][i] != p) d1 = false;
            if (board[i][size - 1 - i] != p) d2 = false;
        }
        return d1 || d2;
    }
}
