/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.util.*;
import java.io.File;
import javax.swing.JFileChooser;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
/**
 *
 * @author Jonas
 */
public class MusicPlayerGui extends javax.swing.JFrame implements MusicPlayerListener
 {

    private MusicPlayer p;
    private JFileChooser fileC;
    private int pop;
    private boolean mouse;
    private LinkedList playl;
    
    
    public MusicPlayerGui() {
        LinkedList<String> playList = new LinkedList<String>();
        mouse = false;
        pop = 0;
        p = new MusicPlayer();
        p.addListener(this);
        fileC = new JFileChooser();
        getContentPane().setBackground(Color.black);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        setButton = new javax.swing.JButton();
        playResumeButton = new javax.swing.JButton();
        positionProgressBar = new javax.swing.JProgressBar();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MP3Player");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Aramis", 3, 18)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        stopButton.setBackground(new java.awt.Color(0, 0, 0));
        stopButton.setOpaque(false);
        stopButton.setBackground(new Color(0,0,0,0));
        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Stop-Disabled-icon.png"))); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        setButton.setBackground(new java.awt.Color(0, 0, 0));
        setButton.setOpaque(false);
        setButton.setBackground(new Color(0,0,0,0));
        setButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music-icon.png"))); // NOI18N
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });

        playResumeButton.setBackground(new java.awt.Color(0, 0, 0));
        playResumeButton.setOpaque(false);
        playResumeButton.setBackground(new Color(0,0,0,0));
        playResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Play.png"))); // NOI18N
        playResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playResumeButtonActionPerformed(evt);
            }
        });

        positionProgressBar.setBackground(new java.awt.Color(0, 0, 0));
        positionProgressBar.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(playResumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stopButton)
                .addGap(0, 13, Short.MAX_VALUE))
            .addComponent(positionProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playResumeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(setButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                .addComponent(positionProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void positionChanged(int newPosition)
    {
       positionProgressBar.setValue(newPosition) ;
    }
    
    private void setButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setButtonActionPerformed
            int returnVal = fileC.showOpenDialog(MusicPlayerGui.this);
            if (returnVal == JFileChooser.APPROVE_OPTION)
            {
                File datei = fileC.getSelectedFile();
                p.open(datei.getAbsolutePath());
                p.stop();
//                playList.add
                pop = 1;
            }
    }//GEN-LAST:event_setButtonActionPerformed

    private void playResumeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playResumeButtonActionPerformed
        if(pop != 0)
        {
            if(pop == 1)
            {
                p.play();
                pop = 2;
                playResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pause.png")));
            }
            else if(pop == 2)
            {
                p.pause();
                pop = 3;
                playResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Play.png")));
            }
            else if(pop == 3)
            {
                p.resume();
                pop = 2;
                playResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pause.png")));
            }
        }
    }//GEN-LAST:event_playResumeButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        p.stop();
        playResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Play.png")));
        pop = 1;
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MusicPlayerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicPlayerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicPlayerGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton playResumeButton;
    private javax.swing.JProgressBar positionProgressBar;
    private javax.swing.JButton setButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}