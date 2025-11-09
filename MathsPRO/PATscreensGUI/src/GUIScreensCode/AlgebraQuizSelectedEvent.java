package GUIScreensCode;

import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 *
 * @author alexv
 */
public class AlgebraQuizSelectedEvent extends EventObject {

    // Constructor to create a new event with the source of the event
    public AlgebraQuizSelectedEvent(Object source) {
        super(source);
    }

    public interface AlgebraQuizSelectedListener {

         // Method to be implemented by listeners to handle the event
        void algebraQuizSelected(AlgebraQuizSelectedEvent event);
    }

// ProfileScreen implements the listener interface
    public class ProfileScreen implements AlgebraQuizSelectedListener {
        // Implement method to handle event

        @Override
        public void algebraQuizSelected(AlgebraQuizSelectedEvent event) {
          //  unlockAlgebraBadge(); // Unlock algebra badge visibility
        }
    }

// QuizSelectionScreen fires the event
    public class QuizSelectionScreen {

        private List<AlgebraQuizSelectedListener> listeners = new ArrayList<>();

        public void addAlgebraQuizSelectedListener(AlgebraQuizSelectedListener listener) {
            listeners.add(listener);
        }

        // Method to fire the event and notify all listeners
        private void fireAlgebraQuizSelectedEvent() {
            AlgebraQuizSelectedEvent event = new AlgebraQuizSelectedEvent(this);
            for (AlgebraQuizSelectedListener listener : listeners) {
                listener.algebraQuizSelected(event);
            }
        }

        // Method to handle algebra quiz selection
        public void selectAlgebraQuiz() {
            // Perform selection logic
            fireAlgebraQuizSelectedEvent(); // Notify listeners (ProfileScreen)
        }
    }
}
