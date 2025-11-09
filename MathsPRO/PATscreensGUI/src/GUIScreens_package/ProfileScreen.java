/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIScreens_package;

import GUIScreensCode.AchievementPanel;
import GUIScreensCode.AlgebraQuizListener;
import GUIScreensCode.FrameUtils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author alexv
 */
public class ProfileScreen extends javax.swing.JFrame {

    private JPanel mainPanel;
    private JButton achievementButton;
    private AchievementPanel achievementPanel;
    private Map<String, Boolean> achievementsMap;
    private QuizSelectionScreen.AlgebraQuizListener Listener;
    private QuizSelectionScreen.AlgebraQuizListener algebraQuizListener;

    /**
     * Creates new form ProfileScreen
     */
    public ProfileScreen() {

        initComponents();

        loadBadges();
        FrameUtils.addFrame(this);
        applySavedBackgroundColor();

        setTitle("Profile Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        achievementButton = new JButton("Show Achievements");
        achievementPanel = new AchievementPanel();

        achievementsMap = new HashMap<>();
        achievementsMap.put("Settings Achievement", false);
        achievementsMap.put("Leaderboard Achievement", false);
        achievementsMap.put("Quiz Selection Achievement", false);

        AchievementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AchievementButtonActionPerformed(evt);
            }
        });

        // Add components to main panel
        mainPanel.add(achievementButton, BorderLayout.NORTH);
        mainPanel.add(achievementPanel, BorderLayout.CENTER);

        AlgebraBadge.setVisible(true);
        BODMASBadge.setVisible(true);
        TimesTablesImage.setVisible(true);
        pack();
        setLocationRelativeTo(null);
        //applyAchievementVisibility();

    }

    public void setAlgebraBadgeVisible(boolean visible) {
        AlgebraBadge.setVisible(visible);
        saveBadgeState("algebraBadgeVisible", visible);
    }

    public void setBodmasBadgeVisible(boolean visible) {
        BODMASBadge.setVisible(visible);
        saveBadgeState("bodmasBadgeVisible", visible);
    }

    public void setTimesTablesBadgeVisible(boolean visible) {
        TimesTablesImage.setVisible(visible);
        saveBadgeState("timesTablesBadgeVisible", visible);
    }

    private void saveBadgeState(String key, boolean value) {
        Preferences prefs = Preferences.userNodeForPackage(ProfileScreen.class);
        prefs.putBoolean(key, value);
    }

    private void loadBadges() {
        Preferences prefs = Preferences.userNodeForPackage(ProfileScreen.class);
        AlgebraBadge.setVisible(prefs.getBoolean("algebraBadgeVisible", false));
        BODMASBadge.setVisible(prefs.getBoolean("bodmasBadgeVisible", false));
        TimesTablesImage.setVisible(prefs.getBoolean("timesTablesBadgeVisible", false));
    }

    /**
     * Apply saved preferences for background color to the frame.
     */
    private void applySavedPreferences() {
        // Apply saved preferences for badge visibility
        Preferences prefs = Preferences.userNodeForPackage(ProfileScreen.class);
        boolean algebraBadgeVisible = prefs.getBoolean("algebraBadgeVisible", false);
        AlgebraBadge.setVisible(algebraBadgeVisible);
    }

    /**
     * Handle event when algebra quiz is selected, unlocking the algebra badge.
     */
    public void onAlgebraQuizSelected() {
        unlockAlgebraBadge(); // Handle algebra quiz selection event
    }

    public void unlockAlgebraBadge() {
        AlgebraBadge.setVisible(true); // Set algebra badge visible

    }

    /**
     * Check if algebra badge is unlocked based on preferences.
     *
     * @return True if algebra badge is unlocked, false otherwise.
     */
    public boolean isAlgebraBadgeUnlocked() {
        Preferences prefs = Preferences.userNodeForPackage(ProfileScreen.class);
        return prefs.getBoolean("algebraBadgeVisible", false);
    }

    /**
     * Apply visibility preferences for achievements.
     */
    private void applyAchievementVisibility() {
        Preferences prefs = Preferences.userNodeForPackage(ProfileScreen.class);
        boolean algebraBadgeVisible = prefs.getBoolean("algebraBadgeVisible", false);

        // Assuming AlgebraBadge is the component representing the algebra badge
        AlgebraBadge.setVisible(algebraBadgeVisible); // Set visibility based on preference
    }

    /**
     * Unlock the specified achievement.
     *
     * @param achievement The achievement to unlock.
     */
    public void unlockAchievement(String achievement) {
        if (achievementsMap.containsKey(achievement)) {
            achievementsMap.put(achievement, true);
        }
    }

    /**
     * Apply saved background color to the frame's content pane.
     */
    private void applySavedBackgroundColor() {
        Color savedColor = FrameUtils.getBackgroundColor();
        changeContainerBackground(this.getContentPane(), savedColor);
    }

    /**
     * Recursively change background color of all components within a container.
     *
     * @param container The container whose components background to change.
     * @param color The color to set as background.
     */
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
        ProfileHeading = new javax.swing.JLabel();
        BadgesHeading = new javax.swing.JLabel();
        ProfileIcon = new javax.swing.JLabel();
        Badge1 = new javax.swing.JLabel();
        Badge2 = new javax.swing.JLabel();
        Badge3 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        AlgebraBadge = new javax.swing.JLabel();
        BODMASBadge = new javax.swing.JLabel();
        TimesTablesImage = new javax.swing.JLabel();
        AchievementButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GreenBackground.setBackground(new java.awt.Color(0, 102, 0));

        ProfileHeading.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        ProfileHeading.setText("My Profile");

        BadgesHeading.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        BadgesHeading.setForeground(new java.awt.Color(255, 102, 0));
        BadgesHeading.setText("Badges:");

        ProfileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ProfileIconCrop.png"))); // NOI18N

        Badge1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Badge1.setText("Badge 1 (Algebra):");

        Badge2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Badge2.setText("Badge 2 (BODMAS):");

        Badge3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Badge3.setText("Badge 3 (Times Tables):");

        BackButton.setBackground(new java.awt.Color(255, 102, 0));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        AlgebraBadge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/AlgebraBadgeCrop.png"))); // NOI18N

        BODMASBadge.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/BodmasBadgeCrop.png"))); // NOI18N

        TimesTablesImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/TimesTableBadge.jpeg"))); // NOI18N

        AchievementButton.setBackground(new java.awt.Color(255, 102, 0));
        AchievementButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AchievementButton.setText("Achievements");
        AchievementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AchievementButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GreenBackgroundLayout = new javax.swing.GroupLayout(GreenBackground);
        GreenBackground.setLayout(GreenBackgroundLayout);
        GreenBackgroundLayout.setHorizontalGroup(
            GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GreenBackgroundLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(BadgesHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(ProfileHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProfileIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addComponent(Badge1)
                        .addGap(18, 18, 18)
                        .addComponent(AlgebraBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addComponent(Badge2)
                                .addGap(31, 31, 31)
                                .addComponent(BODMASBadge))
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addComponent(Badge3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimesTablesImage))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GreenBackgroundLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AchievementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
        );
        GreenBackgroundLayout.setVerticalGroup(
            GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(ProfileIcon)
                .addGap(28, 28, 28)
                .addComponent(AchievementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GreenBackgroundLayout.createSequentialGroup()
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BadgesHeading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ProfileHeading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addComponent(AlgebraBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(BODMASBadge, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Badge1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Badge2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))
                        .addGap(40, 40, 40)
                        .addComponent(Badge3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GreenBackgroundLayout.createSequentialGroup()
                        .addComponent(TimesTablesImage)
                        .addGap(293, 293, 293))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GreenBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(GreenBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        // TODO add your handling code here:
        HomeScreen HomeButton = new HomeScreen();
        HomeButton.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void AchievementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AchievementButtonActionPerformed
        showAchievementPanel();
    }//GEN-LAST:event_AchievementButtonActionPerformed

    //method to show the achievement panel ui
    private void showAchievementPanel() {
        // Update achievements in the achievementPanel
        for (Map.Entry<String, Boolean> entry : achievementsMap.entrySet()) {
            String achievement = entry.getKey();
            boolean unlocked = entry.getValue();
            achievementPanel.updateAchievement(achievement, unlocked);
        }

        // Create a JDialog to show the achievementPanel
        JDialog achievementDialog = new JDialog(this, "Achievements", true); // 'this' refers to ProfileScreen
        achievementDialog.setLayout(new BorderLayout());

        // Add achievement panel to a scroll pane
        JScrollPane scrollPane = new JScrollPane(achievementPanel);
        achievementDialog.add(scrollPane, BorderLayout.CENTER);

        // Create close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                achievementDialog.dispose(); // Close the dialog
            }
        });

        // Add close button to a panel at the bottom
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(closeButton);
        achievementDialog.add(buttonPanel, BorderLayout.SOUTH);

        // Ensure the dialog closes properly on close
        achievementDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Set dialog size
        achievementDialog.setSize(new Dimension(400, 300)); // Adjust size as needed

        achievementDialog.pack();
        achievementDialog.setLocationRelativeTo(this); // Center dialog relative to ProfileScreen
        achievementDialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //create profileScreen instance
        ProfileScreen profileScreen = new ProfileScreen();

        // Define the listener for Algebra quiz
        AlgebraQuizListener algebraQuizListener = new AlgebraQuizListener() {
            @Override
            public void onAlgebraQuizSelected() {
                profileScreen.setAlgebraBadgeVisible(true);
            }
        };

        QuizSelectionScreen quizSelectionScreen = new QuizSelectionScreen(profileScreen, (QuizSelectionScreen.AlgebraQuizListener) algebraQuizListener);
        // Set ProfileScreen as the listener for algebra quiz events
        // quizSelectionScreen.setAlgebraQuizListener((AlgebraQuizListener) profileScreen);
        // Simulate selection of algebra quiz
        quizSelectionScreen.selectAlgebraQuiz();

        Preferences prefs = Preferences.userNodeForPackage(ProfileScreen.class);
        boolean algebraBadgeVisible = prefs.getBoolean("algebraBadgeVisible", false);
        if (!prefs.getBoolean("algebraBadgeVisible", false)) {
            prefs.putBoolean("algebraBadgeVisible", false);
        }
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
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfileScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProfileScreen profileScreen = new ProfileScreen();
                new ProfileScreen().setVisible(true);
                AlgebraQuizListener listener = new AlgebraQuizListener() {
                    @Override
                    public void onAlgebraQuizSelected() {
                        profileScreen.setAlgebraBadgeVisible(true);
                    }
                };

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AchievementButton;
    private javax.swing.JLabel AlgebraBadge;
    private javax.swing.JLabel BODMASBadge;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel Badge1;
    private javax.swing.JLabel Badge2;
    private javax.swing.JLabel Badge3;
    private javax.swing.JLabel BadgesHeading;
    private javax.swing.JPanel GreenBackground;
    private javax.swing.JLabel ProfileHeading;
    private javax.swing.JLabel ProfileIcon;
    private javax.swing.JLabel TimesTablesImage;
    // End of variables declaration//GEN-END:variables
}
