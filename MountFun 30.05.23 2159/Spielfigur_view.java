import javax.swing.*;
import java.awt.*;

public class Spielfigur_view 
{
    private JPanel panel;


    public Spielfigur_view(JPanel panel, String Dateipfad,int x, int y) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Pinguin.png");
        Image Bild = icon.getImage().getScaledInstance(255, 255, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        JLabel l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());


         panel.add(l1);
        panel.revalidate();
        panel.repaint();
    }

}
