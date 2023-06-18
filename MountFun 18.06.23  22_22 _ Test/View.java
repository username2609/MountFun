import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JComponent implements Figurenbeobachter, Hindernisbeobachter {
    protected Spielfigur_model spielfigur;
    protected Spielfigur_view spielfigur_view;
    private Hindernis_model hindernisse;
    private String dateipfad;
    protected JFrame fenster;
    private JLayeredPane layeredPane;
    protected ArrayList<Hindernis_view> views;
    private Highscore_view highscore;

    public View(Spielfigur_model s, Hindernis_model h) {
        spielfigur = s;
        s.anmelden(this);
        setFocusable(true);

        views = new ArrayList<>();
        hindernisse = h;
        h.anmelden(this);
        setFocusable(true);

        fenster = new JFrame();
        fenster.setSize(1920, 1080);
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenster.setResizable(false);

        layeredPane = new JLayeredPane();
        fenster.setContentPane(layeredPane);
        layeredPane.setLayout(null); // oder ein anderes Layout nach Bedarf verwenden

        dateipfad = System.getProperty("user.dir") + "\\Bilder\\";

        fenster.setVisible(true);
    }

    public Hintergrund_view hintergrundFestlegen() {
        Hintergrund_view hintergrund = new Hintergrund_view(layeredPane, dateipfad);
        return hintergrund;
    }

    public Hütte_view hütteHinzufügen(int x, int y, Hütte_model hm) {
        Hütte_view hütte = new Hütte_view(layeredPane, dateipfad, x, y, hm);
        return hütte;
    }

    public Schneemann_view schneemannHinzufügen(int x, int y, Schneemann_model sm) {
        Schneemann_view schneemann = new Schneemann_view(layeredPane, dateipfad, x, y, sm);
        return schneemann;
    }

    public Slalomfahne_view slalomfahneHinzufügen(int x, int y, Slalomfahne_model sm) {
        Slalomfahne_view slalomfahne = new Slalomfahne_view(layeredPane, dateipfad, x, y, sm);
        return slalomfahne;
    }

    public Münze_view münzeHinzufügen(int x, int y, Münze_model m) {
        Münze_view münze = new Münze_view(layeredPane, dateipfad, x, y, m);
        return münze;
    }

    public void highscoreSetzen(int h) {
        highscore.highscoreSetzen(h);
    }

    public void Hinzufügen(Hindernis_view h) {
        views.add(h);
    }

    public void spielfigurErstellen() {
        spielfigur_view = new Spielfigur_view(layeredPane, dateipfad, spielfigur.getX(), spielfigur.getY(),
                spielfigur);
    }

    public void SpielfigurGeaendert() {
        spielfigur_view.spielfigurPositionAktualisieren(spielfigur.getX(), spielfigur.getY());
        repaint();
    }

    public void HindernisseGeaendert() {
        for (Hindernis_view h : views) {
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
                    layeredPane.remove(münzeView.getL1());
                    views.remove(münzeView);
                    layeredPane.revalidate();
                    layeredPane.repaint();
                    break;
                }
            }
        }
    }
}