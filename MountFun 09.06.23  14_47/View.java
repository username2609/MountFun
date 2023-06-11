
import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Beschreiben Sie hier die Klasse Hindernis.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class View extends JComponent implements Figurenbeobachter,Hindernisbeobachter
{  protected Spielfigur_model spielfigur;
    protected Spielfigur_view spielfigur_view;
    private Hindernis_model hindernisse;
    private String Dateipfad;
    protected JFrame fenster;
    private JPanel panel;
    protected ArrayList<Hindernis_view> views; 
    private Highscore_view highscore;
    public View(Spielfigur_model s, Hindernis_model h){
        spielfigur= s; 
        s.anmelden(this);   
        setFocusable(true);

        views= new ArrayList<>();
        hindernisse = h;
        h.anmelden(this);
        setFocusable(true);

        fenster = new JFrame();
        fenster.add(this);
        fenster.setSize(1920,1080);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
        fenster.setResizable(false);

        panel = new JPanel();
        panel.setLayout(null);  // oder ein anderes Layout nach Bedarf verwenden

        fenster.setContentPane(panel);
        fenster.setVisible(true);

        Dateipfad= System.getProperty("user.dir")+"\\Bilder\\";
        HintergrundFestlegen();
        
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
        highscore =new Highscore_view(panel);
    }

    
    

    public Hütte_view hütteHinzufügen(int x,int y,Hütte_model hm) {
        Hütte_view Hütte = new Hütte_view(panel,Dateipfad,x,y,hm);
        return Hütte;
    }

    public Schneemann_view schneemannHinzufügen(int x,int y,Schneemann_model sm) {
        Schneemann_view Schneemann = new Schneemann_view(panel,Dateipfad,x,y,sm);
        return Schneemann;
    }

    public Slalomfahne_view slalomfahneHinzufügen(int x,int y,Slalomfahne_model sm) {
        Slalomfahne_view Slalomfahne = new Slalomfahne_view(panel,Dateipfad,x,y,sm);
        return Slalomfahne;
    }
    public Münze_view münzeHinzufügen(int x,int y,Münze_model m) {
        Münze_view münze = new Münze_view(panel,Dateipfad,x,y,m);
        return münze;
    }

    public void highscoreSetzen(int h){
        highscore.highscoreSetzen(h);
    }

    public void Hinzufügen(Hindernis_view h){
        views.add(h);
    }

    public void spielfigurErstellen(){
        spielfigur_view= new Spielfigur_view(panel,Dateipfad,700,100,spielfigur);
    }

    public void SpielfigurGeaendert(){
        spielfigur_view.spielfigurPositionAktualisieren(spielfigur.getX(),spielfigur.getY());
        repaint();
    }

    public void HindernisseGeaendert(){
        for (Hindernis_view h : views){
            h.setY(h.getModel().getY());
            h.ortSetzen(h.getModel().getY());
        }
        repaint();

    }
    public void entferneMünzeView(Hindernis_model m) {
    for (Hindernis_view view : views) {
        if (view instanceof Münze_view) {
            Münze_view münzeView = (Münze_view) view;
            if (münzeView.getModel() == m) {
                panel.remove(münzeView.getL1());
                views.remove(münzeView);
                panel.revalidate();
                panel.repaint();
                break;
            }
        }
    }
}
}
