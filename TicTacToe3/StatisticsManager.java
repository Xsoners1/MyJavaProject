package TicTacToe3;

import java.io.*;

public class StatisticsManager {
    public static void saveStats(GameStats stats) {
        try {
            FileWriter fw = new FileWriter("stats.txt", true);
            fw.write(stats.toLine() + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Помилка збереження статистики.");
        }
    }

    public static void showStats() {
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
