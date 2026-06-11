package Practychna12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogGenerator {

    public static void generate(String file) {

        String[] levels = {
                "[CRITICAL]",
                "[ERROR]",
                "[WARNING]",
                "[INFO]",
                "[DEBUG]"
        };

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(file)
                     )) {

            for (int i = 1; i <= 50; i++) {

                String line =
                        i + " 2026-06-11T12:00:00Z "
                                + levels[i % levels.length]
                                + " ModuleA "
                                + "Message number " + i;

                writer.write(line);
                writer.newLine();
            }

            System.out.println("Log file created!");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}