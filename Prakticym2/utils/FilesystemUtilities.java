package Prakticym2.utils;

import Prakticym2.DiaryApplication;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilesystemUtilities {

    public static void saveToFile(String filePath, LocalDateTime[] dates, String[] records, DateTimeFormatter format) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int i = 0; i < dates.length; i++) {
                if (dates[i] != null) {
                    writer.println(dates[i].format(format));
                    writer.println(records[i]);
                    writer.println(); // порожній рядок між записами
                }
            }
            System.out.println("Щоденник збережено.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні файлу.");
        }
    }

    public static void loadFromFile(String filePath, LocalDateTime[] dates, String[] records, DateTimeFormatter format) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < dates.length) {
                if (line.trim().isEmpty()) continue;

                dates[index] = LocalDateTime.parse(line, format);

                StringBuilder recordText = new StringBuilder();
                while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                    recordText.append(line).append("\n");
                }

                records[index] = recordText.toString();
                index++;
            }

            System.out.println("Щоденник завантажено.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні файлу.");
        }
    }
}
