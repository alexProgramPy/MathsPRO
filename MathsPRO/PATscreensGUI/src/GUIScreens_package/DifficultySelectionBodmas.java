/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUIScreens_package;

import GUIScreensCode.Difficulty;
import GUIScreensCode.FrameUtils;
import GUIScreensCode.QuizType;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JPanel;

/**
 *
 * @author SD10009935 - Alex von Allemann 12-5/K1
 */
public class DifficultySelectionBodmas extends javax.swing.JFrame {

    private ProfileScreen profileScreen; // Reference to the profile screen for navigation
    private QuizSelectionScreen.AlgebraQuizListener Listener;

    public DifficultySelectionBodmas() {
        initComponents();
        getContentPane().setBackground(Color.green); //Green background.
        Color col = new Color(0, 102, 0);
        getContentPane().setBackground(col); //Set background color to green.
        FrameUtils.addFrame(this);
        applySavedBackgroundColor();
        ToolTip.setToolTipText("Higher difficulty means less time! Choose wisely for a challenging experience.");
    }

    /**
     * Applies the saved background color to the JFrame's content pane recursively.
     */
    private void applySavedBackgroundColor() {
        Color savedColor = FrameUtils.getBackgroundColor();
        changeContainerBackground(this.getContentPane(), savedColor);
    }

    /**
     * Recursively changes the background color of a given container and its components.
     * @param container The container to change background color for
     * @param color The color to set as background
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GreenBackground = new javax.swing.JPanel();
        BodmasHeading = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        EasyDifficulty = new javax.swing.JButton();
        MediumDifficulty = new javax.swing.JButton();
        Time8min = new javax.swing.JLabel();
        Time4min = new javax.swing.JLabel();
        Time1min30sec = new javax.swing.JLabel();
        HardDifficulty = new javax.swing.JButton();
        BodmasImage = new javax.swing.JLabel();
        ToolTip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GreenBackground.setBackground(new java.awt.Color(0, 102, 0));

        BodmasHeading.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        BodmasHeading.setText("BODMAS:");

        BackButton.setBackground(new java.awt.Color(255, 102, 0));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        EasyDifficulty.setBackground(new java.awt.Color(255, 102, 0));
        EasyDifficulty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EasyDifficulty.setText("Easy");
        EasyDifficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyDifficultyActionPerformed(evt);
            }
        });

        MediumDifficulty.setBackground(new java.awt.Color(255, 102, 0));
        MediumDifficulty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        MediumDifficulty.setText("Medium");
        MediumDifficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumDifficultyActionPerformed(evt);
            }
        });

        Time8min.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Time8min.setText("Time: 8 minutes");

        Time4min.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Time4min.setText("Time: 4 minutes");

        Time1min30sec.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Time1min30sec.setText("Time: 1 minute 30 seconds");

        HardDifficulty.setBackground(new java.awt.Color(255, 102, 0));
        HardDifficulty.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        HardDifficulty.setText("Hard");
        HardDifficulty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HardDifficultyActionPerformed(evt);
            }
        });

        BodmasImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/BodmasImage.png"))); // NOI18N

        ToolTip.setToolTipText("Choose a quiz category to begin. Each category offers different challenges!\n");

        javax.swing.GroupLayout GreenBackgroundLayout = new javax.swing.GroupLayout(GreenBackground);
        GreenBackground.setLayout(GreenBackgroundLayout);
        GreenBackgroundLayout.setHorizontalGroup(
            GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ToolTip, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BodmasImage, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MediumDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EasyDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(Time8min, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(Time4min, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                                .addComponent(HardDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Time1min30sec))))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(BodmasHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        GreenBackgroundLayout.setVerticalGroup(
            GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GreenBackgroundLayout.createSequentialGroup()
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BodmasHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EasyDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Time8min, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MediumDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Time4min, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(ToolTip, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BodmasImage, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GreenBackgroundLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(GreenBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HardDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Time1min30sec))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GreenBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(GreenBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        QuizSelectionScreen QuizBackButton = new QuizSelectionScreen(profileScreen, Listener);
        QuizBackButton.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void EasyDifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyDifficultyActionPerformed
        // TODO add your handling code here:
        Difficulty selectedDifficulty = Difficulty.EASY;
        QuizAnswerScreen QuizAnswer = new QuizAnswerScreen(selectedDifficulty, QuizType.BODMAS);
        QuizAnswer.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_EasyDifficultyActionPerformed

    private void MediumDifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumDifficultyActionPerformed
        // TODO add your handling code here:
        Difficulty selectedDifficulty = Difficulty.MEDIUM;
        QuizAnswerScreen QuizAnswer = new QuizAnswerScreen(selectedDifficulty, QuizType.BODMAS);
        QuizAnswer.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MediumDifficultyActionPerformed

    private void HardDifficultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HardDifficultyActionPerformed
        // TODO add your handling code here:
        Difficulty selectedDifficulty = Difficulty.HARD;
        QuizAnswerScreen QuizAnswer = new QuizAnswerScreen(selectedDifficulty, QuizType.BODMAS);
        QuizAnswer.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HardDifficultyActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DifficultySelectionBodmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DifficultySelectionBodmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DifficultySelectionBodmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DifficultySelectionBodmas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DifficultySelectionBodmas().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel BodmasHeading;
    private javax.swing.JLabel BodmasImage;
    private javax.swing.JButton EasyDifficulty;
    private javax.swing.JPanel GreenBackground;
    private javax.swing.JButton HardDifficulty;
    private javax.swing.JButton MediumDifficulty;
    private javax.swing.JLabel Time1min30sec;
    private javax.swing.JLabel Time4min;
    private javax.swing.JLabel Time8min;
    private javax.swing.JLabel ToolTip;
    // End of variables declaration//GEN-END:variables
}
