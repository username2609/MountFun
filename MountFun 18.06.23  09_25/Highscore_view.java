import javax.swing.*;
import java.awt.*;

public class Highscore_view extends Hindernis_view
{
    private JLabel highscore;
    private int aktuellerhighscore;
    public Highscore_view(JLayeredPane panel) {
        
        highscore = new JLabel("Score: "+aktuellerhighscore);
        highscore.setBounds(20, 20, 200, 10);

        panel.add(highscore,JLayeredPane.POPUP_LAYER );
        panel.revalidate();
        panel.repaint();

        

    }
    public void highscoreSetzen(int h){
        aktuellerhighscore=h;
        highscore.setText("Highscore: "+aktuellerhighscore);
    }

    
}