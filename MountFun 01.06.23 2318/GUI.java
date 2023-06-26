package GUIMFun;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI
{
    
    private JFrame fenster;
    private JDialog dialog;
    private JLabel highscore;
    private JButton anpassung;
    private JButton spielen;
    private JButton hintergrund;
   
    GUI()
    {
        
        fenster = new JFrame ("Spiel");
        fenster.setSize(2000,1200);
        fenster.setVisible(false);
        fenster.setLayout(null);
        fenster.detEnabled(false);
        
        dialog = new JDialog();
        dialog.setTitle("MountFun");
        dialog.setSize(1920, 1040);
        dialog.setVisible(true);
        dialog.setEnabled(false);
        
        anpassung = new JButton ("Anpassung");
        anpassung.setLocation(892,590);
        anpassung.setSize(120, 20);
        anpassung.setVisible(true);
        anpassung.setEnabled(true);
        anpassung.setBackground(Color.blue);
        anpassung.setForeground(Color.black);

        highscore = new JLabel ("Highscore: ");
        highscore.setBounds(90, 10, 200, 100);
        highscore.setVisible(true);
        highscore.setForeground(Color.black);
        
        hintergrund = new JButton ("");
        hintergrund.setSize(1920, 1040);
        hintergrund.setVisible(true);
        hintergrund.setEnabled(false);
        hintergrund.setBackground(Color.blue);
        hintergrund.setLayout(new BorderLayout());
        JLabel Hintergrund = new JLabel (new ImageIcon("C:\\Users\49151\\OneDrive\\Bilder\\Hintergrund (1).png"));
        hintergrund.setLayout(new FlowLayout()); 

        spielen = new JButton ("Spielen");
        spielen.setLocation(800, 520);
        spielen.setSize(300, 40);
        spielen.setVisible(true);
        spielen.setEnabled(true);
        spielen.setBackground(Color.blue);
        spielen.setForeground(Color.black);

        dialog.add(highscore);
        dialog.add(anpassung);
        dialog.add(hintergrund);
        dialog.add(spielen);
        
        fenster.add(highscore);
        fenster.add(anpassung);
        fenster.add(hintergrund);
        fenster.add(spielen);
        
}

} 



