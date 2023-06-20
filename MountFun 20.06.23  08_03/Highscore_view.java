import javax.swing.*;
import java.awt.*;

public class Highscore_view extends Hindernis_view
{
    private JLabel highscorezahl;
    private JLabel highscoretext;
    private int aktuellerhighscore;
    public Highscore_view(JLayeredPane panel, String Dateipfad) {
        ImageIcon icon = new ImageIcon(Dateipfad + "IceScore.png");
        highscoretext= new JLabel(icon);
        highscoretext.setBounds(650,-60,700, 394);
        
        highscorezahl = new JLabel(" : "+aktuellerhighscore);
        highscorezahl.setFont(new Font("Impact", Font.ITALIC, 25));
        highscorezahl.setBounds(930, -113, 700, 394);

        panel.add(highscorezahl,JLayeredPane.POPUP_LAYER );
        panel.add(highscoretext,JLayeredPane.POPUP_LAYER );
        panel.revalidate();
        panel.repaint();

        

    }
    public void highscoreSetzen(int h){
        aktuellerhighscore=h;
        highscorezahl.setText(" : "+aktuellerhighscore);
    }

    
}