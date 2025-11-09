package GUIScreensCode;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Alex von Allemann 12.5 IT PAT 2024
 */
public class NotificationManagementPanel extends JPanel {

    // UI components for managing notification preferences
    private JCheckBox emailCheckbox;
    private JCheckBox inAppCheckbox;
    private JButton saveButton;
    private JComboBox<String> frequencyComboBox;

    // Constructor to initialize the panel components
    public NotificationManagementPanel() {
        initComponents();
    }

    // Method to initialize the UI components
    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        emailCheckbox = new JCheckBox("Email Notifications");
        inAppCheckbox = new JCheckBox("In-App Notifications");

        add(emailCheckbox);
        add(inAppCheckbox);

        frequencyComboBox = new JComboBox<>(new String[]{"Immediate", "Daily", "Weekly"});
        add(new JLabel("Notification Frequency:"));
        add(frequencyComboBox);

        saveButton = new JButton("Save Preferences");
        saveButton.addActionListener(e -> savePreferences());
        add(saveButton);
    }

    // Method to save the notification preferences
    private void savePreferences() {
        JOptionPane.showMessageDialog(this, "Preferences saved successfuly");
    }

    // Method to set the initial values of the notification preferences
    public void setInitialValues(NotificationPreferences preferences) {
        emailCheckbox.setSelected(preferences.isEmailNotificationsEnabled());
        inAppCheckbox.setSelected(preferences.isInAppNotificationsEnabled());
        frequencyComboBox.setSelectedItem(preferences.getNotificationFrequency());
    }
}
