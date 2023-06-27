import javax.swing.*;
import java.awt.*;

public class GameOver_view extends Hindernis_view
{
    private JLabel l1;
    private JButton knopf;
    /**
     * Konstruktor der Klasse GameOver_view
     *  das Bild wird erzeugt und in den Vordergrund gerückt
     * @param panel ist für die Reihenfolge der Bild übereinander zuständig.POPUP_LAYER sorgt dafür, dass das Bild im Vordergrund ist
     * @param Dateinpfad ist in der Klasse View deklariert, somit muss dieser nicht mehrfach eingegeben werden und nur der Dateienname der Bilddatei ergänzt werden
     * @param x X-Koordinate des GameOver-Schriftzugs
     * @param y Y-Koordinate des GameOver-Schriftzugs
     */
    public GameOver_view(JLayeredPane panel, String Dateipfad,int x, int y) {
        ImageIcon icon = new ImageIcon(Dateipfad + "GameOver.png");
        Image Bild = icon.getImage().getScaledInstance(295, 38, Image.SCALE_SMOOTH);
        ImageIcon skaliertesBild = new ImageIcon(Bild);
        l1 = new JLabel(skaliertesBild);
        l1.setBounds(x, y, icon.getIconWidth(), icon.getIconHeight());

        panel.add(l1,JLayeredPane.POPUP_LAYER);
        knopf = new JButton("Nochmal Spielen");
        knopf.setBounds(x+70, y + icon.getIconHeight() + 10, 150, 30);

        Font schriftart = new Font("Impact", Font.ITALIC, 16);
        knopf.setFont(schriftart);
        knopf.setOpaque(false);
        knopf.setContentAreaFilled(false);

        panel.add(knopf, JLayeredPane.POPUP_LAYER);
        panel.revalidate();
        panel.repaint();
    }

    public JButton getKnopf(){
        return knopf;
    }
}
