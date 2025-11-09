/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIScreens_package;

import GUIScreens_package.ProfileScreen;
import GUIScreensCode.AlgebraQuestions;
import GUIScreensCode.BODMASQuestions;
import GUIScreensCode.Difficulty;
import GUIScreensCode.FrameUtils;
import GUIScreensCode.QuizFileHandler;
import static GUIScreensCode.QuizFileHandler.checkAndClearFile;
import GUIScreensCode.QuizType;
import GUIScreensCode.TimesTablesQuestions;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author alexv
 */
public class QuizAnswerScreen extends javax.swing.JFrame {

    // Variables for quiz management
    private Difficulty difficulty;
    private TimesTablesQuestions timestablesQuestions;
    private AlgebraQuestions algebraQuestions;
    private BODMASQuestions bodmasQuestions;
    private int timeRemaining;
    private Timer timer;
    private QuizType quizType;
    private static final String TIMES_TABLES_FILE = "TimesTablesAnswers.txt";
    private static final String BODMAS_FILE = "BODMASAnswers.txt";
    private static final String ALGEBRA_FILE = "AlgebraAnswers.txt";
    private List<String> userAnswers = new ArrayList<>();
    private List<String> questions = new ArrayList<>();
    private List<String> correctAnswers = new ArrayList<>();
    private int correctCount = 0;
    private ProfileScreen profileScreen;
    private LeaderboardTimesTables leaderboardTimesTables;
    private JTextArea Top100Easy;
    private JTextArea Top100Medium;
    private JTextArea Top100Hard;
    private int submitButtonPresses = 0;
    private String quizDifficulty;
    private QuizSelectionScreen.AlgebraQuizListener Listener;

    /**
     * Creates new form QuizAnswerScreen
     */
    public QuizAnswerScreen(Difficulty difficulty, QuizType quizType) {

        this.difficulty = difficulty;
        this.quizType = quizType;
        initComponents();
        FrameUtils.addFrame(this);
        applySavedBackgroundColor();

        // Initialize quiz question objects based on quiz type
        if (quizType == QuizType.TIMES_TABLES) {
            timestablesQuestions = new TimesTablesQuestions();
        } else if (quizType == QuizType.ALGEBRA) {
            algebraQuestions = new AlgebraQuestions();
        } else if (quizType == QuizType.BODMAS) {
            bodmasQuestions = new BODMASQuestions();
        }

        // Set up timer and load questions and answers based on quiz type
        if (difficulty != null) {
            timeRemaining = difficulty.getDurationSeconds();
            updateTimerLabel();
        } else {
            timerLabel.setText("Difficulty not set");
        }
        // Load answers and questions based on the quiz type
        if (quizType == QuizType.TIMES_TABLES) {
            readAnswersFromFile(TIMES_TABLES_FILE);
            readQuestionsAndAnswers("TimesTablesQuestions.txt");
        } else if (quizType == QuizType.BODMAS) {
            readAnswersFromFile(BODMAS_FILE);
            readQuestionsAndAnswers("BODMASQuestions.txt"); // Adjust the file name as per your actual file
        } else if (quizType == QuizType.ALGEBRA) {
            readAnswersFromFile(ALGEBRA_FILE);
            readQuestionsAndAnswers("AlgebraQuestions.txt"); // Adjust the file name as per your actual file
        }

        ProgressBar.setMaximum(31); //This is based on the number of questions 
        timeRemaining = difficulty.getDurationSeconds();
        updateTimerLabel();

        readAnswersFromFile("TimesTablesAnswers.txt");
        readQuestionsAndAnswers("TimesTablesQuestions.txt");

        QuestionArea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        QuestionArea.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        ToolTip.setToolTipText("Track your progress and score at the top. Keep an eye on your performance!");
    }

