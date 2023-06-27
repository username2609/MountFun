import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon.*;

public class GUI
{
    
    private JFrame fenster;
    private JDialog dialog;
    private JLabel highscore;
    private JButton spielen;
    private JPanel hintergrund;
    private String Dateipfad;
    private JLayeredPane panel;
    
    GUI()
    {
        
        fenster = new JFrame ("Spiel");
        fenster.setSize(2000,1200);
        fenster.setVisible(false);
        fenster.setLayout(null);
        
        dialog = new JDialog();
        dialog.setTitle("MountFun");
        dialog.setSize(1920, 1040);
        dialog.setVisible(true);
        
        highscore = new JLabel ("Highscore: ");
        highscore.setBounds(880, 580, 200, 100);
        highscore.setSize(200,40);
        highscore.setVisible(true);
        highscore.setForeground(Color.black);
        highscore.setFont(new Font("Times New Roman",Font.BOLD, 24));
        
        spielen = new JButton ("Spielen");
        spielen.setLocation(705, 460);
        spielen.setSize(500, 70);
        spielen.setVisible(true);
        spielen.setEnabled(true);
        spielen.setBackground(Color.cyan);
        spielen.setForeground(Color.black);
        spielen.setFont(new Font("Times New Roman",Font.BOLD, 26));
        
        hintergrund = new JPanel ();
        hintergrund.setSize(1920, 1040);
        hintergrund.setVisible(true);
        hintergrund.setEnabled(false);
        
        fenster.add(highscore);
        fenster.add(spielen);
        fenster.add(hintergrund);
        
        dialog.add(highscore);
        dialog.add(spielen);
        dialog.add(hintergrund);
        
        spielen.addActionListener(new ActionListener()
        { 
            @Override public void actionPerformed(ActionEvent e)
        { 
            SpielStart.main(null);
        }
        });
        
        Dateipfad = System.getProperty("user.dir")+"\\Bilder\\";
        ImageIcon imageIcon = new ImageIcon(Dateipfad + "Hintergrund.png");
        JLabel imageLabel = new JLabel(imageIcon);
        hintergrund.add(imageLabel);
        panel.setLayout(null);
        panel.add(hintergrund,JLayeredPane.DEFAULT_LAYER);
        fenster.setContentPane(panel);
        fenster.setVisible(true);
} 
}




