package TicTacToe2;

import java.io.*;
import java.time.LocalDateTime;

public class StatisticsManager {
    public static void saveStats(String winner, String pX, String pO, int size) {
        try {
            FileWriter fw = new FileWriter("stats.txt", true);
            String line = LocalDateTime.now().toString() + " | " + pX + " (X) vs " + pO + " (O) | Переможець: " + winner + " | Розмір: " + size + "x" + size + "\n";
            fw.write(line);
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
