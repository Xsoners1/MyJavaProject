package TicTacToe3;

import java.io.*;

public class ConfigManager {
    public static GameConfig config = new GameConfig();

    public static void saveConfig() {
        try {
            FileWriter fw = new FileWriter("config.txt");
            fw.write("size=" + config.size + "\n");
            fw.write("player1=" + config.player1 + "\n");
            fw.write("player2=" + config.player2 + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Помилка збереження конфігурації.");
        }
    }

    public static void loadConfig() {
        try {
            File file = new File("config.txt");
            if (!file.exists()) return;

            BufferedReader br = new BufferedReader(new FileReader(file));

            String sizeLine = br.readLine();
            String p1Line = br.readLine();
            String p2Line = br.readLine();

            if (sizeLine != null && sizeLine.contains("=")) {
                config.size = Integer.parseInt(sizeLine.split("=")[1]);
                config.player1 = p1Line.split("=")[1];
                config.player2 = p2Line.split("=")[1];
            } else {
                config.size = Integer.parseInt(sizeLine);
                config.player1 = p1Line;
                config.player2 = p2Line;
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Помилка читання конфігурації: " + e.getMessage());
        }
    }
}