    // Method to read answers from a file
    private List<String> readAnswersFromFile(String filePath) {
        List<String> answers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                answers.add(line.trim());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading answer file: " + e.getMessage());
        }
        return answers;
    }

    // Method to set the timer for the quiz
    private void SetTimer() {
        int timeInSeconds = difficulty.getDurationSeconds();
    }

    // Method to handle submit button press
    public void submitButtonPressed() {
        submitButtonPresses++;
        if (submitButtonPresses >= 29) {
            quizCompleted(timeRemaining, quizDifficulty);
        }
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public void quizCompleted(int timeRemaining, String quizDifficulty) {

        // Update the leaderboard
        if (leaderboardTimesTables != null) {

            System.out.println("Updating leaderboard with time remaining: " + timeRemaining);
            leaderboardTimesTables.updateLeaderboard(timeRemaining, quizDifficulty);

            // Update the corresponding JTextArea based on quizDifficulty
            SwingUtilities.invokeLater(() -> {
                switch (quizDifficulty) {
                    case "Easy":
                        updateTextArea(Top100Easy, leaderboardTimesTables.getTimesEasy());
                        break;
                    case "Medium":
                        updateTextArea(Top100Medium, leaderboardTimesTables.getTimesMedium());
                        break;
                    case "Hard":
                        updateTextArea(Top100Hard, leaderboardTimesTables.getTimesHard());
                        break;
                    default:
                        System.out.println("Invalid quiz difficulty.");
                        break;
                }
            });
        } else {
            System.out.println("Leaderboard instance not found or properly initialized.");
        }
    }

    private void updateTextArea(JTextArea textArea, ArrayList<Integer> times) {
        // Sort times if necessary
        Collections.sort(times);

        // Display top 50 times for the corresponding difficulty level
        StringBuilder timesText = new StringBuilder();
        for (int i = 0; i < Math.min(50, times.size()); i++) {
            timesText.append(times.get(i)).append("\n");
        }
        textArea.setText(timesText.toString());
    }

    // Method to update the timer label with remaining time
    private void updateTimerLabel() {
        timerLabel.setText("Time Remaining: " + timeRemaining + " seconds");
    }

    // Method to read questions and answers from a file
    private void readQuestionsAndAnswers(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 2) {
                    questions.add(parts[0].trim());
                    correctAnswers.add(parts[1].trim());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading question file: " + e.getMessage());
        }
    }

    // Method to count correct answers submitted by the user
    private int countCorrectAnswers() {
        int correctCount = 0;
        int numAnswers = Math.min(userAnswers.size(), correctAnswers.size());
        for (int i = 0; i < numAnswers; i++) {
            if (i < correctAnswers.size()) {
                String userAnswer = userAnswers.get(i).trim().toLowerCase();
                String expectedAnswer = correctAnswers.get(i).trim().toLowerCase();

                // Debugging output to check answers
                System.out.println("User Answer: " + userAnswer);
                System.out.println("Expected Answer: " + expectedAnswer);

                if (userAnswer.equals(expectedAnswer)) {
                    correctCount++;
                }
            }
        }
        return correctCount;
    }

    // Method to display a random question from the loaded questions
    private void displayRandomQuestion() {

        if (questions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No questions loaded.");
            return;
        }
        int randomIndex = (int) (Math.random() * questions.size());
        String randomQuestion = questions.get(randomIndex);
        String correctAnswer = correctAnswers.get(randomIndex);
        QuestionArea.setText(randomQuestion);

        QuestionArea.putClientProperty("correctAnswer", correctAnswer);
        QuestionArea.revalidate();
        QuestionArea.repaint();

    }

    // Method to apply saved background color to the screen
    private void applySavedBackgroundColor() {
        Color savedColor = FrameUtils.getBackgroundColor();
        changeContainerBackground(this.getContentPane(), savedColor);
    }

    // Method to change background color of a container and its components recursively
    public static void changeContainerBackground(Container container, Color color) {
        for (Component component : container.getComponents()) {
            if (component instanceof JPanel) {
                component.setBackground(color);
            }
            if (component instanceof Container) {
                changeContainerBackground((Container) component, color);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GreenBackground = new javax.swing.JPanel();
        QuizHeading = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        QuizProgress = new javax.swing.JLabel();
        QuestionHeading = new javax.swing.JLabel();
        AnswerHereHeading = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        ToolTip = new javax.swing.JLabel();
        QuestionArea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        AnswerField = new javax.swing.JTextArea();
        StartButton = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GreenBackground.setBackground(new java.awt.Color(0, 102, 0));

        QuizHeading.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        QuizHeading.setText("Quiz:");

        QuizProgress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        QuizProgress.setForeground(new java.awt.Color(255, 102, 0));
        QuizProgress.setText("Quiz Progress: (30 Questions)");

        QuestionHeading.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        QuestionHeading.setForeground(new java.awt.Color(255, 102, 0));
        QuestionHeading.setText("Question:");

        AnswerHereHeading.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        AnswerHereHeading.setForeground(new java.awt.Color(255, 102, 0));
        AnswerHereHeading.setText("Answer Here:");

        BackButton.setBackground(new java.awt.Color(255, 102, 0));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        SubmitButton.setBackground(new java.awt.Color(255, 102, 0));
        SubmitButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        ToolTip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ToolTipIcon.png"))); // NOI18N
        ToolTip.setToolTipText("Choose a quiz category to begin. Each category offers different challenges!\n");

        QuestionArea.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        AnswerField.setColumns(20);
        AnswerField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AnswerField.setRows(5);
        jScrollPane1.setViewportView(AnswerField);

        StartButton.setBackground(new java.awt.Color(255, 102, 0));
        StartButton.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        StartButton.setText("PRESS ME TO START!");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        timerLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        javax.swing.GroupLayout GreenBackgroundLayout = new javax.swing.GroupLayout(GreenBackground);
        GreenBackground.setLayout(GreenBackgroundLayout);
        GreenBackgroundLayout.setHorizontalGroup(
            GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                    .addComponent(ToolTip, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(QuizHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(24, 24, 24)
                                    .addComponent(QuizProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                    .addComponent(QuestionHeading)
                                    .addGap(195, 195, 195)
                                    .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addComponent(AnswerHereHeading))
                                        .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))
                    .addComponent(QuestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GreenBackgroundLayout.setVerticalGroup(
            GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ToolTip, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(QuizProgress)
                            .addComponent(QuizHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(QuestionHeading)
                        .addGap(41, 41, 41)
                        .addComponent(QuestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(AnswerHereHeading)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GreenBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(GreenBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        QuizSelectionScreen QuizSelection = new QuizSelectionScreen(profileScreen, Listener);
        QuizSelection.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private int currentProgress = 0;

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        // Get user's answer from AnswerField
        String userAnswer = AnswerField.getText().trim().toLowerCase();
        if (userAnswer.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an answer.");
            return;
        }

        // Get correct answer associated with displayed question
        String correctAnswer = (String) QuestionArea.getClientProperty("correctAnswer");

        // Debugging output to check answers
        System.out.println("User Answer: " + userAnswer);
        System.out.println("Expected Answer: " + correctAnswer);

        // Compare user's answer with correct answer
        if (userAnswer.equals(correctAnswer.toLowerCase())) {
            // Handle correct answer logic
            System.out.println("Correct answer!");
            correctCount++; // Increment correct count
        } else {
            // Handle incorrect answer logic
            System.out.println("Incorrect answer!");
        }
        currentProgress++;
        ProgressBar.setValue(currentProgress);
        // Compare user's answer with correct answer

        // Clear AnswerField
        AnswerField.setText("");

        // Display next question or finish quiz logic
        displayRandomQuestion();

        if (currentProgress >= 31) {
            displayResults();
        }
    }//GEN-LAST:event_SubmitButtonActionPerformed

    // private int countCorrectAnswers() {
    //     int correctCount = 0;
    //   String filePath;
    //    if (quizType == QuizType.TIMES_TABLES) {
    //        filePath = TIMES_TABLES_FILE;
    //     } else if (quizType == QuizType.BODMAS) {
    //      filePath = BODMAS_FILE;
    //   } else if (quizType == QuizType.ALGEBRA) {
    //       filePath = ALGEBRA_FILE;
    //  } else {
    //      return 0; // No quiz type set
    //  }
    // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))
    //   ) {
    ///        String line;
    //    int index = 0;
    //   while ((line = reader.readLine()) != null && index < userAnswers.size()) {
    // Assuming each line in the file is in the format "question #correct_answer"
    //      String[] parts = line.split("#");
    //     if (parts.length == 2 && userAnswers.get(index).trim().equalsIgnoreCase(parts[1].trim())) {
    //         correctCount++;
    //    }
    //    index++;
    //  }
    // }
    // catch (IOException e
    //     ) {
    //        JOptionPane.showMessageDialog(this, "Error reading answer file: " + e.getMessage());
    //  }
    //  return correctCount ;
//}
    private void displayResults() {
        int totalQuestions = 30;
        JOptionPane.showMessageDialog(this, "Quiz completed!\nYou got " + correctCount + " out of " + totalQuestions + " correct.");

        clearAnswerFile();
        ProgressBar.setValue(0);
    }

    private void clearAnswerFile() {
        String filePath;

        if (quizType == QuizType.TIMES_TABLES) {
            filePath = TIMES_TABLES_FILE;
        } else if (quizType == QuizType.BODMAS) {
            filePath = BODMAS_FILE;
        } else if (quizType == QuizType.ALGEBRA) {
            filePath = ALGEBRA_FILE;
        } else {
            filePath = "DefaultAnswers.txt";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(""); // Write an empty string to clear the file
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error clearing answer file: " + e.getMessage());
        }
    }

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartButtonActionPerformed
        // TODO add your handling code here:
        StartButton.setVisible(false);
        displayRandomQuestion();
        startTimer();
    }//GEN-LAST:event_StartButtonActionPerformed

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        this.timeRemaining = difficulty.getDurationSeconds();
        updateTimerLabel();
    }

    // Method to start the quiz timer
    private void startTimer() {

        if (difficulty == null) {
            JOptionPane.showMessageDialog(this, "Difficulty not set. The timer cannot start!");
            return;
        }
        if (timer != null && timer.isRunning()) {
            timer.stop(); // Stop the timer if it's already running
        }

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                updateTimerLabel();

                if (timeRemaining <= 0) {
                    timer.stop();
                    timerLabel.setText("Time's up!");
                    // Handle actions when time is up
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1000); // Waits for 1 second
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                            }
                            showMessageAndReturnToSelectionScreen();
                        }
                    });
                }
            }
        });

        timer.start(); // Start the timer
    }

    //This message will only show if the timer has ran out
    private void showMessageAndReturnToSelectionScreen() {
        JOptionPane.showMessageDialog(this, "You ran out of time!");
        new QuizSelectionScreen(profileScreen, Listener).setVisible(true);
        this.dispose(); // Close the current screen
    }

    //method to save answers to a file
    private void saveToFile(String answer) {
        String fileName;

        // Determine the file name based on the quiz type
        if (quizType == QuizType.TIMES_TABLES) {
            fileName = "TimesTablesAnswers.txt";
        } else if (quizType == QuizType.BODMAS) {
            fileName = "BODMASAnswers.txt";
        } else if (quizType == QuizType.ALGEBRA) {
            fileName = "AlgebraAnswers.txt";
        } else {

            fileName = "DefaultAnswers.txt";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(answer);
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving answer: " + e.getMessage());
        }
    }

    //Method to check if answers are correct
    private void checkAnswer() {
        String userAnswer = AnswerField.getText().trim(); // Assuming UserAnswerField is a JTextField
        String correctAnswer = (String) QuestionArea.getClientProperty("correctAnswer");

        if (userAnswer.equals(correctAnswer)) {
            // Correct answer handling
            JOptionPane.showMessageDialog(this, "Correct answer!");
            // Additional logic as needed
        } else {
            // Incorrect answer handling
            JOptionPane.showMessageDialog(this, "Incorrect answer! Expected: " + correctAnswer);
            // Additional logic as needed
        }
    }

    private void someMethod() {
        String filePath;

        // Determine the file path based on quizType
        if (quizType == QuizType.TIMES_TABLES) {
            filePath = TIMES_TABLES_FILE;
        } else if (quizType == QuizType.BODMAS) {
            filePath = BODMAS_FILE;
        } else if (quizType == QuizType.ALGEBRA) {
            filePath = ALGEBRA_FILE;
        } else {
            // Handle other cases or default
            filePath = "DefaultAnswers.txt";
        }

        QuizFileHandler.checkAndClearFile(filePath);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuizAnswerScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizAnswerScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizAnswerScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizAnswerScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Difficulty difficulty = Difficulty.EASY;
                QuizType quizType = QuizType.BODMAS;
                QuizAnswerScreen QuizAnswer = new QuizAnswerScreen(difficulty, quizType);
                QuizAnswer.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AnswerField;
    private javax.swing.JLabel AnswerHereHeading;
    private javax.swing.JButton BackButton;
    private javax.swing.JPanel GreenBackground;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel QuestionArea;
    private javax.swing.JLabel QuestionHeading;
    private javax.swing.JLabel QuizHeading;
    private javax.swing.JLabel QuizProgress;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JLabel ToolTip;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
