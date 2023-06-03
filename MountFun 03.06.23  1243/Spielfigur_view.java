import javax.swing.*;
import java.awt.*;

public class Spielfigur_view 
{
    private JPanel panel;
    private JLabel l1;
    protected int x,y;
    private String Dateipf ;
    public Spielfigur_view(JPanel panel, String Dateipfad,int x, int y,Spielfigur_model s) {
        ImageIcon icon = new ImageIcon(Dateipfad + "Pinguin_links.png");
        Image Bild = icon.getImage().getScaledInstance(119, 149, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());
        Dateipf=Dateipfad;
        panel.add(l1);
        panel.revalidate();
        panel.repaint();
    }
    /**public void bildLinks(){ //zieht eventuell sehr viel Leistung
        ImageIcon icon = new ImageIcon(Dateipf + "Pinguin_links.png");
        Image Bild = icon.getImage().getScaledInstance(255, 255, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1);
        panel.revalidate();
        panel.repaint();
    }
    public void bildRechts(){
        ImageIcon icon = new ImageIcon(Dateipf + "Pinguin_rechts.png");
        Image Bild = icon.getImage().getScaledInstance(255, 255, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1);
        panel.revalidate();
        panel.repaint();
    }*/
    public void spielfigurPositionAktualisieren(int xNeu,int yNeu){
       l1.setLocation(xNeu,yNeu);
       /**if(xNeu<x){
           bildLinks();
       } 
       else if(xNeu>x){
           bildRechts();
       }*/
    }
}
