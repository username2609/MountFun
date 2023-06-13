import javax.swing.*;
import java.awt.*;

public class Spielfigur_view 
{   
    private Spielfigur_model sp;
    private JPanel panel;
    private JLabel l1;
    private JLabel r1;
    protected int x,y;
    private String Dateipf ;
    public Spielfigur_view(JPanel panelNeu, String Dateipfad,int x, int y,Spielfigur_model s) {
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
        panel.add(l1);
        panel.revalidate();
        panel.repaint();
    }

    public void bildLinks(){
        panel.remove(r1);
        panel.add(l1);
        panel.revalidate();
        panel.repaint();
    }

    public void bildRechts(){
        panel.remove(l1);
        panel.add(r1);
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
