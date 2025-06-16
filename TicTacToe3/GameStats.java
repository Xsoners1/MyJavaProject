package TicTacToe3;

public class GameStats {
    public String winner;
    public String playerX;
    public String playerO;
    public int boardSize;
    public String dateTime;

    public GameStats(String winner, String playerX, String playerO, int boardSize, String dateTime) {
        this.winner = winner;
        this.playerX = playerX;
        this.playerO = playerO;
        this.boardSize = boardSize;
        this.dateTime = dateTime;
    }

    public String toLine() {
        return dateTime + " | " + playerX + " (X) vs " + playerO + " (O) | Переможець: " + winner + " | Розмір: " + boardSize + "x" + boardSize;
    }
}
