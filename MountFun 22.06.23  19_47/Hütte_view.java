import javax.swing.*;
import java.awt.*;

public class Hütte_view extends Hindernis_view
{
    private Hütte_model hm;
    private JLabel l1;
    public Hütte_view(JLayeredPane panel, String Dateipfad,int x, int y,Hütte_model hmNeu) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Holzhütte3.png");
        Image Bild = icon.getImage().getScaledInstance(290, 305, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x-150, y, icon.getIconWidth(), icon.getIconHeight());


         panel.add(l1,JLayeredPane.MODAL_LAYER);
        panel.revalidate();
        panel.repaint();
        hm=hmNeu;
    }
    @Override public Hindernis_model getModel(){
        return hm;
    }
    @Override public JLabel getL1(){
        return l1;
    }
    @Override public void ortSetzen(int yNeu){
       l1.setLocation(l1.getX(), yNeu-144);
    }
}
