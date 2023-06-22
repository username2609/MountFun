import javax.swing.*;
import java.awt.*;

public class Spielfigur_view 
{   
    private Spielfigur_model sp;
    private JLayeredPane panel;
    private JLabel l1;
    private JLabel r1;
    protected int x,y;
    private String Dateipf ;
    public Spielfigur_view(JLayeredPane panelNeu, String Dateipfad,int x, int y,Spielfigur_model s) {
        Dateipf=Dateipfad;
        panel=panelNeu;
        ImageIcon iconl = new ImageIcon(Dateipfad + "Ski-Pinguin_links.png");
        Image Bildl = iconl.getImage().getScaledInstance(98, 171, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBildl = new ImageIcon(Bildl);
        l1 = new JLabel(skaliertesBildl);
        l1.setBounds(x, y, iconl.getIconWidth(), iconl.getIconHeight());
        sp = s;
        ImageIcon iconr = new ImageIcon(Dateipfad + "Ski-Pinguin_rechts.png");
        Image Bildr = iconr.getImage().getScaledInstance(98, 171, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBildr = new ImageIcon(Bildr);
        r1 = new JLabel(skaliertesBildr);
        r1.setBounds(x, y, iconr.getIconWidth(), iconr.getIconHeight());
        panel.add(l1,JLayeredPane.PALETTE_LAYER);
        panel.add(r1,JLayeredPane.PALETTE_LAYER);
        r1.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    public void bildLinks(){
        r1.setVisible(false);
        l1.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    public void bildRechts(){
        r1.setVisible(true);
        l1.setVisible(false);
        panel.revalidate();
        panel.repaint();
    }

    public void spielfigurPositionAktualisieren(int xNeu,int yNeu){
        l1.setLocation(xNeu,yNeu);
        r1.setLocation(xNeu,yNeu);
        if(sp.getOrientierung()=="Links"){
            bildLinks();
        }
        else{
            bildRechts();
        }

    }
}
