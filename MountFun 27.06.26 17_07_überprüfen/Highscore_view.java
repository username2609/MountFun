import javax.swing.*;
import java.awt.*;

public class Highscore_view extends Hindernis_view
{
    private JLabel punktestandzahl;
    private JLabel punktestandtext;
    private int aktuellerpunktestand;
    
    public Highscore_view(JLayeredPane panel, String Dateipfad) {
        ImageIcon icon = new ImageIcon(Dateipfad + "IceScore.png");
        punktestandtext= new JLabel(icon);
        punktestandtext.setBounds(650,-60,700, 394);
        
        punktestandzahl = new JLabel(" : "+aktuellerpunktestand);
        punktestandzahl.setFont(new Font("Impact", Font.ITALIC, 25));
        punktestandzahl.setBounds(930, -113, 700, 394);

        panel.add(punktestandzahl,JLayeredPane.POPUP_LAYER );
        panel.add(punktestandtext,JLayeredPane.POPUP_LAYER );
        panel.revalidate();
        panel.repaint();
    }
    
    public void punktestandSetzen(int h){
        aktuellerpunktestand=h;
        punktestandzahl.setText(" : "+aktuellerpunktestand);
    }
}