package GUIScreensCode;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alexv
 * AchievementPanel class for displaying achievements in a JPanel.
 * Each achievement is represented by a JCheckBox and a label.
 * This class uses a BoxLayout for arranging achievements vertically.
 */
public class AchievementPanel extends JPanel {

    private Map<String, JCheckBox> achievementCheckBoxes;

    // Constructor to initialize the panel and achievements
    public AchievementPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setBackground(Color.white);

        achievementCheckBoxes = new HashMap<>();

        // Initialize achievement labels
        initializeAchievements();
    }

    // Method to initialize the achievements by adding them to the panel
    private void initializeAchievements() {
        addAchievement("Settings Achievement", false);
        addAchievement("Leaderboard Achievement", false);
        addAchievement("Quiz Selection Achievement", false);
    }

    // Method to add an achievement to the panel
    private void addAchievement(String achievementName, boolean unlocked) {
        JPanel achievementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(unlocked);
        achievementCheckBoxes.put(achievementName, checkBox);
        achievementPanel.add(checkBox);

        JLabel achievementLabel = new JLabel(achievementName);
        achievementLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        achievementLabel.setForeground(Color.black);
        achievementPanel.add(achievementLabel);

        add(achievementPanel);
    }

    // Method to update the state of an achievement (locked or unlocked)
    public void updateAchievement(String achievement, boolean unlocked) {
        JCheckBox checkBox = achievementCheckBoxes.get(achievement);
        if (checkBox != null) {
            // Update the checkbox state
            checkBox.setSelected(unlocked);
        }
    }
}
