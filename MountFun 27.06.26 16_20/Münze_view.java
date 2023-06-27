import javax.swing.*;
import java.awt.*;

public class Münze_view extends Hindernis_view
{
    private Münze_model m;
    private JLabel l1;
    
    public Münze_view(JLayeredPane panel, String Dateipfad,int x, int y,Münze_model mNeu) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Münze.png");
        Image Bild = icon.getImage().getScaledInstance(28, 32, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1,JLayeredPane.MODAL_LAYER);
        panel.revalidate();
        panel.repaint();
        m = mNeu;
    }

    @Override public Hindernis_model getModel(){
        return m;
    }

    @Override public JLabel getL1(){
        return l1;
    }

    @Override public void ortSetzen(int yNeu){
        l1.setLocation(l1.getX(), yNeu);
    }
}
