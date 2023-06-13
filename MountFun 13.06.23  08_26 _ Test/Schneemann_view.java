import javax.swing.*;
import java.awt.*;

public class Schneemann_view extends Hindernis_view
{
    private Schneemann_model sm;
    private JLabel l1;
    public Schneemann_view(JPanel panel, String Dateipfad,int x, int y,Schneemann_model smNeu) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Snowman better Hitbox.png");
        Image Bild = icon.getImage().getScaledInstance(95, 202, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1);
        panel.revalidate();
        panel.repaint();
        sm=smNeu;
    }

    @Override public Hindernis_model getModel(){
        return sm;
    }
    @Override public void ortSetzen(int yNeu){
       l1.setLocation(l1.getX(), yNeu);
    }
}
