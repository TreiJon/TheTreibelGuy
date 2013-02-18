// Importiert alle Klassen aus den wichtigsten Paketen zur GUI-Entwicklung
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Definiert eine neue Klasse als Unterklasse von JFrame
public class MeineGUI extends JFrame implements ActionListener
{
    private JButton updateB;
    private JButton tempB;
    private JButton sCityB;
    private JButton gCityB;
    private JLabel stadtLabel;
    private JLabel tempLabel;
    private String stadt;
    private WeatherStation station;
    private JTextField sCityText;
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    public MeineGUI()
    {
        setSystemlook();
        station = new WeatherStation();
        station.update();
        stadt = "City: "+station.getCityName();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        northPanel = new JPanel();
        centerPanel = new JPanel();
        southPanel = new JPanel();
        setLayout(new BorderLayout());
        stadtLabel = new JLabel(stadt);
        tempLabel = new JLabel(Integer.toString(station.getTemperature()) + "°C");
        gCityB = new JButton("get City");
        gCityB.addActionListener(this);
        add(gCityB, BorderLayout.CENTER);
        sCityText = new JTextField("set City");
        add(sCityText, BorderLayout.WEST);
        sCityB = new JButton("set City");
        sCityB.addActionListener(this);
        add(sCityB, BorderLayout.EAST);
        updateB = new JButton();
        updateB.setIcon(new ImageIcon(getClass().getResource("update12.png")));
        updateB.addActionListener(this);
        //         add(new JTextField("Klicke zum aktualisieren."));
        northPanel.add(stadtLabel);
        northPanel.add(updateB);
        northPanel.add(new JLabel(station.getIcon()));
        centerPanel.add(tempLabel);
        centerPanel.add(sCityText);
        centerPanel.add(sCityB);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new MeineGUI();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == updateB)
            station.update();
        else if(e.getSource() == tempB)
            System.out.println(station.getTemperature());
        else if(e.getSource() == sCityB)
        {
            if(sCityText.getText() != "set City")
            {
                station.setCityName(sCityText.getText());
                stadtLabel.setText(station.getCityName());
                tempLabel.setText(Integer.toString(station.getTemperature()) + "°C");
            }
        }
        else if(e.getSource() == gCityB)
            System.out.println(station.getCityName());
    }

    public void setSystemlook(){
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){
            System.out.println("Error setting Look and feel: " + e);
        }
    }
}