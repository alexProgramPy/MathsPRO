package GUIScreensCode;

/**
 *
 * @author alexv IT PAT 2024
 */
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BODMASQuestions {

    // List to store the BODMAS questions
    private List<String> questions;

    // Constructor to initialize the list and load questions from a file
    public BODMASQuestions() {
        questions = new ArrayList<>();
        loadQuestionsFromFile("BODMASQuestions.txt");
    }

    // Method to load questions from a specified file
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

    // Method to retrieve a random question from the list
    public String getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(questions.size());
        return questions.get(index);
    }
}
