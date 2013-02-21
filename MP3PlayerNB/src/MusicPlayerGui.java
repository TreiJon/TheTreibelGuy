/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.util.*;
import java.io.File;
import javax.swing.JFileChooser;
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
        fastrewButton = new javax.swing.JButton();
        fastForwardButton = new javax.swing.JButton();
        BirthdayButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        euroTextF = new javax.swing.JTextField();
        fröscheTextF = new javax.swing.JTextField();
        kalorienTextF = new javax.swing.JTextField();
        joggenTextF = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MP3Player");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Aramis", 3, 18)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        stopButton.setBackground(new java.awt.Color(0, 0, 0));
        stopButton.setOpaque(false);
        stopButton.setBackground(new Color(0,0,0,0));
        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Stop-Disabled-icon.png"))); // NOI18N
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stopButton);
        stopButton.setBounds(600, 250, 161, 162);

        setButton.setBackground(new java.awt.Color(0, 0, 0));
        setButton.setOpaque(false);
        setButton.setBackground(new Color(0,0,0,0));
        setButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Music-icon.png"))); // NOI18N
        setButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setButtonActionPerformed(evt);
            }
        });
        getContentPane().add(setButton);
        setButton.setBounds(30, 60, 161, 162);

        playResumeButton.setBackground(new java.awt.Color(0, 0, 0));
        playResumeButton.setOpaque(false);
        playResumeButton.setBackground(new Color(0,0,0,0));
        playResumeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Play.png"))); // NOI18N
        playResumeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playResumeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(playResumeButton);
        playResumeButton.setBounds(220, 250, 161, 162);

        positionProgressBar.setBackground(new java.awt.Color(0, 0, 0));
        positionProgressBar.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(positionProgressBar);
        positionProgressBar.setBounds(0, 440, 800, 30);

        fastrewButton.setBackground(new java.awt.Color(0, 0, 0));
        fastrewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FastForward.png"))); // NOI18N
        fastrewButton.setOpaque(false);
        fastrewButton.setBackground(new Color(0,0,0,0));
        fastrewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastrewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(fastrewButton);
        fastrewButton.setBounds(30, 250, 160, 160);

        fastForwardButton.setBackground(new java.awt.Color(0, 0, 0));
        fastForwardButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FastForward1.png"))); // NOI18N
        fastForwardButton.setOpaque(false);
        fastForwardButton.setBackground(new Color(0,0,0,0));
        fastForwardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fastForwardButtonActionPerformed(evt);
            }
        });
        getContentPane().add(fastForwardButton);
        fastForwardButton.setBounds(410, 250, 160, 160);

        BirthdayButton.setBackground(new java.awt.Color(0, 0, 0));
        BirthdayButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gift-5-icon.png"))); // NOI18N
        BirthdayButton.setOpaque(false);
        BirthdayButton.setBackground(new Color(0,0,0,0));
        BirthdayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BirthdayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BirthdayButton);
        BirthdayButton.setBounds(220, 60, 160, 160);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frog.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(420, 60, 130, 160);

        jLabel3.setFont(new java.awt.Font("Title Wave", 2, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Happy-birthday und einen super schönen guten morgen !!!");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 0, 820, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Black Background1.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 500);

        euroTextF.setText("Euro");
        euroTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                euroTextFActionPerformed(evt);
            }
        });
        getContentPane().add(euroTextF);
        euroTextF.setBounds(570, 90, 160, 20);

        fröscheTextF.setText("Frösche");
        fröscheTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fröscheTextFActionPerformed(evt);
            }
        });
        getContentPane().add(fröscheTextF);
        fröscheTextF.setBounds(570, 120, 160, 20);

        kalorienTextF.setText("Kalorien");
        getContentPane().add(kalorienTextF);
        kalorienTextF.setBounds(570, 150, 160, 20);

        joggenTextF.setText("Joggen");
        getContentPane().add(joggenTextF);
        joggenTextF.setBounds(570, 180, 160, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void positionChanged(int newPosition)
    {
       positionProgressBar.setValue(newPosition);
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

    private void fastForwardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastForwardButtonActionPerformed
      p.fastForward();
    }//GEN-LAST:event_fastForwardButtonActionPerformed

    private void fastrewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fastrewButtonActionPerformed
     p.rewind();
    }//GEN-LAST:event_fastrewButtonActionPerformed

    private void BirthdayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BirthdayButtonActionPerformed
//                p.open("C:\Dokumente und Einstellungen\Jonas\Eigene Dateien\Any Video Converter\MP3\Happy Birthday.mp3");
        p.open("Happy Birthday.mp3");
        pop = 1;
    }//GEN-LAST:event_BirthdayButtonActionPerformed

    private void euroTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_euroTextFActionPerformed
//            int e = Integer.parseInt(euroTextF.getText());
//            fröscheTextF.setText(String.valueOf(e*27));
//            kalorienTextF.setText(String.valueOf(()));
    }//GEN-LAST:event_euroTextFActionPerformed

    private void fröscheTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fröscheTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fröscheTextFActionPerformed

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
    private javax.swing.JButton BirthdayButton;
    private javax.swing.JTextField euroTextF;
    private javax.swing.JButton fastForwardButton;
    private javax.swing.JButton fastrewButton;
    private javax.swing.JTextField fröscheTextF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField joggenTextF;
    private javax.swing.JTextField kalorienTextF;
    private javax.swing.JButton playResumeButton;
    private javax.swing.JProgressBar positionProgressBar;
    private javax.swing.JButton setButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}
