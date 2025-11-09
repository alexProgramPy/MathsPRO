package GUIScreensCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Alex von Allemann 12.5 IT PAT
 */
public class QuizFileHandler {
    
    
// File path for the quiz answers file
    private static final String filePath = "TimesTablesanswers.txt";

   // Counts the number of lines in the quiz answers file.
    private static int countLines() throws IOException {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lines++;
            }
        }
        return lines;
    }

    // Method to clear file contents
    private static void clearFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(""); // Clearing the file by writing an empty string
        }
    }

    // Method to check and clear file if necessary
    public static void checkAndClearFile(String filePath) {
        try {
            int lines = countLines();
            if (lines >= 30) {
                clearFile();
                System.out.println("File cleared after 30 entries: " + filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions accordingly
        }
    }

}
