package GUIScreens_package;

//All imports required for theme page:
import GUIScreensCode.FrameUtils;
import static GUIScreensCode.FrameUtils.getAllFrames;
import java.awt.Color;
import static java.awt.Color.BLUE;
import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alex VA 12.5 ThemePage
 */
public class ThemePage extends JFrame {

    public ThemePage() {
        initComponents();
        FrameUtils.addFrame(this);
        // Set the initial backgrounds color from FrameUtils
        colorPanel.setBackground(FrameUtils.getBackgroundColor());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorPanel = new javax.swing.JPanel();
        ThemeOptionTitle = new javax.swing.JLabel();
        RedColor = new javax.swing.JButton();
        BlueColor = new javax.swing.JButton();
        YellowColor = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        colorPanel.setBackground(new java.awt.Color(0, 102, 0));

        ThemeOptionTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ThemeOptionTitle.setText("THEME OPTIONS:");

        RedColor.setBackground(new java.awt.Color(204, 0, 0));
        RedColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedColorActionPerformed(evt);
            }
        });

        BlueColor.setBackground(new java.awt.Color(0, 51, 204));
        BlueColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueColorActionPerformed(evt);
            }
        });

        YellowColor.setBackground(new java.awt.Color(204, 204, 0));
        YellowColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YellowColorActionPerformed(evt);
            }
        });

        BackButton.setBackground(new java.awt.Color(255, 102, 0));
        BackButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(255, 102, 0));
        ResetButton.setText("Reset to default");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(ThemeOptionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BlueColor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(YellowColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RedColor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ResetButton)
                        .addGap(37, 37, 37))))
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ResetButton))
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addComponent(ThemeOptionTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RedColor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BlueColor, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(YellowColor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    //Method to change the Panels color
    private void changePanelColor(Color color){
        colorPanel.setBackground(color);
        colorPanel.repaint(); //Repaint panel to show Color Change
    }
    private void RedColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedColorActionPerformed
        //change background color to red
        changeAllPanelsBackground(RED);
    }//GEN-LAST:event_RedColorActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        SettingsScreen SettingsButton = new SettingsScreen();
        SettingsButton.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void BlueColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlueColorActionPerformed
        //change background color to blue
        changeAllPanelsBackground(BLUE);
    }//GEN-LAST:event_BlueColorActionPerformed

    private void YellowColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YellowColorActionPerformed
        //change background color to yellow
        changeAllPanelsBackground(YELLOW);
    }//GEN-LAST:event_YellowColorActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        Color defaultColor = new Color(0, 102, 0);
        changeAllPanelsBackground(defaultColor);
    }//GEN-LAST:event_ResetButtonActionPerformed

    //Method to change all the panels backgrounds
    public static void changeAllPanelsBackground(Color color) {
        FrameUtils.setBackgroundColor(color);
        for (JFrame frame : getAllFrames()) {
            changeContainerBackground(frame.getContentPane(), color);
        }
    }

    //Change containers background
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

    //public static List<JFrame> getAllFrames() {
    //    List<JFrame> frames = new ArrayList<>();
    //   for (Frame frame : Frame.getFrames()) {
    //       if (frame instanceof JFrame) {
    //     frames.add((JFrame) frame);
    //    }
    //  }
    // return frames;
    // }
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton BlueColor;
    private javax.swing.JButton RedColor;
    private javax.swing.JButton ResetButton;
    private javax.swing.JLabel ThemeOptionTitle;
    private javax.swing.JButton YellowColor;
    private javax.swing.JPanel colorPanel;
    // End of variables declaration//GEN-END:variables
}
