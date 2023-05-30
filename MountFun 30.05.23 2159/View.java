
import java.util.Random;
import java.awt.*;
import javax.swing.*;
//*import java.util.concurrent.TimeUnit; (möglich)
/**
 * Beschreiben Sie hier die Klasse Hindernis.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class View extends JComponent implements Figurenbeobachter
{  private Spielfigur_model Spielfigur;

    private String Dateipfad;
    protected JFrame fenster;
    private JPanel panel;

    public View(){
        /**Spielfigur= s; 
        s.anmelden(this);   */     
        setFocusable(true);

        fenster = new JFrame();
        fenster.add(this);
        fenster.setSize(1600,900);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
        fenster.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);  // oder ein anderes Layout nach Bedarf verwenden

        fenster.setContentPane(panel);
        fenster.setVisible(true);

        Dateipfad= System.getProperty("user.dir")+"\\Bilder\\";
        HintergrundFestlegen();
        HütteHinzufügen(200,200);
        SchneemannHinzufügen(100,200);
        SlalomfahneHinzufügen(100,100);
        SpielfigurHinzufügen(300,300);
    }

    public void HintergrundFestlegen(){
        ImageIcon icon =new ImageIcon(Dateipfad + "Secret skifahrer Skin.png");
        JLabel l1 = new JLabel(icon);
        l1.setBounds(100, 100, icon.getIconWidth(), icon.getIconHeight()); // Position festlegen
        System.out.println(Dateipfad);
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(l1);
        fenster.setContentPane(panel);
        fenster.setVisible(true);
    }

    public void HütteHinzufügen(int x,int y) {
        Hütte_view Hütte = new Hütte_view(panel,Dateipfad,x,y);
    }

    public void SchneemannHinzufügen(int x,int y) {
        Schneemann_view Schneemann = new Schneemann_view(panel,Dateipfad,x,y);
    }

    public void SlalomfahneHinzufügen(int x,int y) {
        Slalomfahne_view Slalomfahne = new Slalomfahne_view(panel,Dateipfad,x,y);
    }

    public void SpielfigurHinzufügen(int x,int y) {
        Spielfigur_view Spielfigur = new Spielfigur_view(panel,Dateipfad,x,y);
    } 

    public void SpielfigurGeaendert(){
        repaint();
    }

}
