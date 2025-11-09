

/**
 *
 * @author Alex von Allemann 12.5
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BackgroundColorChanger {
    public static void setBackgroundColor(JFrame frame, Color color) {
        frame.getContentPane().setBackground(color);
        setComponentBackground(frame.getContentPane(), color);
    }

    public static void setBackgroundColor(JPanel panel, Color color) {
        panel.setBackground(color);
        setComponentBackground(panel, color);
    }

    private static void setComponentBackground(Component component, Color color) {
        if (component instanceof JPanel) {
            JPanel panel = (JPanel) component;
            for (Component child : panel.getComponents()) {
                setComponentBackground(child, color);
            }
        }
    }
}
