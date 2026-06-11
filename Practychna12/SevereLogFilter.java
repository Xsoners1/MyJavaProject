package Practychna12;

import java.io.*;
import java.util.Scanner;

public class SevereLogFilter implements LogFilter {

    @Override
    public void filter(String sourceFile,
                       String targetFile,
                       LogLevel level) {

        String keyword = "[" + level.name() + "]";

        try (
                Scanner scanner = new Scanner(
                        new BufferedReader(
                                new FileReader(sourceFile)
                        )
                );

                PrintWriter writer = new PrintWriter(
                        new BufferedWriter(
                                new FileWriter(targetFile)
                        )
                )
        ) {

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                if (line.contains(keyword)) {
                    writer.println(line);
                }
            }

            System.out.println("Фільтрація завершена!");

        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}