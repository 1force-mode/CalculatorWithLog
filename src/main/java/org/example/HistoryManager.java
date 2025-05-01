package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryManager {
    private static final String FILE_PATH = "src/main/resources/history.log";

    public static void saveToFile(List<String> history) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static List<String> loadFromFile() {
        List<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return history;
    }

    public static void clearFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            writer.write("");
        } catch (IOException e) {
            System.err.println("Ошибка очистки файла: " + e.getMessage());
        }
    }
}
