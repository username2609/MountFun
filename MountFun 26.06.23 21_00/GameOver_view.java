import javax.swing.*;
import java.awt.*;

public class GameOver_view extends Hindernis_view
{
    private GameOver_model go;
    private JLabel l1;
    
    public GameOver_view(JLayeredPane panel, String Dateipfad,int x, int y,GameOver_model goNeu) {
        ImageIcon icon = new ImageIcon(Dateipfad + "GameOver.png");
        Image Bild = icon.getImage().getScaledInstance(295, 38, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1,JLayeredPane.MODAL_LAYER);
        panel.revalidate();
        panel.repaint();

        go = goNeu;
    }
}
