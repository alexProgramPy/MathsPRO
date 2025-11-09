/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUIScreensCode;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alex von Allemann 12.5 IT PAT
 */
public class TimesTablesQuestions {

    private List<String> questions;

    // Initializes the list of questions by loading them from a file.
    public TimesTablesQuestions() {
        questions = new ArrayList<>();
        loadQuestionsFromFile("TimesTablesQuestions.txt");
    }

    /**
     * Loads questions from a specified file path. Each line in the file is
     * considered a question. Lines starting with '#' are treated as comments
     * and ignored.
     *
     * @param filePath the path to the file containing times tables questions.
     */
    private void loadQuestionsFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.indexOf("#");
                if (index != -1) {
                    line = line.substring(0, index); //extracts text before the hashtag.
                }
                questions.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error loading questions: " + e.getMessage());
        }
    }

    /**
     * Retrieves a random question from the loaded list of questions.
     *
     * @return a random question from the times tables questions list.
     */
    public String getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}
