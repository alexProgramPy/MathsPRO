package GUIScreensCode;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.util.List;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Alex von Allemann 12.5 IT PAT FrameUtils Class
 */
public class FrameUtils {

    // Preferences node for storing and retrieving background color
    private static final Preferences prefs = Preferences.userRoot().node(FrameUtils.class.getName());
    private static final String BACKGROUND_COLOR_KEY = "backgroundColor";
    //private static Color backgroundColor = new Color(0, 102, 0);
    //to retrieve all currently visible JFrame instances
    private static List<JFrame> allFrames = new ArrayList<>();

    /**
     * Adds a JFrame instance to the list of managed frames.
     *
     * @param frame The JFrame instance to add.
     */
    // List to hold all managed JFrame instances
    public static void addFrame(JFrame frame) {
        // allFrames.add(frame);
        //changeContainerBackground(frame.getContentPane(), backgroundColor);
    }

    public static List<JFrame> getAllFrames() {
        List<JFrame> frames = new ArrayList<>();
        for (Frame frame : Frame.getFrames()) {
            if (frame instanceof JFrame) {
                frames.add((JFrame) frame);
            }
        }
        return frames;
    }

    //This method stores the color as an RGB integer value in the preferences.
    public static void setBackgroundColor(Color color) {
        prefs.putInt(BACKGROUND_COLOR_KEY, color.getRGB());
    }

    // The background color stored in preferences.
    public static Color getBackgroundColor() {
        int rgb = prefs.getInt(BACKGROUND_COLOR_KEY, Color.GREEN.getRGB()); // Default to green
        return new Color(rgb);
    }

    /**
     * Changes the background color of all managed JFrame instances.
     *
     * @param color The color to set as the background color.
     */
    //public static void changeAllFramesBackgroundColor(java.awt.Color color) {
    //    for (JFrame frame : allFrames) {
    //       changeContainerBackground(frame.getContentPane(), color);
    //    }
    //  }
    private static void changeContainerBackground(Container container, Color color) {
        for (Component component : container.getComponents()) {
            if (component instanceof JPanel) {
                component.setBackground(color);
            }
            if (component instanceof Container) {
                changeContainerBackground((Container) component, color);
            }
        }

    }
}
