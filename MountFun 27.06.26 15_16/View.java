import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JComponent implements Figurenbeobachter,Hindernisbeobachter
{   private Spielfigur_model spielfigur;
    private Spielfigur_view spielfigur_view;
    private Hindernis_model hindernisse;
    private String Dateipfad;
    protected JFrame fenster;
    private JLayeredPane panel;
    private ArrayList<Hindernis_view> views;
    private ArrayList<Hindernis_view> baumrand;
    private Highscore_view highscore;

    public View(Spielfigur_model s, Hindernis_model h){
        spielfigur= s; 
        s.anmelden(this);   
        setFocusable(true);

        views= new ArrayList<>();
        baumrand = new ArrayList<>();
        hindernisse = h;
        h.anmelden(this);
        setFocusable(true);

        fenster = new JFrame();
        fenster.add(this);
        fenster.setSize(1920,1080);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setVisible(true);
        fenster.setResizable(false);

        panel = new JLayeredPane();
        panel.setLayout(null);  

        fenster.setContentPane(panel);
        fenster.setVisible(true);

        Dateipfad = System.getProperty("user.dir")+"\\Bilder\\";
        HintergrundFestlegen();
    }

    /**
     * der Hintergund ohne Bäume wird hier generiert und der Punktmesser(score) eingefügt
     * anhand von DEFAULT_LAYER wird das Bild in den Hintergrund verschoben 
     */
    public void HintergrundFestlegen(){
        ImageIcon icon = new ImageIcon(Dateipfad + "Hintergrund_ohne_Bäume.png");
        JLabel l1 = new JLabel(icon);
        l1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // Position festlegen
        System.out.println(Dateipfad);
        panel.setLayout(null);
        panel.add(l1,JLayeredPane.DEFAULT_LAYER);
        fenster.setContentPane(panel);
        fenster.setVisible(true);
        highscore = new Highscore_view(panel,Dateipfad);
    }

    public Baum_view baumHinzufügen(int x,int y) {
        /*
         *@param Baum wird erstellt
         */
        Baum_view Baum = new Baum_view(panel,Dateipfad,x,y);
        return Baum;
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

    /**
     * Erzeugt das Objekt GameOver der Klasse GameOver_view
     * @param x X-Koordinate des GameOver-Schriftzugs
     * @param y Y-Koordinate des GameOver-Schriftzugs
     */
    public GameOver_view GameOverHinzufügen(int x,int y) {
        GameOver_view GameOver = new GameOver_view(panel,Dateipfad,x,y);
        return GameOver;
    }

    public void highscoreSetzen(int h){
        highscore.highscoreSetzen(h);
    }

    public void Hinzufügen(Hindernis_view h){
        views.add(h);
    }

    public void spielfigurErstellen(){
        spielfigur_view = new Spielfigur_view(panel,Dateipfad,spielfigur.getX(),spielfigur.getY(),spielfigur);
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

    public void entferneHindernis(Hindernis_model m){
        for (Hindernis_view view : views) {
            if (view.getModel() == m) {
                panel.remove(view.getL1());
                views.remove(view);
                panel.revalidate();
                panel.repaint();
                break;
            }
        }
    }

    public void entferneBaum(Hindernis_view v){
        panel.remove(v.getL1());
        views.remove(v);
        panel.revalidate();
        panel.repaint();
    }

    /**
     * Die Münze wird hier entfernt,wobei sie aus der Hindernisliste views genommen wird.
     * Das panel muss nach dem Entfernen der Münze neu geladen werden.
     * @param m Münze, welche eine der Unterklassen der Klasse Hindernis_model angehört 
     */
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

    public ArrayList<Hindernis_view> getBaumrand(){
        return baumrand;
    }
}