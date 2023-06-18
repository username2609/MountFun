import javax.swing.*;
import java.awt.*;

public class Hintergrund_view extends Hindernis_view
{
    
    private JLabel l1;
    public Hintergrund_view(JLayeredPane panel, String Dateipfad) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Hintergrund.png");
        Image Bild = icon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(0, 0, icon.getIconWidth()-300, icon.getIconHeight()-300);


        panel.add(l1,JLayeredPane.DEFAULT_LAYER);
        panel.revalidate();
        panel.repaint();
        
    }
    
}
