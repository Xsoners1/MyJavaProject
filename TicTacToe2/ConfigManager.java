package TicTacToe2;

import java.io.*;

public class ConfigManager {
    public static int size = 3;
    public static String player1 = "Гравець 1";
    public static String player2 = "Гравець 2";

    public static void saveConfig() {
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

    public static void loadConfig() {
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
}
