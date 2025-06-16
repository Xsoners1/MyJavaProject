package TicTacToe3;

import java.util.Scanner;

public class Game {
    private GameConfig config;
    private GameBoard gameBoard;
    private Scanner scanner = new Scanner(System.in);

    public Game(GameConfig config) {
        this.config = config;
        this.gameBoard = new GameBoard(config.size);
    }

    public void play() {
        int moves = 0;
        char current = 'X';

        while (true) {
            printBoard();
            System.out.println("Хід " + (current == 'X' ? config.player1 : config.player2) + " (" + current + ")");
            int r, c;
            while (true) {
                System.out.print("Рядок: ");
                r = scanner.nextInt();
                System.out.print("Стовпець: ");
                c = scanner.nextInt();
                scanner.nextLine();
                if (r >= 0 && r < config.size && c >= 0 && c < config.size && gameBoard.board[r][c] == ' ') break;
                System.out.println("Невірна позиція.");
            }
            gameBoard.board[r][c] = current;
            moves++;

            if (checkWin(current)) {
                printBoard();
                String winner = (current == 'X') ? config.player1 : config.player2;
                System.out.println("Переміг: " + winner);
                StatisticsManager.saveStats(new GameStats(winner, config.player1, config.player2, config.size, java.time.LocalDateTime.now().toString()));
                break;
            } else if (moves == config.size * config.size) {
                printBoard();
                System.out.println("Нічия!");
                StatisticsManager.saveStats(new GameStats("Нічия", config.player1, config.player2, config.size, java.time.LocalDateTime.now().toString()));
                break;
            }

            current = (current == 'X') ? 'O' : 'X';
        }
    }

    private void printBoard() {
        for (int i = 0; i < config.size; i++) {
            for (int j = 0; j < config.size; j++) {
                System.out.print(" " + gameBoard.board[i][j]);
                if (j < config.size - 1) System.out.print(" |");
            }
            System.out.println();
            if (i < config.size - 1) {
                for (int j = 0; j < config.size; j++) {
                    System.out.print("---");
                    if (j < config.size - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    private boolean checkWin(char p) {
        for (int i = 0; i < config.size; i++) {
            boolean row = true, col = true;
            for (int j = 0; j < config.size; j++) {
                if (gameBoard.board[i][j] != p) row = false;
                if (gameBoard.board[j][i] != p) col = false;
            }
            if (row || col) return true;
        }

        boolean d1 = true, d2 = true;
        for (int i = 0; i < config.size; i++) {
            if (gameBoard.board[i][i] != p) d1 = false;
            if (gameBoard.board[i][config.size - 1 - i] != p) d2 = false;
        }
        return d1 || d2;
    }
}
