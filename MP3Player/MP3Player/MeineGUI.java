// Importiert alle Klassen aus den wichtigsten Paketen zur GUI-Entwicklung
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Definiert eine neue Klasse als Unterklasse von JFrame
public class MeineGUI extends JFrame implements ActionListener, MusicPlayerListener
{
    private JLabel percent;
    private JButton setButton;
    private JButton stopButton;
    private JButton playButton;
    private MusicPlayer player;
    private JTextField sTitleTextField;
    public MeineGUI()
    {
        player = new MusicPlayer();
        setLayout(new FlowLayout());

        sTitleTextField = new JTextField("Title Name");
        setButton = new JButton("set");
        playButton = new JButton("play");
        stopButton = new JButton("stop");
        percent = new JLabel("0%");

        setButton.addActionListener(this);
        playButton.addActionListener(this);
        stopButton.addActionListener(this);
        player.addListener(this);

        add(sTitleTextField);
        add(setButton);
        add(playButton);
        add(stopButton);
        add(percent);

        setSystemlook();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MeineGUI();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == setButton)
            player.open(sTitleTextField.getText());
        else if(e.getSource() == playButton)
            player.play();
        else if(e.getSource() == stopButton)
            player.stop();
    }

    public void positionChanged(int newPosition)
    {
        percent.setText(newPosition+" %");
    }

    public void setSystemlook(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.out.println("Error setting Look and feel: " + e);
        }
    }

    public void test()
    {
        while(true)
            percent.setText(Integer.toString(player.getPositionInPercent()));
    }
}