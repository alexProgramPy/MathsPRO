package GUIScreensCode;

/**
 *
 * @author alexv 12.5 IT PAT 2024
 */
public class QuizType {

    // Constants representing different quiz types
    public static final QuizType TIMES_TABLES = new QuizType("Times Tables");
    public static final QuizType ALGEBRA = new QuizType("Algebra");
    public static final QuizType BODMAS = new QuizType("BODMAS");

    private String name;

    // Initializes the quiz type with a given name.
    private QuizType(String name) {
        this.name = name;
    }

    // Returns the name of the quiz type.
    public String getName() {
        return name;
    }

    //Returns the string representation of the quiz type.
    @Override
    public String toString() {
        return name;
    }
}
