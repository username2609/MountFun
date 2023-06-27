import javax.swing.*;
import java.awt.*;

public class Baum_view extends Hindernis_view
{
    private JLabel l1;

    public Baum_view(JLayeredPane panel, String Dateipfad,int x, int y) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Baum.png");
        Image Bild = icon.getImage().getScaledInstance(209, 242, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x-150, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1,JLayeredPane.MODAL_LAYER);
        panel.revalidate();
        panel.repaint();
    }

    @Override public JLabel getL1(){
        return l1;
    }

    @Override public void ortSetzen(int yNeu){
        l1.setLocation(l1.getX(), yNeu);
    }

    @Override public void baumNachObenRücken(){
        l1.setLocation(l1.getX(),l1.getY()-1);
    }
}