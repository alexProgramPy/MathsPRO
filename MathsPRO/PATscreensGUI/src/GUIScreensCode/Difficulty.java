package GUIScreensCode;

/**
 *
 * @author alexv 12.5 IT PAT
 */
public class Difficulty {

    // Predefined instances of the Difficulty class
    public static final Difficulty EASY = new Difficulty("Easy", 480);
    public static final Difficulty MEDIUM = new Difficulty("Medium", 240);
    public static final Difficulty HARD = new Difficulty("Hard", 90);

    // Private fields for the name and duration of the difficulty level
    private final String name;
    private final int durationSeconds;

    // Private constructor to prevent external instantiation
    private Difficulty(String name, int durationSeconds) {
        this.name = name;
        this.durationSeconds = durationSeconds;
    }
// Getter method to retrieve the name of the difficulty level

    public String getName() {
        return name;
    }

    // Getter method to retrieve the duration in seconds for the difficulty level
    public int getDurationSeconds() {
        return durationSeconds;
    }

}
