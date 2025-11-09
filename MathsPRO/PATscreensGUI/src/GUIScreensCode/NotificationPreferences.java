package GUIScreensCode;

/**
 *
 * @author Alex von Allemann 12.5 IT PAT 2024
 */
public class NotificationPreferences {

    // Fields to store the user's notification preferences
    private boolean emailNotificationsEnabled = true;
    private String notificationFrequency; // e.g. daily, weekly etc
    private boolean emailOnAppUpdates = true;
    private boolean inAppNotificationsEnabled;

    public boolean isEmailOnAppUpdates() {
        return emailOnAppUpdates;
    }

    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public String getNotificationFrequency() {
        return notificationFrequency;
    }

    public boolean isInAppNotificationsEnabled() {
        return inAppNotificationsEnabled;
    }

    // Sets whether the user wants to receive emails on app updates.
    public void setEmailOnAppUpdates(boolean emailOnAppUpdates) {
        this.emailOnAppUpdates = emailOnAppUpdates;
    }

    //Sets whether the user wants to receive in-app notifications.
    public void setInAppNotificationsEnabled(boolean inAppNotificationsEnabled) {
        this.inAppNotificationsEnabled = inAppNotificationsEnabled;
    }

    //Sets the user's preferred notification frequency.
    public void setNotificationFrequency(String notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    // Sets whether the user wants to receive email notifications.
    public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

}
